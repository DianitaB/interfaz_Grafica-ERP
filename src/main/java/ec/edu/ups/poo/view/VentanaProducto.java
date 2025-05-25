package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.Proveedor;
import ec.edu.ups.poo.model.Producto;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaProducto extends Frame {

    private ArrayList<Proveedor> listaProveedores;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Proveedor> proveedoresEnChoice = new ArrayList<>();

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
    private TextField txtPrecio;
    private Choice proveedorChoice;
    private TextArea areaSalida;

    public VentanaProducto(ArrayList<Proveedor> listaProveedores, ArrayList<Producto> listaProductos) {
        this.listaProveedores = listaProveedores;
        this.listaProductos = listaProductos;

        setTitle("Gestión de Productos");
        setSize(600, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout());

        panelMenu = new Panel(new GridLayout(1, 2));
        panelMenu.setBackground(Color.LIGHT_GRAY);

        btnRegistrar = new Button("Registrar Producto");
        btnListar = new Button("Listar Productos");
        panelMenu.add(btnRegistrar);
        panelMenu.add(btnListar);

        panelContenido = new Panel(new BorderLayout());
        panelContenido.setBackground(Color.WHITE);

        panelGeneral.add(panelMenu, BorderLayout.NORTH);
        panelGeneral.add(panelContenido, BorderLayout.CENTER);
        add(panelGeneral);

        btnRegistrar.addActionListener(e -> mostrarFormularioRegistro());
        btnListar.addActionListener(e -> mostrarListaProductos());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void mostrarFormularioRegistro() {
        panelContenido.removeAll();

        formulario = new Panel(new GridLayout(4, 2, 10, 10));

        txtId = new TextField();
        txtNombre = new TextField();
        txtPrecio = new TextField();
        proveedorChoice = new Choice();

        formulario.add(new Label("ID:"));
        formulario.add(txtId);
        formulario.add(new Label("Nombre:"));
        formulario.add(txtNombre);
        formulario.add(new Label("Precio:"));
        formulario.add(txtPrecio);
        formulario.add(new Label("Proveedor:"));
        formulario.add(proveedorChoice);

        cargarProveedores();

        btnGuardar = new Button("Registrar");
        btnLimpiar = new Button("Limpiar");

        btnGuardar.addActionListener(e -> registrarProducto());
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

    private void mostrarListaProductos() {
        panelContenido.removeAll();

        areaSalida = new TextArea();
        areaSalida.setEditable(false);

        for (Producto p : listaProductos) {
            areaSalida.append(p.toString() + "\n");
        }

        panelContenido.add(areaSalida, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void cargarProveedores() {
        if (proveedorChoice != null) {
            proveedorChoice.removeAll();
            proveedoresEnChoice.clear();

            if (listaProveedores.isEmpty()) {
                proveedorChoice.add("Sin proveedores disponibles");
            } else {
                for (Proveedor p : listaProveedores) {
                    proveedorChoice.add(p.getNombre());
                    proveedoresEnChoice.add(p);
                }
            }
        }
    }

    private void registrarProducto() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombre.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            int index = proveedorChoice.getSelectedIndex();
            if (index >= 0 && index < proveedoresEnChoice.size()) {
                Proveedor proveedorSeleccionado = proveedoresEnChoice.get(index);
                Producto nuevo = new Producto(id, nombre, precio, proveedorSeleccionado);
                listaProductos.add(nuevo);

                areaSalida.setText("Producto registrado:\n" + nuevo.toString());
                limpiarCampos();
            } else {
                mostrarAlerta("Selecciona un proveedor válido.");
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("ID y Precio deben ser numéricos.");
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
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
