package co.edu.uptc.model;

import co.edu.uptc.pojo.FigureInformation;
import co.edu.uptc.pojo.PanelInformation;
import co.edu.uptc.presenter.Contract;
import co.edu.uptc.presenter.Presenter;
import com.google.gson.Gson;

public class ManagerModel implements Contract.Model {
    private Contract.Presenter presenter;
    private Server server;
    private Client client;
    public ManagerModel(Presenter presenter, String[] args){
        this.presenter = presenter;
        setTypeConnection(args);
    }
    public void setTypeConnection(String[] args){
        String type = args[0];
        if (type.equalsIgnoreCase("server")) {
            server = new Server(args[1], Integer.parseInt(args[2]), this);
        }
        if (type.equalsIgnoreCase("client")) {
            client = new Client(args[1], Integer.parseInt(args[2]), this);
        }
    }
    @Override
    public FigureInformation getFigureInformation() {
        return client.getFigureInformation();
    }

    @Override
    public PanelInformation getPanelInformation() {
        return client.getPanelInformation();
    }

    @Override
    public void initConnection() {
        client.receive();
    }

    public Contract.Presenter getPresenter(){
        return presenter;
    }
}
