package ec.edu.ups.poo.model;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepositorio {

    public static List<String> obtenerDepartamentos() {
        List<String> departamentos = new ArrayList<>();
        departamentos.add("Finanzas");
        departamentos.add("Recursos Humanos");
        departamentos.add("Tecnología");
        departamentos.add("Producción");
        departamentos.add("Marketing");
        departamentos.add("Ventas");
        departamentos.add("Logística");
        departamentos.add("Atención al Cliente");
        return departamentos;
    }
}
