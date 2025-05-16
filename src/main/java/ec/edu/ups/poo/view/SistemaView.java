package ec.edu.ups.poo.view;

import java.awt.*;
import java.awt.event.*;

public class SistemaView extends Frame {

    private Panel panelGeneral;

    public SistemaView() {
        setTitle("Sistema de Gestión ERP");
        setSize(800, 600);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        Panel panelSuperior = new Panel(new BorderLayout());
        panelSuperior.setBackground(Color.pink);
        panelSuperior.setPreferredSize(new Dimension(800, 80));

        // Logo (izquierda)
        Panel logoPanel = new Panel();
        logoPanel.add(new Label("LOGO"));

        // Título (centro)
        Panel titlePanel = new Panel();
        Label title = new Label("SISTEMA DE GESTIÓN ERP");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        // Usuario y ayuda (derecha)
        Panel userPanel = new Panel(new GridLayout(2, 1));
        Panel lupa = new Panel(new FlowLayout(FlowLayout.RIGHT));
        lupa.add(new Button("?"));
        lupa.add(new Label("Tu nombre"));

        Panel buscador = new Panel(new FlowLayout(FlowLayout.RIGHT));
        buscador.add(new Label("🔍"));
        buscador.add(new TextField(10));

        userPanel.add(lupa);
        userPanel.add(buscador);

        panelSuperior.add(logoPanel, BorderLayout.WEST);
        panelSuperior.add(titlePanel, BorderLayout.CENTER);
        panelSuperior.add(userPanel, BorderLayout.EAST);


        Panel panelIzquierdo = new Panel(new GridLayout(6, 1));
        panelIzquierdo.setPreferredSize(new Dimension(200, 0));
        panelIzquierdo.setBackground(Color.GRAY);

        Button botonInicio = new Button("Inicio");
        Button botonSolicitudes = new Button("Solicitudes de compra");
        Button botonProductos = new Button("Productos");
        Button botonProveedores = new Button("Proveedores");
        Button botonEmpleados = new Button("Empleados");
        Button botonConfiguracion = new Button("Configuracion");

        Color botonColor = Color.pink;
        botonInicio.setBackground(botonColor);
        botonSolicitudes.setBackground(botonColor);
        botonProductos.setBackground(botonColor);
        botonProveedores.setBackground(botonColor);
        botonEmpleados.setBackground(botonColor);
        botonConfiguracion.setBackground(botonColor);

        // Agregar los actionlistener

        //
         ///

        panelIzquierdo.add(botonInicio);
        panelIzquierdo.add(botonSolicitudes);
        panelIzquierdo.add(botonProductos);
        panelIzquierdo.add(botonProveedores);
        panelIzquierdo.add(botonEmpleados);
        panelIzquierdo.add(botonConfiguracion);

        // Panel de contenido central
        panelGeneral = new Panel();
        panelGeneral.add(new Label("Contenido principal aquí"));

        // Agregar todo al Frame
        add(panelSuperior, BorderLayout.NORTH);
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelGeneral, BorderLayout.CENTER);

        // Cierre del Frame
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    // Clase interna para manejar clics de botones del menú
    private class MenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            panelGeneral.removeAll();
            panelGeneral.add(new Label("Has seleccionado: " + comando));
            panelGeneral.revalidate();
            panelGeneral.repaint();
        }
    }


}
