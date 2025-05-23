package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.EstadoSolicitud;
import ec.edu.ups.poo.model.SolicitudCompra;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

public class VentanaSolicitud extends Frame {


    private Panel panelGeneral;
    private Panel panelMenu;
    private Panel panelContenido;
    private Panel formulario;
    private Panel panelBotones;
    private Panel buscar;
    private Panel panelEstado;

    private Label lbl;
    private Label lblMensaje;

    private Choice estadoChoice;

    private Button btnRegistrar;
    private Button btnListar;
    private Button btnBuscar;
    private Button btnGuardar;
    private Button btnLimpiar;
    private Button btnCambiarEstado;
    private Button btnBuscarId;
    private Button btnCerrar;

    private TextField txtId;
    private TextField txtFecha;
    private TextField txtEstado;
    private TextField txtObservaciones;
    private TextField txtBuscar;
    private TextArea area;
    private TextArea resultado;
    private ArrayList<SolicitudCompra> listaSolicitudes;

    public VentanaSolicitud(ArrayList<SolicitudCompra> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;

        setTitle("Gestión de Solicitudes de Compra");
        setSize(600, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout());

        panelMenu = new Panel(new GridLayout(1, 3));
        panelMenu.setBackground(Color.LIGHT_GRAY);

        btnRegistrar = new Button("Registrar Solicitud");
        btnListar = new Button("Listar Solicitudes");
        btnBuscar = new Button("Buscar por Número");

        panelMenu.add(btnRegistrar);
        panelMenu.add(btnListar);
        panelMenu.add(btnBuscar);

        panelContenido = new Panel(new BorderLayout());
        panelContenido.setBackground(Color.WHITE);

        panelGeneral.add(panelMenu, BorderLayout.NORTH);
        panelGeneral.add(panelContenido, BorderLayout.CENTER);
        add(panelGeneral);

        btnRegistrar.addActionListener(e -> mostrarFormularioRegistro());
        btnListar.addActionListener(e -> mostrarListaSolicitudes());
        btnBuscar.addActionListener(e -> mostrarFormularioBusqueda());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void mostrarFormularioRegistro() {
        panelContenido.removeAll();

        formulario = new Panel(new GridLayout(5, 2, 10, 10));

        txtId = new TextField();
        txtFecha = new TextField(new Date().toString());
        txtFecha.setEditable(false);
        txtEstado = new TextField("SOLICITADO");
        txtEstado.setEditable(false);
        txtObservaciones = new TextField();

        formulario.add(new Label("ID de Solicitud:"));
        formulario.add(txtId);
        formulario.add(new Label("Fecha:"));
        formulario.add(txtFecha);
        formulario.add(new Label("Estado:"));
        formulario.add(txtEstado);
        formulario.add(new Label("Observaciones:"));
        formulario.add(txtObservaciones);

        btnGuardar = new Button("Registrar");
        btnLimpiar = new Button("Limpiar");

        btnGuardar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String observaciones = txtObservaciones.getText();

                SolicitudCompra nueva = new SolicitudCompra();
                nueva.setIdSolicitud(id);
                nueva.setFecha(new Date());
                nueva.setEstado(EstadoSolicitud.SOLICITADO);
                nueva.setObservaciones(observaciones);

                listaSolicitudes.add(nueva);

                txtId.setText("");
                txtFecha.setText(new Date().toString());
                txtEstado.setText("SOLICITADO");
                txtObservaciones.setText("");

                mostrarAlerta("Solicitud registrada exitosamente.");
            } catch (NumberFormatException ex) {
                mostrarAlerta("ID inválido. Ingrese un número.");
            }
        });

        btnLimpiar.addActionListener(e -> {
            txtId.setText("");
            txtFecha.setText(new Date().toString());
            txtEstado.setText("SOLICITADO");
            txtObservaciones.setText("");
        });

        panelBotones = new Panel(new FlowLayout());
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);

        panelContenido.add(formulario, BorderLayout.NORTH);
        panelContenido.add(panelBotones, BorderLayout.SOUTH);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarListaSolicitudes() {
        panelContenido.removeAll();

        area = new TextArea();
        for (SolicitudCompra s : listaSolicitudes) {
            area.append(s.toString() + "\n");
        }

        panelContenido.add(area, BorderLayout.CENTER);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarFormularioBusqueda() {
        panelContenido.removeAll();

        buscar = new Panel(new FlowLayout());
        lbl = new Label("Ingrese ID:");
        txtBuscar = new TextField(10);
        btnBuscarId = new Button("Buscar");

        resultado = new TextArea(5, 50);
        resultado.setEditable(false);

        estadoChoice = new Choice();
        for (EstadoSolicitud estado : EstadoSolicitud.values()) {
            estadoChoice.add(estado.name());
        }

        btnCambiarEstado = new Button("Cambiar Estado");

        btnBuscarId.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtBuscar.getText());
                SolicitudCompra solicitud = buscarSolicitudPorId(id);
                resultado.setText("");

                if (solicitud != null) {
                    resultado.append(solicitud.toString());
                } else {
                    resultado.append("Solicitud no encontrada.");
                }
            } catch (NumberFormatException ex) {
                resultado.setText("ID inválido.");
            }
        });

        btnCambiarEstado.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtBuscar.getText());
                SolicitudCompra solicitud = buscarSolicitudPorId(id);

                if (solicitud != null) {
                    EstadoSolicitud nuevoEstado = EstadoSolicitud.valueOf(estadoChoice.getSelectedItem());
                    solicitud.setEstado(nuevoEstado);
                    resultado.setText(solicitud.toString());
                } else {
                    mostrarAlerta("Solicitud no encontrada.");
                }
            } catch (Exception ex) {
                mostrarAlerta("Error al cambiar el estado.");
            }
        });

        buscar.add(lbl);
        buscar.add(txtBuscar);
        buscar.add(btnBuscarId);

        panelEstado = new Panel(new FlowLayout());
        panelEstado.add(new Label("Nuevo estado:"));
        panelEstado.add(estadoChoice);
        panelEstado.add(btnCambiarEstado);

        panelContenido.add(buscar, BorderLayout.NORTH);
        panelContenido.add(resultado, BorderLayout.CENTER);
        panelContenido.add(panelEstado, BorderLayout.SOUTH);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private SolicitudCompra buscarSolicitudPorId(int id) {
        for (SolicitudCompra solis : listaSolicitudes) {
            if (solis.getIdSolicitud() == id) {
                return solis;
            }
        }
        return null;
    }

    private void mostrarAlerta(String mensaje) {
        Dialog mensajito = new Dialog(this, "Mensaje", true);
        mensajito.setLayout(new FlowLayout());
        mensajito.setSize(300, 100);
        mensajito.setLocationRelativeTo(this);

        lblMensaje = new Label(mensaje);
        btnCerrar = new Button("Cerrar");
        btnCerrar.addActionListener(e -> mensajito.dispose());

        mensajito.add(lblMensaje);
        mensajito.add(btnCerrar);
        mensajito.setVisible(true);

    }
}
