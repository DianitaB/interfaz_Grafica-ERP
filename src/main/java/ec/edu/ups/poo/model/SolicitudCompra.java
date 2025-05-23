package ec.edu.ups.poo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolicitudCompra {

    private int idSolicitud;
    private Date fecha;
    private EstadoSolicitud estado;
    private String observaciones;
    private List<DetalleSolicitud> detalles;

    private static ArrayList<SolicitudCompra> solicitudes = new ArrayList<>();

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public SolicitudCompra() {
        this.detalles = new ArrayList<>();
        this.fecha = new Date();
        this.estado = EstadoSolicitud.SOLICITADO;
    }
    @Override
    public String toString() {
        return "\nID: " + idSolicitud +
                "\nFecha: " + fecha +
                "\nEstado: " + estado +
                "\nObservaciones: " + observaciones;
    }
}
