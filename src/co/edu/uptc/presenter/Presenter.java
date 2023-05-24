package co.edu.uptc.presenter;

import co.edu.uptc.model.ManagerModel;
import co.edu.uptc.pojo.FigureInformation;
import co.edu.uptc.pojo.PanelInformation;
import co.edu.uptc.view.ManagerView;

import java.awt.*;

public class Presenter implements Contract.Presenter{
    private ManagerView managerView;
    private ManagerModel managerModel;

    public Presenter(String[] args){
        managerModel = new ManagerModel(this, args);
        managerView = new ManagerView(this);
    }

    @Override
    public void paintPanel() {
        managerView.paintPanel();
    }

    @Override
    public FigureInformation getFigureInformation() {
        return managerModel.getFigureInformation();
    }

    @Override
    public PanelInformation getPanelInformation() {
        return managerModel.getPanelInformation();
    }

    @Override
    public void initConnection() {
        managerModel.initConnection();
    }
}
