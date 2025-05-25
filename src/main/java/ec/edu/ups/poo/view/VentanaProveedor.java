package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.Proveedor;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaProveedor extends Frame {

    private ArrayList<Proveedor> listaProveedores;

    private Panel panelGeneral;
    private Panel panelMenu;
    private Panel panelContenido;
    private Panel formulario;
    private Panel panelBotones;

    private Label lblMensaje;

    private Button btnRegistrar;
    private Button btnListar;
    private Button btnGuardar;
    private Button btnLimpiar;
    private Button btnCerrar;

    private TextField txtId;
    private TextField txtNombre;
    private TextField txtCorreo;
    private TextField txtTelefono;
    private TextField txttipo;
    private TextArea areaSalida;

    private Proveedor nuevo;
    private Dialog mensajito;

    public VentanaProveedor(ArrayList<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;

        setTitle("Gestión de Proveedores");
        setSize(600, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout());

        panelMenu = new Panel(new GridLayout(1, 2));
        panelMenu.setBackground(Color.LIGHT_GRAY);

        btnRegistrar = new Button("Registrar Proveedor");
        btnListar = new Button("Listar Proveedores");
        panelMenu.add(btnRegistrar);
        panelMenu.add(btnListar);

        panelContenido = new Panel(new BorderLayout());
        panelContenido.setBackground(Color.WHITE);

        panelGeneral.add(panelMenu, BorderLayout.NORTH);
        panelGeneral.add(panelContenido, BorderLayout.CENTER);
        add(panelGeneral);

        btnRegistrar.addActionListener(e -> mostrarFormularioRegistro());
        btnListar.addActionListener(e -> mostrarListaProveedores());

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
        txtNombre = new TextField();
        txtCorreo = new TextField();
        txtTelefono = new TextField();
        txttipo = new TextField();

        formulario.add(new Label("ID del Proveedor:"));
        formulario.add(txtId);
        formulario.add(new Label("Nombre del Proveedor:"));
        formulario.add(txtNombre);
        formulario.add(new Label("Correo Electrónico:"));
        formulario.add(txtCorreo);
        formulario.add(new Label("Teléfono del Proveedor:"));
        formulario.add(txtTelefono);
        formulario.add(new Label("Tipo de Contribuyente:"));
        formulario.add(txttipo);

        btnGuardar = new Button("Registrar");
        btnLimpiar = new Button("Limpiar");

        btnGuardar.addActionListener(e -> registrarProveedor());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        panelBotones = new Panel(new FlowLayout());
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);

        areaSalida = new TextArea();
        areaSalida.setEditable(false);

        panelContenido.add(formulario, BorderLayout.NORTH);
        panelContenido.add(areaSalida, BorderLayout.CENTER);
        panelContenido.add(panelBotones, BorderLayout.SOUTH);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarListaProveedores() {
        panelContenido.removeAll();

        areaSalida = new TextArea();
        areaSalida.setEditable(false);

        for (Proveedor p : listaProveedores) {
            areaSalida.append(p.toString() + "\n");
        }

        panelContenido.add(areaSalida, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void registrarProveedor() {
        String idTexto = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String correo = txtCorreo.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String tipo = txttipo.getText().trim();

        if (idTexto.isEmpty() || nombre.isEmpty() || correo.isEmpty() ||
                telefono.isEmpty() || tipo.isEmpty()) {
            mostrarAlerta("Por favor, complete todos los campos.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idTexto);
        } catch (NumberFormatException e) {
            mostrarAlerta("ID inválido. Ingrese solo números.");
            return;
        }

        nuevo = new Proveedor(id, nombre, correo, telefono, tipo);
        listaProveedores.add(nuevo);

        areaSalida.setText("Proveedor registrado:\n" + nuevo.toString());
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txttipo.setText("");
    }

    private void mostrarAlerta(String mensaje) {
        mensajito = new Dialog(this, "Mensaje", true);
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
