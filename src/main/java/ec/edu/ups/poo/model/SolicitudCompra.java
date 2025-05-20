package ec.edu.ups.poo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolicitudCompra {

    private int idSolicitud;
    private Date fecha;
    private EstadoSolicitud estado;
    private String observaciones;
    private Double total;
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
        this.estado = EstadoSolicitud.SOLICITADO; // por defecto
    }

    public static void registrar(SolicitudCompra solicitud) {
        solicitudes.add(solicitud);
    }

    public static ArrayList<SolicitudCompra> getSolicitudes() {
        return solicitudes;
    }

    public static SolicitudCompra buscarPorId(int id) {
        for (SolicitudCompra s : solicitudes) {
            if (s.getIdSolicitud() == id) {
                return s;
            }
        }
        return null;
    }

    public static void aprobar(int id) {
        SolicitudCompra solicitud = buscarPorId(id);
        if (solicitud != null) {
            solicitud.setEstado(EstadoSolicitud.APROBADO);
        }
    }

    public static void rechazar(int id) {
        SolicitudCompra solicitud = buscarPorId(id);
        if (solicitud != null) {
            solicitud.setEstado(EstadoSolicitud.RECHAZADO);
        }
    }

    @Override
    public String toString() {
        return "ID: " + idSolicitud +
                " Fecha: " + fecha +
                " Estado: " + estado +
                " Observaciones: " + observaciones;
    }
}
