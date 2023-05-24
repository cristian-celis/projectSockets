package co.edu.uptc.model;

import co.edu.uptc.pojo.Data;
import co.edu.uptc.pojo.FigureInformation;
import co.edu.uptc.pojo.PanelInformation;
import com.google.gson.Gson;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.SocketException;

public class Client{
    Connection connection;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    private ManagerModel managerModel;
    private FigureInformation figureInformation;
    private PanelInformation panelInformation;
    private boolean isRunning;

    public Client(String host, int port, ManagerModel managerModel) {
        panelInformation = new PanelInformation();
        this.managerModel = managerModel;
        innit(host, port);
        isRunning = true;
        receive();
    }

    public void innit(String host, int port) {
        connection = new Connection();
        connection.setType("client");
        connection.setPort(port);
        connection.setHost(host);
        connection.connect();
    }

    public void receive() {
        try {
            dataInputStream = new DataInputStream(connection.socket.getInputStream());
            String info;
            while (isRunning) {
                info = dataInputStream.readUTF();
                System.out.println(info);
                //paintPanel(info);
                //dataInputStream.close();
            }
        } catch (SocketException e){
            System.out.println("Se desconecto -> " + e.getCause());
        }
        catch (IOException e) {
            System.out.println("Sucedio algo raro");
            throw new RuntimeException(e);
        }
    }

    private void convertCoor(){
        //right to left. 10, 10, 6, 6
    }

    private void paintPanel(String info){
        Gson gson = new Gson();
        Data data = gson.fromJson(info, Data.class);
        figureInformation = data.getFigureInformation();
        Rectangle rectangle = figureInformation.getRectangle();
        panelInformation.setColor(figureInformation.getColor());
        managerModel.getPresenter().paintPanel();
    }

    public FigureInformation getFigureInformation(){
        return figureInformation;
    }
    public PanelInformation getPanelInformation(){
        return panelInformation;
    }
}