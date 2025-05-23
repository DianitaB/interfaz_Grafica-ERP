package ec.edu.ups.poo.view;

import java.awt.*;

public class Imagen extends Canvas {
    private Image imagen;

    public Imagen(String path) {
        imagen = Toolkit.getDefaultToolkit().getImage(path);
        setSize(30, 30);
    }

    public void paint(Graphics g) {
        g.drawImage(imagen, 0, 0, 30, 30, this);
    }
}