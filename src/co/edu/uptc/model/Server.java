package co.edu.uptc.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Server {
    private Connection conection;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    private ManagerModel managerModel;

    public Server(String host, int port, ManagerModel managerModel) {
        this.managerModel = managerModel;
        innit(host, port);
        send();
    }

    public void innit(String host, int port){
        conection = new Connection();
        conection.setType("server");
        conection.setPort(port);
        conection.setHost(host);
        conection.connect();
    }
    public void send(){
        try {
            while (true){
                conection.socket =conection.serverSocket.accept();
                dataOutputStream = new DataOutputStream(conection.socket.getOutputStream());
                for (int i = 0; i < 10; i++) {
                    dataOutputStream.writeUTF("hola" + i);
                }
                dataOutputStream.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}