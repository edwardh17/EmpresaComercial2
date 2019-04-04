package sample;

public class Cliente {

    public String getClienteNumero() {
        return clienteNumero;
    }

    public void setClienteNumero(String clienteNumero) {
        this.clienteNumero = clienteNumero;
    }

    public String getClienteDomicilio() {
        return clienteDomicilio;
    }

    public void setClienteDomicilio(String clienteDomicilio) {
        this.clienteDomicilio = clienteDomicilio;
    }

    public int getClienteCondicionImpositiva() {
        return clienteCondicionImpositiva;
    }

    public void setClienteCondicionImpositiva(int clienteCondicionImpositiva) {
        this.clienteCondicionImpositiva = clienteCondicionImpositiva;
    }

    public String getClienteDocumentoTipo() {
        return clienteDocumentoTipo;
    }

    public void setClienteDocumentoTipo(String clienteDocumentoTipo) {
        this.clienteDocumentoTipo = clienteDocumentoTipo;
    }

    public String getClienteDocumentoNumero() {
        return clienteDocumentoNumero;
    }

    public void setClienteDocumentoNumero(String clienteDocumentoNumero) {
        this.clienteDocumentoNumero = clienteDocumentoNumero;
    }

    private String clienteNumero;
    private String clienteDomicilio;
    private int clienteCondicionImpositiva;
    private String clienteDocumentoTipo;
    private String clienteDocumentoNumero;

    public Cliente() {
        this.clienteNumero = "";
        this.clienteDomicilio = "";
        this.clienteCondicionImpositiva = 0;
        this.clienteDocumentoTipo = "";
        this.clienteDocumentoNumero = "";
    }

    public Cliente(String clienteNumero, String clienteDomicilio, int clienteCondicionImpositiva, String clienteDocumentoTipo, String clienteDocumentoNumero) {
        this.clienteNumero = clienteNumero;
        this.clienteDomicilio = clienteDomicilio;
        this.clienteCondicionImpositiva = clienteCondicionImpositiva;
        this.clienteDocumentoTipo = clienteDocumentoTipo;
        this.clienteDocumentoNumero = clienteDocumentoNumero;
    }
}