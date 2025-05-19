package ec.edu.ups.poo.model;

public class Proveedor {
    private int id;
    private String nombre;

    public Proveedor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String toString() {
        return id + " - " + nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
