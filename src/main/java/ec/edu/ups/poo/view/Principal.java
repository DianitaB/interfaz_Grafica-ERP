package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.SolicitudCompra;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<SolicitudCompra> listaSolicitudes = new ArrayList<>();
        VentanaPrincipal vision = new VentanaPrincipal(listaSolicitudes);
    }
}
