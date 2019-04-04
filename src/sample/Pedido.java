package sample;

import java.util.ArrayList;

public class Pedido {

    private String pedidoNumero;
    private String pedidoCliente;
    private String pedidoEstado;
    private String pedidoClienteDomicilio;
    private int pedidoClienteCondicionImpositiva;
    private String pedidoClienteDocumentoTipo;
    private String pedidoClienteDocumentoNumero;
    private double pedidoIva;

    public String getPedidoEstado() {
        return pedidoEstado;
    }

    public void setPedidoEstado(String pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
    }

    public ArrayList<DetalleProducto> getProductos() {
        return productos;
    }


    public void setProductos(ArrayList<DetalleProducto> productos) {
        this.productos = productos;
    }

    private ArrayList<DetalleProducto> productos;

    public String getPedidoClienteDomicilio() {
        return pedidoClienteDomicilio;
    }

    public void setPedidoClienteDomicilio(String pedidoClienteDomicilio) {
        this.pedidoClienteDomicilio = pedidoClienteDomicilio;
    }

    public int getPedidoClienteCondicionImpositiva() {
        return pedidoClienteCondicionImpositiva;
    }

    public void setPedidoClienteCondicionImpositiva(int pedidoClienteCondicionImpositiva) {
        this.pedidoClienteCondicionImpositiva = pedidoClienteCondicionImpositiva;
    }

    public String getPedidoClienteDocumentoTipo() {
        return pedidoClienteDocumentoTipo;
    }

    public void setPedidoClienteDocumentoTipo(String pedidoClienteDocumentoTipo) {
        this.pedidoClienteDocumentoTipo = pedidoClienteDocumentoTipo;
    }

    public String getPedidoClienteDocumentoNumero() {
        return pedidoClienteDocumentoNumero;
    }

    public void setPedidoClienteDocumentoNumero(String pedidoClienteDocumentoNumero) {
        this.pedidoClienteDocumentoNumero = pedidoClienteDocumentoNumero;
    }

    public String getPedidoNumero() {
        return pedidoNumero;
    }

    public void setPedidoNumero(String pedidoNumero) {
        this.pedidoNumero = pedidoNumero;
    }

    public String getPedidoCliente() {
        return pedidoCliente;
    }

    public void setPedidoCliente(String pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

    public double getPedidoIva() {
        return pedidoIva;
    }

    public void setPedidoIva(double pedidoIva) {
        this.pedidoIva = pedidoIva;
    }

    public Pedido() {

    }

    public Pedido(String pedidoNumero, String pedidoCliente, ArrayList<DetalleProducto> productos, String pedidoEstado, String pedidoClienteDomicilio, int pedidoClienteCondicionImpositiva, String pedidoClienteDocumentoTipo, String pedidoClienteDocumentoNumero) {
        this.pedidoNumero = pedidoNumero;
        this.pedidoCliente = pedidoCliente;
        this.productos = productos;
        this.pedidoEstado = pedidoEstado;
        this.pedidoClienteDomicilio = pedidoClienteDomicilio;
        this.pedidoClienteCondicionImpositiva = pedidoClienteCondicionImpositiva;
        this.pedidoClienteDocumentoTipo = pedidoClienteDocumentoTipo;
        this.pedidoClienteDocumentoNumero = pedidoClienteDocumentoNumero;
    }

    public ArrayList<DetalleProducto> agregarProducto(String codigo, String descripcion, double precio, int cantidad, double precioNeto) {

        productos.add(new DetalleProducto(codigo, descripcion, precio, cantidad, precioNeto));
        //System.out.println(codigo);
        //setProductos(productos);
        return productos;
    }

    public double sumarPrecios(ArrayList<DetalleProducto> productos) {
        double suma = 0;
        for (DetalleProducto pr : productos) {
            suma += pr.getPrecioNeto();
        }
        return suma;
    }

    public double sumarIva(ArrayList<DetalleProducto> productos) {
        double suma = 0;
        for (DetalleProducto pr : productos) {
            suma += pr.getPrecioNeto() * getPedidoIva();
        }
        return suma;
    }

    public double sumarTotal(ArrayList<DetalleProducto> productos) {
        double suma = 0;
        for (DetalleProducto pr : productos) {
            suma += pr.getPrecioNeto() + (pr.getPrecioNeto() * getPedidoIva());
        }
        return suma;
    }
}
