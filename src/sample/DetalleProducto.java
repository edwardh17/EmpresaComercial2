package sample;

public class DetalleProducto extends Producto {
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioNeto() {
        return precioNeto;
    }

    public void setPrecioNeto(double precioNeto) {
        this.precioNeto = precioNeto;
    }

    private int cantidad;
    private double precioNeto;

    public DetalleProducto() {
    }

    public DetalleProducto(String codigo, String nombre, double precio, int cantidad, double precioNeto) {
        super.setCodigo(codigo);
        super.setNombre(nombre);
        super.setPrecio(precio);
        this.cantidad = cantidad;
        this.precioNeto = precioNeto;
    }
}
