package ec.edu.ups.poo.view;

import java.awt.*;

public class SistemaView extends Frame {

    private Panel panelGeneral;
    private Panel panelIzquierdoSuperior;
    private Panel panelSuperiorEste;
    private Panel panelSuperorCentro;
    private Panel panelSuperiorOeste;
    private Panel panelInferior;
    private Panel panelInferiorEste;
    private Panel panelInferiorCentro;
    private Panel panelInferiorOeste;

    public Panel getPanelGeneral() {
        return panelGeneral;
    }

    public void setPanelGeneral(Panel panelGeneral) {
        this.panelGeneral = panelGeneral;
    }



    public Panel getPanelSuperiorEste() {
        return panelSuperiorEste;
    }

    public void setPanelSuperiorEste(Panel panelSuperiorEste) {
        this.panelSuperiorEste = panelSuperiorEste;
    }

    public Panel getPanelSuperorCentro() {
        return panelSuperorCentro;
    }

    public void setPanelSuperorCentro(Panel panelSuperorCentro) {
        this.panelSuperorCentro = panelSuperorCentro;
    }

    public Panel getPanelSuperiorOeste() {
        return panelSuperiorOeste;
    }

    public void setPanelSuperiorOeste(Panel panelSuperiorOeste) {
        this.panelSuperiorOeste = panelSuperiorOeste;
    }

    public Panel getPanelInferior() {
        return panelInferior;
    }

    public void setPanelInferior(Panel panelInferior) {
        this.panelInferior = panelInferior;
    }

    public Panel getPanelInferiorEste() {
        return panelInferiorEste;
    }

    public void setPanelInferiorEste(Panel panelInferiorEste) {
        this.panelInferiorEste = panelInferiorEste;
    }

    public Panel getPanelInferiorCentro() {
        return panelInferiorCentro;
    }

    public void setPanelInferiorCentro(Panel panelInferiorCentro) {
        this.panelInferiorCentro = panelInferiorCentro;
    }

    public Panel getPanelInferiorOeste() {
        return panelInferiorOeste;
    }

    public void setPanelInferiorOeste(Panel panelInferiorOeste) {
        this.panelInferiorOeste = panelInferiorOeste;
    }

    public SistemaView() {
        setTitle("Sistema de Gestión ERP");
        setSize(500,500);
        setBackground(Color.WHITE);
        setVisible(true);
        setLocationRelativeTo(null);

        Panel panelGeneral = new Panel(new BorderLayout());
        panelIzquierdoSuperior =  new Panel(new BorderLayout());
        panelIzquierdoSuperior.setBackground(Color.lightGray);
        panelIzquierdoSuperior.setSize(0,60);

        panelSuperiorOeste =  new Panel(new FlowLayout(FlowLayout.LEFT));
        panelSuperorCentro =  new Panel(new FlowLayout(FlowLayout.CENTER));
        panelSuperiorEste = new Panel(new FlowLayout(FlowLayout.RIGHT));

        panelSuperiorOeste.add(new Label("IMG"));
        panelSuperorCentro.add(new Label("BIENVENIDO AL SISTEMA DE GESTIÓN"));
        panelIzquierdoSuperior.add(panelGeneral);
        panelSuperiorOeste.add(panelGeneral);
        panelSuperorCentro.add(panelGeneral);
        panelSuperiorEste.add(panelGeneral);




    }
}
