package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.EstadoSolicitud;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class VentanaSolicitud extends Frame {
    private TextField txtIdSolicitud;
    private TextField txtFechaSolicitud;
    private Choice choiceEstado;
    private TextArea txtObservaciones;
    private TextField txtTotal;
    private Button btnGuardar;
    private Button btnCancelar;

    private Panel panelFormulario;


    public VentanaSolicitud() {
        setTitle("Solicitud de Compra");
        setSize(700, 700);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);

        Label titulo = new Label("Solicitudes de Compra", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        panelFormulario = new Panel(new GridLayout(5,2,10,10));
        panelFormulario.setBackground(Color.WHITE);
        panelFormulario.setFont(new Font("Arial", Font.PLAIN, 14));
        panelFormulario.setPreferredSize(new Dimension(400, 300));

        panelFormulario.add(new Label("Id Solicitud:"));
        txtIdSolicitud = new TextField();
        panelFormulario.add(txtIdSolicitud);

        panelFormulario.add(new Label("Fecha:"));
        txtFechaSolicitud = new TextField(new Date().toString());
        txtFechaSolicitud.setEditable(false);
        panelFormulario.add(txtFechaSolicitud);

        panelFormulario.add(new Label("Estado:"));
        choiceEstado = new Choice();
        for (EstadoSolicitud estado : EstadoSolicitud.values()) {
            choiceEstado.add(estado.name());
        }
        panelFormulario.add(choiceEstado);

        panelFormulario.add(new Label("Observaciones:"));
        txtObservaciones = new TextArea(3, 30);
        panelFormulario.add(txtObservaciones);

        panelFormulario.add(new Label("Total:"));
        txtTotal = new TextField();
        panelFormulario.add(txtTotal);
        add(panelFormulario, BorderLayout.CENTER);

        Panel panelBotones = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(Color.WHITE);
        btnGuardar = new Button("Guardar");
        btnCancelar = new Button("Cancelar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        add(panelBotones, BorderLayout.SOUTH);



        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
}
