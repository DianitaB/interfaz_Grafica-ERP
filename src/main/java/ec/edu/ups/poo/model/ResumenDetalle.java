package ec.edu.ups.poo.model;
import java.util.List;

public class ResumenDetalle implements Calcular {

    private List<DetalleSolicitud> listaDetalles;
    private double subtotal;
    private double descuento;
    private double iva;
    private double total;

    public ResumenDetalle(List<DetalleSolicitud> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    @Override
    public void calcularSubtotal() {
        subtotal = 0;
        for (DetalleSolicitud det : listaDetalles) {
            subtotal += det.calcularTotal();
        }
    }

    @Override
    public void calcularDescuento() {
        if (subtotal > 100) {
            descuento = subtotal * 0.10;
        } else {
            descuento = 0;
        }
    }

    @Override
    public void calcularIva() {
        iva = (subtotal - descuento) * 0.12;
    }

    @Override
    public void calcularTotal() {
        total = subtotal - descuento + iva;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }
}
