package sample;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Factura {

    private String facturaFecha;
    private String facturaNumero;
    private String facturaTalonario;
    private String facturaLetra;
    private String facturaCliente;
    private ArrayList<DetalleProducto> productos;
    private String facturaEstado;
    private String facturaClienteDomicilio;
    private int facturaClienteCondicionImpositiva;
    private String facturaClienteDocumentoTipo;
    private String facturaClienteDocumentoNumero;
    private double facturaIva;

    public Factura() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.facturaFecha = format.format(new Date());
        this.facturaNumero = "";
        this.facturaTalonario = "";
        this.facturaLetra = "";
        this.facturaCliente = "";
        this.facturaEstado = "PROCESADO";
    }

    public Factura(String facturaNumero, String facturaTalonario, String facturaLetra, String facturaCliente, String facturaEstado, ArrayList<DetalleProducto> productos, String facturaClienteDomicilio, int facturaClienteCondicionImpositiva, String facturaClienteDocumentoTipo, String facturaClienteDocumentoNumero, double facturaIva) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.facturaFecha = format.format(new Date());
        this.facturaNumero = facturaNumero;
        this.facturaTalonario = facturaTalonario;
        this.facturaLetra = facturaLetra;
        this.facturaCliente = facturaCliente;
        this.facturaEstado = facturaEstado;
        this.productos = productos;
        this.facturaClienteDomicilio = facturaClienteDomicilio;
        this.facturaClienteCondicionImpositiva = facturaClienteCondicionImpositiva;
        this.facturaClienteDocumentoTipo = facturaClienteDocumentoTipo;
        this.facturaClienteDocumentoNumero = facturaClienteDocumentoNumero;
        this.facturaIva = facturaIva;
    }

    public String getFacturaFecha() {
        return facturaFecha;
    }

    public void setFacturaFecha(String facturaFecha) {
        this.facturaFecha = facturaFecha;
    }

    public String getFacturaNumero() {
        return facturaNumero;
    }

    public void setFacturaNumero(String facturaNumero) {
        this.facturaNumero = facturaNumero;
    }

    public String getFacturaTalonario() {
        return facturaTalonario;
    }

    public void setFacturaTalonario(String facturaTalonario) {
        this.facturaTalonario = facturaTalonario;
    }

    public String getFacturaLetra() {
        return facturaLetra;
    }

    public void setFacturaLetra(String facturaLetra) {
        this.facturaLetra = facturaLetra;
    }

    public String getFacturaCliente() {
        return facturaCliente;
    }

    public void setFacturaCliente(String facturaCliente) {
        this.facturaCliente = facturaCliente;
    }

    public String getFacturaEstado() {
        return facturaEstado;
    }

    public void setFacturaEstado(String facturaEstado) {
        this.facturaEstado = facturaEstado;
    }

    public ArrayList<DetalleProducto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<DetalleProducto> productos) {
        this.productos = productos;
    }

    public String getFacturaClienteDomicilio() {
        return facturaClienteDomicilio;
    }

    public void setFacturaClienteDomicilio(String facturaClienteDomicilio) {
        this.facturaClienteDomicilio = facturaClienteDomicilio;
    }

    public int getFacturaClienteCondicionImpositiva() {
        return facturaClienteCondicionImpositiva;
    }

    public void setFacturaClienteCondicionImpositiva(int facturaClienteCondicionImpositiva) {
        this.facturaClienteCondicionImpositiva = facturaClienteCondicionImpositiva;
    }

    public String getFacturaClienteDocumentoTipo() {
        return facturaClienteDocumentoTipo;
    }

    public void setFacturaClienteDocumentoTipo(String facturaClienteDocumentoTipo) {
        this.facturaClienteDocumentoTipo = facturaClienteDocumentoTipo;
    }

    public String getFacturaClienteDocumentoNumero() {
        return facturaClienteDocumentoNumero;
    }

    public void setFacturaClienteDocumentoNumero(String facturaClienteDocumentoNumero) {
        this.facturaClienteDocumentoNumero = facturaClienteDocumentoNumero;
    }

    public double getFacturaIva() {
        return facturaIva;
    }

    public void setFacturaIva(double facturaIva) {
        this.facturaIva = facturaIva;
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
            suma += pr.getPrecioNeto() * getFacturaIva();
        }
        return suma;
    }

    public double sumarTotal(ArrayList<DetalleProducto> productos) {
        double suma = 0;
        for (DetalleProducto pr : productos) {
            suma += pr.getPrecioNeto() + (pr.getPrecioNeto() * getFacturaIva());
        }
        return suma;
    }
}
