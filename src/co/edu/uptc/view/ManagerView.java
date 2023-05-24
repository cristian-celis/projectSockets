package co.edu.uptc.view;

import co.edu.uptc.presenter.Contract;

import javax.swing.*;
import java.awt.*;

public class ManagerView extends JFrame implements Contract.View {

    private Contract.Presenter presenter;
    private MyPanel myPanel;
    public ManagerView(Contract.Presenter presenter){
        this.presenter = presenter;
        super.setTitle("Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(214, 234, 248));
        this.setSize(750, 750);
        initComponents();
    }

    private void initComponents(){
        myPanel = new MyPanel(this);
        this.add(myPanel);
    }

    public Contract.Presenter getPresenter(){
        return presenter;
    }

    @Override
    public void paintPanel(){
        myPanel.paintPanel();
    }

}
