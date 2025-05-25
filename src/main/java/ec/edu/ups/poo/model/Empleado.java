package ec.edu.ups.poo.model;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {

    private String departamento;
    private String cargo;

    public Empleado(int id, String nombre, String correo, String telefono, String departamento, String cargo) {
        super(id, nombre, correo, telefono);
        this.departamento = departamento;
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado ID: " + id +
                "\nNombre: " + nombre +
                "\nCorreo: " + correoElectronico +
                "\nTeléfono: " + telefono +
                "\nDepartamento: " + departamento +
                "\nCargo: " + cargo + "]";
    }

    private static java.util.List<Empleado> empleados = new java.util.ArrayList<>();

    public static void registrar(Empleado empleado) {
        empleados.add(empleado);
    }

    public static java.util.List<Empleado> getEmpleados() {
        return empleados;
    }

    public static Empleado buscarPorId(int id) {
        for (Empleado e : empleados) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
