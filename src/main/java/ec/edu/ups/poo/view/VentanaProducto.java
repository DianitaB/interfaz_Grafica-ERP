package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.Proveedor;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaProducto extends Frame {

    private TextField txtId, txtNombre, txtPrecio;
    private Choice proveedorChoice;
    private TextArea areaSalida;

    private ArrayList<Proveedor> proveedores;

    public VentanaProducto(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;

        setTitle("Gestión de Productos");
        setSize(700, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setBackground(Color.LIGHT_GRAY);

        Label titulo = new Label("Gestión de Productos", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        Panel panelFormulario = new Panel(new GridLayout(4, 2, 10, 10));
        panelFormulario.setBackground(Color.WHITE);

        panelFormulario.add(new Label("ID:"));
        txtId = new TextField();
        panelFormulario.add(txtId);

        panelFormulario.add(new Label("Nombre:"));
        txtNombre = new TextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new Label("Precio:"));
        txtPrecio = new TextField();
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new Label("Proveedor:"));
        proveedorChoice = new Choice();
        for (Proveedor p : proveedores) {
            proveedorChoice.add(p.toString());
        }
        panelFormulario.add(proveedorChoice);

        add(panelFormulario, BorderLayout.CENTER);

        areaSalida = new TextArea();
        add(areaSalida, BorderLayout.EAST);

        Panel panelBotones = new Panel(new GridLayout(1, 3, 10, 10));
        Button btnRegistrar = new Button("Registrar");
        Button btnLimpiar = new Button("Limpiar");
        Button btnSalir = new Button("Salir");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnRegistrar.addActionListener(e -> registrarProducto());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnSalir.addActionListener(e -> dispose());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void registrarProducto() {
        try {
            String datos = "📦 Producto Registrado:\n";
            datos += "ID: " + txtId.getText() + "\n";
            datos += "Nombre: " + txtNombre.getText() + "\n";
            datos += "Precio: $" + txtPrecio.getText() + "\n";
            datos += "Proveedor: " + proveedorChoice.getSelectedItem();

            areaSalida.setText(datos);

        } catch (Exception e) {
            areaSalida.setText("Error: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        proveedorChoice.select(0);
        areaSalida.setText("");
    }
}
