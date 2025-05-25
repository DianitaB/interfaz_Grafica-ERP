package ec.edu.ups.poo.model;

public class DetalleSolicitud {
        private int cantidad;
        private Producto producto;
        private SolicitudCompra solicitud;

        public DetalleSolicitud(int cantidad, Producto producto, SolicitudCompra solicitud) {
            this.cantidad = cantidad;
            this.producto = producto;
            this.solicitud = solicitud;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }

        public SolicitudCompra getSolicitud() {
            return solicitud;
        }

        public void setSolicitud(SolicitudCompra solicitud) {
            this.solicitud = solicitud;
        }
        public double calcularTotal() {
            return cantidad * producto.getPrecio();
        }


        @Override
        public String toString() {
            return producto.getNombre() + " x " + cantidad + " = $" ;
        }
}

