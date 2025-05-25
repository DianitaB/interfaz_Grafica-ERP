package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.Empleado;
import ec.edu.ups.poo.model.Producto;
import ec.edu.ups.poo.model.Proveedor;
import ec.edu.ups.poo.model.SolicitudCompra;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<SolicitudCompra> listaSolicitudes = new ArrayList<>();
        new VentanaPrincipal(listaProveedores, listaProductos, listaEmpleados, listaSolicitudes);
    }
}
