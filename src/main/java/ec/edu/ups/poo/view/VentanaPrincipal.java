package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.Proveedor;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaPrincipal extends Frame {

    private Panel panelGeneral;
    private Panel panelTitulo;
    private Panel panelBotones;
    private Panel panelCentro;
    private Button botonSolicitudCompra;
    private Button botonProductos;
    private Button botonEmpleados;
    private Button botonProveedores;
    private Button botonSalir;
    private Label labelTitulo;

    private ArrayList<Proveedor> listaProveedores;

    public VentanaPrincipal() {
        // inicializar datos de ejemplo
        listaProveedores = new ArrayList<>();
        listaProveedores.add(new Proveedor(1, "HP"));
        listaProveedores.add(new Proveedor(2, "Lenovo"));

        setTitle("Sistema ERP");
        setSize(700, 700);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // panel general
        panelGeneral = new Panel(new BorderLayout());
        panelGeneral.setBackground(Color.WHITE);

        // panel título
        panelTitulo = new Panel(new GridLayout(1, 1));
        panelTitulo.setBackground(new Color(245, 245, 245));
        labelTitulo = new Label("SISTEMA DE GESTIÓN ERP", Label.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitulo.setForeground(Color.BLACK);
        panelTitulo.add(labelTitulo);
        panelGeneral.add(panelTitulo, BorderLayout.NORTH);

        // botones
        botonSolicitudCompra = new Button("Solicitudes de Compra");
        botonProductos = new Button("Productos");
        botonProveedores = new Button("Proveedores");
        botonEmpleados = new Button("Empleados");
        botonSalir = new Button("Salir");

        // eventos
        botonSolicitudCompra.addActionListener(e -> new VentanaSolicitud());

        botonProductos.addActionListener(e -> new VentanaProducto(listaProveedores));

        botonProveedores.addActionListener(e -> new VentanaProveedor());

        botonEmpleados.addActionListener(e -> new VentanaEmpleado());

        botonSalir.addActionListener(e -> System.exit(0));

        // panel botones
        panelBotones = new Panel(new GridLayout(5, 1, 20, 20));
        panelBotones.setBackground(new Color(230, 230, 230));
        panelBotones.setPreferredSize(new Dimension(300, 400));
        panelBotones.add(botonSolicitudCompra);
        panelBotones.add(botonProductos);
        panelBotones.add(botonProveedores);
        panelBotones.add(botonEmpleados);
        panelBotones.add(botonSalir);

        panelCentro = new Panel(new GridLayout());
        panelCentro.setBackground(Color.WHITE);
        panelCentro.add(panelBotones);

        panelGeneral.add(panelCentro, BorderLayout.CENTER);
        add(panelGeneral, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}
