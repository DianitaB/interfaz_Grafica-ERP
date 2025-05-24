package ec.edu.ups.poo.model;

import java.io.Serializable;

public class Producto implements Serializable {
    private int id;
    private String nombre;
    private double precio;
    private Proveedor proveedor;

    public Producto(int id, String nombre, double precio, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    // Setters (opcional, si planeas modificar los productos luego)
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "ID=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Precio=" + precio +
                ", Proveedor=" + proveedor.getNombre() +
                '}';
    }
}
