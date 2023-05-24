package co.edu.uptc.view;

import co.edu.uptc.pojo.FigureInformation;

import java.awt.*;

public class MyPanel extends javax.swing.JPanel {
    private ManagerView managerView;

    public MyPanel(ManagerView managerView){
        this.managerView = managerView;
    }
    public void paintPanel(){
        this.repaint();
        Graphics2D graphics = (Graphics2D) this.getGraphics();
        FigureInformation figureInformation = managerView.getPresenter().getFigureInformation();
        this.setBackground(new Color(managerView.getPresenter().getPanelInformation().getColor()));
        Rectangle rectangle = figureInformation.getRectangle();
        graphics.setColor(new Color(figureInformation.getColor()));
        graphics.draw(rectangle);
    }
}
