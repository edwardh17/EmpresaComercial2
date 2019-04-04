package sample;

public class Resumen {

    public String getResumenCliente() {
        return resumenCliente;
    }

    public void setResumenCliente(String resumenCliente) {
        this.resumenCliente = resumenCliente;
    }

    public String getResumenTipo() {
        return resumenTipo;
    }

    public void setResumenTipo(String resumenTipo) {
        this.resumenTipo = resumenTipo;
    }

    public String getResumenLetra() {
        return resumenLetra;
    }

    public void setResumenLetra(String resumenLetra) {
        this.resumenLetra = resumenLetra;
    }

    public String getResumenFecha() {
        return resumenFecha;
    }

    public void setResumenFecha(String resumenFecha) {
        this.resumenFecha = resumenFecha;
    }

    public double getResumenMonto() {
        return resumenMonto;
    }

    public void setResumenMonto(double resumenMonto) {
        this.resumenMonto = resumenMonto;
    }

    public String getResumenNumero() {
        return resumenNumero;
    }

    public void setResumenNumero(String resumenNumero) {
        this.resumenNumero = resumenNumero;
    }

    private String resumenCliente;
    private String resumenTipo;
    private String resumenLetra;
    private String resumenNumero;
    private String resumenFecha;
    private double resumenMonto;

    public Resumen(String resumenCliente, String resumenTipo, String resumenLetra, String resumenNumero, String resumenFecha, double resumenMonto) {
        this.resumenCliente = resumenCliente;
        this.resumenTipo = resumenTipo;
        this.resumenLetra = resumenLetra;
        this.resumenNumero = resumenNumero;
        this.resumenFecha = resumenFecha;
        this.resumenMonto = resumenMonto;
    }
}
