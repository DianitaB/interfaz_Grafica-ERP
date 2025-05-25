package ec.edu.ups.poo.model;


public class Departamento {
    private int id;
    private String depto;

    public Departamento(String depto, int id) {
        this.depto = depto;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }
    @Override
    public String toString() {
        return "\n--Departamento--" +
                "\nid: " + id +
                "\nDepartamento: " + depto;
    }
}
