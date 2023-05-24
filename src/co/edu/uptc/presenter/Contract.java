package co.edu.uptc.presenter;

import co.edu.uptc.pojo.FigureInformation;
import co.edu.uptc.pojo.PanelInformation;

public interface Contract {

    interface Model{
        FigureInformation getFigureInformation();
        PanelInformation getPanelInformation();
        void initConnection();
    }

    interface Presenter{
        void paintPanel();
        FigureInformation getFigureInformation();
        PanelInformation getPanelInformation();
        void initConnection();
    }

    interface View{
        void paintPanel();
    }
}
