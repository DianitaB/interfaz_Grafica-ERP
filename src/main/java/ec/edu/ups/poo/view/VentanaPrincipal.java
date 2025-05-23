package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.SolicitudCompra;

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


    public VentanaPrincipal() {
        setTitle("Sistema ERP");
        setSize(700, 700);
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout());
        panelGeneral.setBackground(Color.BLUE);

        panelTitulo = new Panel(new GridLayout(1, 1));
        panelTitulo.setBackground(Color.BLUE);
        labelTitulo = new Label("SISTEMA DE GESTIÓN ERP", Label.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitulo.setForeground(Color.WHITE);
        panelTitulo.add(labelTitulo);
        panelGeneral.add(panelTitulo, BorderLayout.NORTH);

        botonSolicitudCompra = new Button("Solicitudes de Compra");
        botonProductos = new Button("Productos");
        botonProveedores = new Button("Proveedores");
        botonEmpleados = new Button("Empleados");
        botonSalir = new Button("Salir");

        ArrayList<SolicitudCompra> listaSolicitudes = new ArrayList<>();
        botonSolicitudCompra.addActionListener(e -> new VentanaSolicitud(listaSolicitudes));

        botonProductos.addActionListener(e -> new VentanaProducto(null)); // se pasa null
        botonProveedores.addActionListener(e -> new VentanaProveedor());
        botonEmpleados.addActionListener(e -> new VentanaEmpleado());
        botonSalir.addActionListener(e -> System.exit(0));

        panelBotones = new Panel(new GridLayout(5, 1, 20, 20));
        panelBotones.setBackground(Color.CYAN);
        panelBotones.setPreferredSize(new Dimension(300, 400));
        panelBotones.add(botonSolicitudCompra);
        panelBotones.add(botonProductos);
        panelBotones.add(botonProveedores);
        panelBotones.add(botonEmpleados);
        panelBotones.add(botonSalir);

        panelCentro = new Panel(new GridLayout());
        panelCentro.setBackground(Color.BLUE);
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
