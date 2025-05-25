package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.Empleado;
import ec.edu.ups.poo.model.DepartamentoRepositorio;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class VentanaEmpleado extends Frame {

    private ArrayList<Empleado> listaEmpleados;

    private Empleado nuevo;
    private Empleado empleado;

    private Panel panelGeneral;
    private Panel panelMenu;
    private Panel panelContenido;
    private Panel formulario;
    private Panel panelBotones;
    private Panel buscar;

    private Dialog dialogo;

    private TextField txtId;
    private TextField txtNombre;
    private TextField txtCorreo;
    private TextField txtTelefono;
    private TextField txtCargo;
    private TextField txtBuscar;

    private Label lblId;
    private Label lblMensaje;

    private Button btnGuardar;
    private Button btnLimpiar;
    private Button btnBuscarId;
    private Button btnCerrar;

    private Choice choiceDepartamento;
    private TextArea area;
    private TextArea resultado;

    private Button btnRegistrar;
    private Button btnListar;
    private Button btnBuscar;

    public VentanaEmpleado(ArrayList<Empleado> listaEmpleados) {

        this.listaEmpleados = listaEmpleados;
        setTitle("Gestión de Empleados");
        setSize(600, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout());

        panelMenu = new Panel(new GridLayout(1, 3));
        panelMenu.setBackground(Color.LIGHT_GRAY);

        btnRegistrar = new Button("Registrar Empleado");
        btnListar = new Button("Listar Empleados");
        btnBuscar = new Button("Buscar por ID");

        panelMenu.add(btnRegistrar);
        panelMenu.add(btnListar);
        panelMenu.add(btnBuscar);

        panelContenido = new Panel(new BorderLayout());
        panelContenido.setBackground(Color.WHITE);

        panelGeneral.add(panelMenu, BorderLayout.NORTH);
        panelGeneral.add(panelContenido, BorderLayout.CENTER);
        add(panelGeneral);

        btnRegistrar.addActionListener(e -> mostrarFormularioRegistro());
        btnListar.addActionListener(e -> mostrarListaEmpleados());
        btnBuscar.addActionListener(e -> mostrarFormularioBusqueda());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void mostrarFormularioRegistro() {
        panelContenido.removeAll();

        formulario = new Panel(new GridLayout(7, 2, 10, 10));
        txtId = new TextField();
        txtNombre = new TextField();
        txtCorreo = new TextField();
        txtTelefono = new TextField();
        choiceDepartamento = new Choice();
        txtCargo = new TextField();

        for (String departamento : DepartamentoRepositorio.obtenerDepartamentos()) {
            choiceDepartamento.add(departamento);
        }

        formulario.add(new Label("ID:"));
        formulario.add(txtId);
        formulario.add(new Label("Nombre:"));
        formulario.add(txtNombre);
        formulario.add(new Label("Correo Electrónico:"));
        formulario.add(txtCorreo);
        formulario.add(new Label("Teléfono:"));
        formulario.add(txtTelefono);
        formulario.add(new Label("Departamento:"));
        formulario.add(choiceDepartamento);
        formulario.add(new Label("Cargo:"));
        formulario.add(txtCargo);

        btnGuardar = new Button("Registrar");
        btnLimpiar = new Button("Limpiar");

        btnGuardar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                String correo = txtCorreo.getText();
                String telefono = txtTelefono.getText();
                String departamento = choiceDepartamento.getSelectedItem();
                String cargo = txtCargo.getText();

                nuevo = new Empleado(id, nombre, correo, telefono, departamento, cargo);
                Empleado.registrar(nuevo);
                txtId.setText("");
                txtNombre.setText("");
                txtCorreo.setText("");
                txtTelefono.setText("");
                txtCargo.setText("");
                choiceDepartamento.select(0);

                mostrarMensaje("Empleado registrado exitosamente.");
            } catch (NumberFormatException ex) {
                mostrarMensaje("ID inválido. Ingrese un número.");
            }
        });

        btnLimpiar.addActionListener(e -> {
            txtId.setText("");
            txtNombre.setText("");
            txtCorreo.setText("");
            txtTelefono.setText("");
            txtCargo.setText("");
            choiceDepartamento.select(0);
        });

        panelBotones = new Panel(new FlowLayout());
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);

        panelContenido.add(formulario, BorderLayout.NORTH);
        panelContenido.add(panelBotones, BorderLayout.SOUTH);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarListaEmpleados() {
        panelContenido.removeAll();

        area = new TextArea();
        for (Empleado e : Empleado.getEmpleados()) {
            area.append(e.toString() + "\n");
        }

        panelContenido.add(area, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarFormularioBusqueda() {
        panelContenido.removeAll();

        buscar = new Panel(new FlowLayout());
        lblId = new Label("Ingrese ID:");
        txtBuscar = new TextField(10);
        btnBuscarId = new Button("Buscar");

        resultado = new TextArea(5, 50);
        resultado.setEditable(false);

        btnBuscarId.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtBuscar.getText());
                empleado = Empleado.buscarPorId(id);

                resultado.setText("");
                if (empleado != null) {
                    resultado.append(empleado.toString());
                } else {
                    resultado.append("Empleado no encontrado.");
                }
            } catch (NumberFormatException ex) {
                resultado.setText("ID inválido.");
            }
        });

        buscar.add(lblId);
        buscar.add(txtBuscar);
        buscar.add(btnBuscarId);

        panelContenido.add(buscar, BorderLayout.NORTH);
        panelContenido.add(resultado, BorderLayout.CENTER);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private void mostrarMensaje(String mensaje) {
        dialogo = new Dialog(this, "Mensaje", true);
        dialogo.setLayout(new FlowLayout());
        dialogo.setSize(300, 100);
        dialogo.setLocationRelativeTo(this);

        lblMensaje = new Label(mensaje);
        btnCerrar = new Button("Cerrar");
        btnCerrar.addActionListener(e -> dialogo.dispose());

        dialogo.add(lblMensaje);
        dialogo.add(btnCerrar);
        dialogo.setVisible(true);
    }
}
