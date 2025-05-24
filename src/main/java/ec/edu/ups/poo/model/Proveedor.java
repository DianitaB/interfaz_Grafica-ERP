package ec.edu.ups.poo.model;

import java.io.Serializable;

public class Proveedor implements Serializable {
    private int id;
    private String nombre;


    public Proveedor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "ID=" + id + ", Nombre='" + nombre + "'}";
    }
}
