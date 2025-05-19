package ec.edu.ups.poo.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class VentanaPrincipal extends Frame {
    private Panel panelGeneral;
    private Panel panelTitulo;
    private Panel panelBotones;
    private Panel panelCentro;
    private Button botonSolicitudCompra;
    private Button botonProductos;
    private Button botonEmpleados;
    private Button botonProveedores;
    private Button empleados;
    private Button botonSalir;
    private Label labelTitulo;

    public Panel getPanelGeneral() {
        return panelGeneral;
    }

    public Button getBotonEmpleados() {
        return botonEmpleados;
    }

    public void setBotonEmpleados(Button botonEmpleados) {
        this.botonEmpleados = botonEmpleados;
    }

    public void setPanelGeneral(Panel panelGeneral) {
        this.panelGeneral = panelGeneral;
    }


    public Panel getPanelTitulo() {
        return panelTitulo;
    }

    public void setPanelTitulo(Panel panelTitulo) {
        this.panelTitulo = panelTitulo;
    }

    public Button getBotonSolicitudCompra() {
        return botonSolicitudCompra;
    }

    public void setBotonSolicitudCompra(Button botonSolicitudCompra) {
        this.botonSolicitudCompra = botonSolicitudCompra;
    }

    public Button getBotonProductos() {
        return botonProductos;
    }

    public void setBotonProductos(Button botonProductos) {
        this.botonProductos = botonProductos;
    }

    public Button getBotonProveedores() {
        return botonProveedores;
    }


    public void setBotonProveedores(Button botonProveedores) {
        this.botonProveedores = botonProveedores;
    }

    public Button getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Button empleados) {
        this.empleados = empleados;
    }

    public Button getBotonSalir() {
        return botonSalir;
    }

    public void setBotonSalir(Button botonSalir) {
        this.botonSalir = botonSalir;
    }

    public Label getLabelTitulo() {
        return labelTitulo;
    }

    public void setLabelTitulo(Label labelTitulo) {
        this.labelTitulo = labelTitulo;
    }

    public VentanaPrincipal() {
        setTitle("Sistema ERP");
        setSize(700,700);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout());
        panelGeneral.setBackground(Color.WHITE);

        panelTitulo = new Panel(new GridLayout(1,1));
        panelTitulo.setBackground(new Color(245,245,245));
        labelTitulo = new Label("SISTEMA DE GESTIÓN ERP", Label.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitulo.setForeground(Color.BLACK);
        panelTitulo.add(labelTitulo);

        panelGeneral.add(panelTitulo,BorderLayout.NORTH);


        botonSolicitudCompra = new Button("Solicitudes de Compra");
        botonSolicitudCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaSolicitud();
            }
        });


        botonProductos = new Button("Productos");
        botonProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaProducto();
            }
        });


        botonProveedores = new Button("Proveedores");
        botonProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaProveedor();
            }
        });


        botonEmpleados = new Button("Empleados");
        botonEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaEmpleado();
            }
        });


        botonSalir = new Button("Salir");
        panelBotones = new Panel(new GridLayout(5,1,20,20));
        panelBotones.setBackground(new Color(230,230,230));
        panelBotones.setPreferredSize(new Dimension(300,400));

        panelBotones.add(botonSolicitudCompra);
        panelBotones.add(botonProductos);
        panelBotones.add(botonProveedores);
        panelBotones.add(botonEmpleados);
        panelBotones.add(botonSalir);

        panelCentro = new Panel(new GridLayout());
        panelCentro.setBackground(Color.WHITE);
        panelCentro.add(panelBotones);

        panelGeneral.add(panelTitulo,BorderLayout.NORTH);
        panelGeneral.add(panelCentro,BorderLayout.CENTER);
        add(panelGeneral, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);

    }
}
