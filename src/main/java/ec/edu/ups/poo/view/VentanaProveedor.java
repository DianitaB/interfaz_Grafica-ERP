package ec.edu.ups.poo.view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaProveedor extends Frame {
    public VentanaProveedor() {
        setTitle("Solicitud de Compra");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);

        // Aquí puedes agregar tus campos, etiquetas, botones
        Label titulo = new Label("Proveedores", Label.CENTER);
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
