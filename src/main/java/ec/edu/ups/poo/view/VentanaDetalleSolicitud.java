package ec.edu.ups.poo.view;

import ec.edu.ups.poo.model.DetalleSolicitud;
import ec.edu.ups.poo.model.Producto;
import ec.edu.ups.poo.model.ResumenDetalle;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaDetalleSolicitud extends Frame {

    private List<Producto> productosDisponibles;
    private List<DetalleSolicitud> detalles;

    private Choice cbProductos;
    private TextField txtCantidad;
    private TextArea areaDetalle;
    private Label lblSubtotal, lblDescuento, lblIva, lblTotal;

    private Button btnAgregar, btnCalcular, btnCerrar;

    public VentanaDetalleSolicitud(List<Producto> productosDisponibles) {
        this.productosDisponibles = productosDisponibles;
        this.detalles = new ArrayList<>();

        setTitle("Detalle de Solicitud");
        setSize(650, 500);
        setLayout(new BorderLayout(10, 10)); // Margen entre paneles
        setBackground(Color.LIGHT_GRAY);

        // Panel Entrada
        Panel panelEntrada = new Panel(new GridLayout(2, 2, 10, 10));
        panelEntrada.setBackground(Color.WHITE);
        panelEntrada.setFont(new Font("Arial", Font.PLAIN, 14));
        panelEntrada.setPreferredSize(new Dimension(400, 70));
        panelEntrada.setBounds(20, 20, 400, 70);
        panelEntrada.setVisible(true);

        cbProductos = new Choice();
        for (Producto p : productosDisponibles) {
            cbProductos.add(p.getNombre());
        }

        txtCantidad = new TextField();
        panelEntrada.add(new Label("Producto:"));
        panelEntrada.add(cbProductos);
        panelEntrada.add(new Label("Cantidad:"));
        panelEntrada.add(txtCantidad);
        add(panelEntrada, BorderLayout.NORTH);

        // Área de Detalles
        areaDetalle = new TextArea();
        areaDetalle.setEditable(false);
        areaDetalle.setBackground(new Color(245, 245, 245));
        areaDetalle.setFont(new Font("Courier New", Font.PLAIN, 12));
        add(areaDetalle, BorderLayout.CENTER);

        // Panel Botones
        Panel panelBotones = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(Color.WHITE);
        btnAgregar = new Button("Agregar");
        btnCalcular = new Button("Calcular Totales");
        btnCerrar = new Button("Cerrar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnCalcular);
        panelBotones.add(btnCerrar);

        add(panelBotones, BorderLayout.SOUTH);

        // Panel Totales
        Panel panelTotales = new Panel(new GridLayout(4, 1, 5, 5));
        panelTotales.setBackground(new Color(220, 240, 255));
        panelTotales.setPreferredSize(new Dimension(180, 100));
        panelTotales.setFont(new Font("Arial", Font.BOLD, 13));

        lblSubtotal = new Label("Subtotal: $0.00");
        lblDescuento = new Label("Descuento: $0.00");
        lblIva = new Label("IVA: $0.00");
        lblTotal = new Label("Total: $0.00");

        panelTotales.add(lblSubtotal);
        panelTotales.add(lblDescuento);
        panelTotales.add(lblIva);
        panelTotales.add(lblTotal);

        add(panelTotales, BorderLayout.EAST);

        // Eventos
        btnAgregar.addActionListener(e -> agregarDetalle());
        btnCalcular.addActionListener(e -> calcularTotales());
        btnCerrar.addActionListener(e -> dispose());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void agregarDetalle() {
        String nombre = cbProductos.getSelectedItem();
        Producto prod = productosDisponibles.stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findFirst().orElse(null);

        try {
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());
            if (prod != null && cantidad > 0) {
                DetalleSolicitud detalle = new DetalleSolicitud(cantidad, prod, null);
                detalles.add(detalle);
                areaDetalle.append(detalle.toString() + "\n");
                txtCantidad.setText("");
            }
        } catch (NumberFormatException ex) {
            areaDetalle.append("Cantidad inválida\n");
        }
    }

    private void calcularTotales() {
        ResumenDetalle resumen = new ResumenDetalle(detalles);
        resumen.calcularSubtotal();
        resumen.calcularDescuento();
        resumen.calcularIva();
        resumen.calcularTotal();

        lblSubtotal.setText("Subtotal: $" + String.format("%.2f", resumen.getSubtotal()));
        lblDescuento.setText("Descuento: $" + String.format("%.2f", resumen.getDescuento()));
        lblIva.setText("IVA: $" + String.format("%.2f", resumen.getIva()));
        lblTotal.setText("Total: $" + String.format("%.2f", resumen.getTotal()));
    }
}
