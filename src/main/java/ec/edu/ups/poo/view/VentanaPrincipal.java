package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.Empleado;
import ec.edu.ups.poo.model.Producto;
import ec.edu.ups.poo.model.SolicitudCompra;
import ec.edu.ups.poo.model.Proveedor;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaPrincipal extends Frame {
    private ArrayList<Proveedor> listaProveedores;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<SolicitudCompra> listaSolicitudes;



    private Panel panelGeneral;
    private Panel panelTitulo;
    private Panel panelBotones;
    private Panel panelCentro;
    private Button botonSolicitudCompra;
    private Button botonProductos;
    private Button botonDetalles;
    private Button botonEmpleados;
    private Button botonProveedores;
    private Button botonSalir;
    private Label labelTitulo;

    public VentanaPrincipal(ArrayList<Proveedor> listaProveedores,
                            ArrayList<Producto> listaProductos,
                            ArrayList<Empleado> listaEmpleados,
                            ArrayList<SolicitudCompra> listaSolicitudes) {
        this.listaProveedores = listaProveedores;
        this.listaProductos = listaProductos;
        this.listaEmpleados = listaEmpleados;
        this.listaSolicitudes = listaSolicitudes;

        setTitle("Sistema ERP");
        setSize(700, 700);
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout());
        panelGeneral.setBackground(Color.white);

        panelTitulo = new Panel(new GridLayout(1, 1));
        panelTitulo.setBackground(Color.lightGray);
        labelTitulo = new Label("SISTEMA DE GESTIÓN ERP", Label.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitulo.setForeground(Color.WHITE);
        panelTitulo.add(labelTitulo);
        panelGeneral.add(panelTitulo, BorderLayout.NORTH);

        botonSolicitudCompra = new Button("Solicitudes de Compra");
        botonProveedores = new Button("Proveedores");
        botonProductos = new Button("Productos");
        botonDetalles = new Button("Detalles");
        botonEmpleados = new Button("Empleados");
        botonSalir = new Button("Salir");

        botonSolicitudCompra.addActionListener(e -> new VentanaSolicitud(listaSolicitudes, listaProductos));
        botonProveedores.addActionListener(e -> new VentanaProveedor(listaProveedores));
        botonProductos.addActionListener(e -> new VentanaProducto(listaProveedores,listaProductos));
        botonEmpleados.addActionListener(e -> new VentanaEmpleado(listaEmpleados));
        botonDetalles.addActionListener(e -> new VentanaDetalleSolicitud(listaProductos));

        botonSalir.addActionListener(e -> System.exit(0));

        panelBotones = new Panel(new GridLayout(6, 1, 20, 20));
        panelBotones.setBackground(Color.lightGray);
        panelBotones.setPreferredSize(new Dimension(300, 400));
        panelBotones.add(botonSolicitudCompra);
        panelBotones.add(botonProveedores);
        panelBotones.add(botonProductos);
        panelBotones.add(botonDetalles);
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

