package ec.edu.ups.poo.model;

import java.io.Serializable;

public class Proveedor extends Persona  implements Serializable  {
    private String tipoContribuyente;

    public String getTipoContribuyente() {
        return tipoContribuyente;
    }

    public void setTipoContribuyente(String tipoContribuyente) {
        this.tipoContribuyente = tipoContribuyente;
    }

    public Proveedor(int id, String nombre, String correoElectronico, String telefono, String tipoContribuyente) {
        super(id, nombre, correoElectronico, telefono);
        this.tipoContribuyente = tipoContribuyente;

    }

    @Override
    public String toString() {
        return "\nProveedor ID: " + id +
                "\nNombre: " + nombre +
                "\nCorreo: " + correoElectronico +
                "\nTeléfono: " + telefono +
                "\nTipo: " + tipoContribuyente;
    }
}
