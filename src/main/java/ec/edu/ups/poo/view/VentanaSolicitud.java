package ec.edu.ups.poo.view;
import ec.edu.ups.poo.model.EstadoSolicitud;
import ec.edu.ups.poo.model.SolicitudCompra;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class VentanaSolicitud extends Frame {

    private Panel panelGeneral;
    private Panel panelMenu;
    private Panel panelContenido;

    private Button btnRegistrar;
    private Button btnListar;
    private Button btnBuscar;

    private TextField txtId;
    private TextField txtFecha;
    private TextField txtEstado;
    private TextField txtObservaciones;

    public VentanaSolicitud() {
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

        Panel formulario = new Panel(new GridLayout(5, 2, 10, 10));

        txtId = new TextField();
        txtFecha = new TextField(new Date().toString());
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

        Button btnGuardar = new Button("Registrar");
        Button btnLimpiar = new Button("Limpiar");

        btnGuardar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String observaciones = txtObservaciones.getText();

                SolicitudCompra nueva = new SolicitudCompra();
                nueva.setIdSolicitud(id);
                nueva.setFecha(new Date());
                nueva.setEstado(EstadoSolicitud.SOLICITADO);
                nueva.setObservaciones(observaciones);

                SolicitudCompra.registrar(nueva);

                txtId.setText("");
                txtFecha.setText(new Date().toString());
                txtEstado.setText("SOLICITADO");
                txtObservaciones.setText("");

                mostrarMensaje("Solicitud registrada exitosamente.");
            } catch (NumberFormatException ex) {
                mostrarMensaje("ID inválido. Ingrese un número.");
            }
        });

        btnLimpiar.addActionListener(e -> {
            txtId.setText("");
            txtFecha.setText(new Date().toString());
            txtEstado.setText("SOLICITADO");
            txtObservaciones.setText("");
        });

        Panel panelBotones = new Panel(new FlowLayout());
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);

        panelContenido.add(formulario, BorderLayout.NORTH);
        panelContenido.add(panelBotones, BorderLayout.SOUTH);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarListaSolicitudes() {
        panelContenido.removeAll();

        TextArea area = new TextArea();
        for (SolicitudCompra s : SolicitudCompra.getSolicitudes()) {
            area.append(s.toString() + "\n");
        }

        panelContenido.add(area, BorderLayout.CENTER);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarFormularioBusqueda() {
        panelContenido.removeAll();

        Panel buscar = new Panel(new FlowLayout());
        Label lbl = new Label("Ingrese ID:");
        TextField txtBuscar = new TextField(10);
        Button btnBuscarId = new Button("Buscar");

        TextArea resultado = new TextArea(5, 50);
        resultado.setEditable(false);

        btnBuscarId.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtBuscar.getText());
                SolicitudCompra solicitud = SolicitudCompra.buscarPorId(id);

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

        buscar.add(lbl);
        buscar.add(txtBuscar);
        buscar.add(btnBuscarId);

        panelContenido.add(buscar, BorderLayout.NORTH);
        panelContenido.add(resultado, BorderLayout.CENTER);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarMensaje(String mensaje) {
        Dialog dialogo = new Dialog(this, "Mensaje", true);
        dialogo.setLayout(new FlowLayout());
        dialogo.setSize(300, 100);
        dialogo.setLocationRelativeTo(this);

        Label lblMensaje = new Label(mensaje);
        Button btnCerrar = new Button("Cerrar");
        btnCerrar.addActionListener(e -> dialogo.dispose());

        dialogo.add(lblMensaje);
        dialogo.add(btnCerrar);
        dialogo.setVisible(true);
    }
}
