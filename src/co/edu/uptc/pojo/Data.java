package co.edu.uptc.pojo;

public class Data {
    private FigureInformation figureInformation;
    private PanelInformation panelInformation;

    public Data(FigureInformation figureInformation, PanelInformation panelInformation){
        this.figureInformation = figureInformation;
        this.panelInformation = panelInformation;
    }

    public FigureInformation getFigureInformation() {
        return figureInformation;
    }

    public void setFigureInformation(FigureInformation figureInformation) {
        this.figureInformation = figureInformation;
    }

    public PanelInformation getPanelInformation() {
        return panelInformation;
    }

    public void setPanelInformation(PanelInformation panelInformation) {
        this.panelInformation = panelInformation;
    }
}
