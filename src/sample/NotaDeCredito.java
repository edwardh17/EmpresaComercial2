package sample;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NotaDeCredito {
    public String getNotaFecha() {
        return notaFecha;
    }

    public void setNotaFecha(String notaFecha) {
        this.notaFecha = notaFecha;
    }

    public String getNotaNumero() {
        return notaNumero;
    }

    public void setNotaNumero(String notaNumero) {
        this.notaNumero = notaNumero;
    }

    public String getNotaTalonario() {
        return notaTalonario;
    }

    public void setNotaTalonario(String notaTalonario) {
        this.notaTalonario = notaTalonario;
    }

    public String getNotaLetra() {
        return notaLetra;
    }

    public void setNotaLetra(String notaLetra) {
        this.notaLetra = notaLetra;
    }

    public String getNotaCliente() {
        return notaCliente;
    }

    public void setNotaCliente(String notaCliente) {
        this.notaCliente = notaCliente;
    }

    public double getNotaIva() {
        return notaIva;
    }

    public void setNotaIva(double notaIva) {
        this.notaIva = notaIva;
    }

    public ArrayList<DetalleProducto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<DetalleProducto> productos) {
        this.productos = productos;
    }

    public String getNotaEstado() {
        return notaEstado;
    }

    public void setNotaEstado(String notaEstado) {
        this.notaEstado = notaEstado;
    }

    public String getNotaClienteDomicilio() {
        return notaClienteDomicilio;
    }

    public void setNotaClienteDomicilio(String notaClienteDomicilio) {
        this.notaClienteDomicilio = notaClienteDomicilio;
    }

    public int getNotaClienteCondicionImpositiva() {
        return notaClienteCondicionImpositiva;
    }

    public void setNotaClienteCondicionImpositiva(int notaClienteCondicionImpositiva) {
        this.notaClienteCondicionImpositiva = notaClienteCondicionImpositiva;
    }

    public String getNotaClienteDocumentoTipo() {
        return notaClienteDocumentoTipo;
    }

    public void setNotaClienteDocumentoTipo(String notaClienteDocumentoTipo) {
        this.notaClienteDocumentoTipo = notaClienteDocumentoTipo;
    }

    public String getNotaClienteDocumentoNumero() {
        return notaClienteDocumentoNumero;
    }

    public void setNotaClienteDocumentoNumero(String notaClienteDocumentoNumero) {
        this.notaClienteDocumentoNumero = notaClienteDocumentoNumero;
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
            suma += pr.getPrecioNeto() * getNotaIva();
        }
        return suma;
    }

    public double sumarTotal(ArrayList<DetalleProducto> productos) {
        double suma = 0;
        for (DetalleProducto pr : productos) {
            suma += pr.getPrecioNeto() + (pr.getPrecioNeto() * getNotaIva());
        }
        return suma;
    }

    private String notaFecha;
    private String notaNumero;
    private String notaTalonario;
    private String notaLetra;
    private String notaCliente;
    private double notaIva;
    private String notaEstado;
    private ArrayList<DetalleProducto> productos;
    private String notaClienteDomicilio;
    private int notaClienteCondicionImpositiva;
    private String notaClienteDocumentoTipo;
    private String notaClienteDocumentoNumero;

    public NotaDeCredito() {
    }

    public NotaDeCredito(String notaNumero, String notaTalonario, String notaLetra, String notaCliente, String notaEstado, ArrayList<DetalleProducto> productos, String notaClienteDomicilio, int notaClienteCondicionImpositiva, String notaClienteDocumentoTipo, String notaClienteDocumentoNumero, double notaIva) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.notaFecha = format.format(new Date());
        this.notaNumero = notaNumero;
        this.notaTalonario = notaTalonario;
        this.notaLetra = notaLetra;
        this.notaCliente = notaCliente;
        this.notaIva = notaIva;
        this.notaEstado = notaEstado;
        this.productos = productos;
        this.notaClienteDomicilio = notaClienteDomicilio;
        this.notaClienteCondicionImpositiva = notaClienteCondicionImpositiva;
        this.notaClienteDocumentoTipo = notaClienteDocumentoTipo;
        this.notaClienteDocumentoNumero = notaClienteDocumentoNumero;
    }
}
