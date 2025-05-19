package ec.edu.ups.poo.view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaEmpleado extends Frame {
    public VentanaEmpleado() {
        setTitle("Solicitud de Compra");
        setSize(700, 700);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);

        // Aquí puedes agregar tus campos, etiquetas, botones
        Label titulo = new Label("Empleados", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
