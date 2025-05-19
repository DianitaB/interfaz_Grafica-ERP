package ec.edu.ups.poo.view;

import java.awt.*;
import java.awt.event.*;

public class VentanaSolicitud extends Frame {

    private Panel panelGeneral;
    private Panel panelMenu;
    private Panel panelContenido;
    private Button btnRegistrar;
    private Button btnListar;
    private Button btnBuscar;


    public VentanaSolicitud() {
        setTitle("Gestión de Solicitudes de Compra");
        setSize(600, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout());

        panelMenu = new Panel(new GridLayout(1, 3));
        panelMenu.setBackground(new Color(220, 220, 220));

        btnRegistrar = new Button("Registrar Solicitud");
        btnListar = new Button("Listar Solicitudes");
        btnBuscar = new Button("Buscar por Número");

        panelMenu.add(btnRegistrar);
        panelMenu.add(btnListar);
        panelMenu.add(btnBuscar);

        panelContenido = new Panel();
        panelContenido.setLayout(new BorderLayout());
        panelContenido.setBackground(Color.WHITE);

        panelGeneral.add(panelMenu, BorderLayout.NORTH);
        panelGeneral.add(panelContenido, BorderLayout.CENTER);
        add(panelGeneral);

        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioRegistro();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarListaSolicitudes();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioBusqueda();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void mostrarFormularioRegistro() {
        panelContenido.removeAll();
        Panel registro = new Panel(new GridLayout(4, 2, 10, 10));
        registro.add(new Label("Número de Solicitud:"));
        registro.add(new TextField());
        registro.add(new Label("Departamento:"));
        registro.add(new TextField());
        registro.add(new Label("Fecha:"));
        registro.add(new TextField());
        registro.add(new Label("Descripción:"));
        registro.add(new TextField());
        panelContenido.add(registro, BorderLayout.NORTH);
        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarListaSolicitudes() {
        panelContenido.removeAll();
        TextArea area = new TextArea("Aquí se mostrarán todas las solicitudes...", 10, 50);
        panelContenido.add(area, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarFormularioBusqueda() {
        panelContenido.removeAll();
        Panel buscar = new Panel(new FlowLayout());
        buscar.add(new Label("Ingrese Número de Solicitud:"));
        buscar.add(new TextField(15));
        panelContenido.add(buscar, BorderLayout.NORTH);
        panelContenido.revalidate();
        panelContenido.repaint();
    }
}
