package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.Proveedor;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaProveedor extends Frame {

    private Panel panelGeneral;
    private Panel panelMenu;
    private Panel panelContenido;
    private Panel formulario;
    private Panel panelBotones;
    private Panel buscar;

    private Label lbl;
    private Label lblMensaje;

    private Button btnRegistrar;
    private Button btnListar;
    private Button btnBuscar;
    private Button btnGuardar;
    private Button btnLimpiar;
    private Button btnBuscarId;
    private Button btnCerrar;

    private TextField txtId;
    private TextField txtNombre;
    private TextField txtBuscar;
    private TextArea area;
    private TextArea resultado;

    private ArrayList<Proveedor> listaProveedores;

    public VentanaProveedor() {
        this.listaProveedores = listaProveedores;

        setTitle("Gestión de Proveedores");
        setSize(600, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout());

        panelMenu = new Panel(new GridLayout(1, 3));
        panelMenu.setBackground(Color.LIGHT_GRAY);

        btnRegistrar = new Button("Registrar Proveedor");
        btnListar = new Button("Listar Proveedores");
        btnBuscar = new Button("Buscar por ID");

        panelMenu.add(btnRegistrar);
        panelMenu.add(btnListar);
        panelMenu.add(btnBuscar);

        panelContenido = new Panel(new BorderLayout());
        panelContenido.setBackground(Color.WHITE);

        panelGeneral.add(panelMenu, BorderLayout.NORTH);
        panelGeneral.add(panelContenido, BorderLayout.CENTER);
        add(panelGeneral);

        btnRegistrar.addActionListener(e -> mostrarFormularioRegistro());
        btnListar.addActionListener(e -> mostrarListaProveedores());
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

        formulario = new Panel(new GridLayout(2, 2, 10, 10));

        txtId = new TextField();
        txtNombre = new TextField();

        formulario.add(new Label("ID del Proveedor:"));
        formulario.add(txtId);
        formulario.add(new Label("Nombre del Proveedor:"));
        formulario.add(txtNombre);

        btnGuardar = new Button("Registrar");
        btnLimpiar = new Button("Limpiar");

        btnGuardar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                String nombre = txtNombre.getText().trim();

                if (!nombre.isEmpty()) {
                    Proveedor nuevo = new Proveedor(id, nombre);
                    listaProveedores.add(nuevo);
                    txtId.setText("");
                    txtNombre.setText("");
                    mostrarAlerta("Proveedor registrado exitosamente.");
                } else {
                    mostrarAlerta("Nombre no puede estar vacío.");
                }
            } catch (NumberFormatException ex) {
                mostrarAlerta("ID inválido. Ingrese un número.");
            }
        });

        btnLimpiar.addActionListener(e -> {
            txtId.setText("");
            txtNombre.setText("");
        });

        panelBotones = new Panel(new FlowLayout());
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);

        panelContenido.add(formulario, BorderLayout.NORTH);
        panelContenido.add(panelBotones, BorderLayout.SOUTH);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarListaProveedores() {
        panelContenido.removeAll();

        area = new TextArea();
        for (Proveedor p : listaProveedores) {
            area.append(p.toString() + "\n");
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

        btnBuscarId.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtBuscar.getText());
                Proveedor proveedor = buscarProveedorPorId(id);
                resultado.setText("");

                if (proveedor != null) {
                    resultado.append(proveedor.toString());
                } else {
                    resultado.append("Proveedor no encontrado.");
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

    private Proveedor buscarProveedorPorId(int id) {
        for (Proveedor p : listaProveedores) {
            if (p.getId() == id) {
                return p;
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
