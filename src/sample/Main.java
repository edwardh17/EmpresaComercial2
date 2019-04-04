package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Main extends Application {

    Stage window;
    TabPane pane;
    ObservableList<Pedido> pedidos = FXCollections.observableArrayList();
    ObservableList<Factura> facturas = FXCollections.observableArrayList();
    ObservableList<String> listaClientes = FXCollections.observableArrayList();
    ObservableList<Producto> productos = FXCollections.observableArrayList();
    ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    //ObservableList<Factura> facturaSelected, allFacturas;
    ObservableList<NotaDeCredito> notas = FXCollections.observableArrayList();
    ObservableList<Resumen> resumen = FXCollections.observableArrayList();
    TableView<Cliente> tablaClientes;
    TableView<Producto> tablaProductos;
    TableView<Pedido> tablaPedidos;
    TableView<DetalleProducto> tablaPedidoDetalles;
    TableView<Factura> tablaFacturas;
    TableView<DetalleProducto> tablaFacturaDetalles;
    TableView<NotaDeCredito> tablaNotasDeCredito;
    TableView<Resumen> tablaResumen;

    TextField clienteDomicilioInput, clienteCondicionImpositivaInput, clienteDocumentoTipoInput, clienteDocumentoNumeroInput;
    TextField productoNombreInput, productoPrecioInput;
    TextField DetalleProductoCodigoInput, DetalleProductoNombreInput, DetalleProductoPrecioInput, DetalleProductoCantidadInput;
    ComboBox<String> pedidoClienteCombo = new ComboBox();
    Label subTotal = new Label();

    int contadorClientes = 100000;
    int contadorProductos = 200000;
    int contadorPedidos = 300000;
    int contadorFacturas = 400000;
    int contadorNotas = 400000;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Módulo Facturación");
        crearDemos();
        //////CLIENTES

        TableColumn<Cliente, String> numeroColumn = new TableColumn<>("Número");
        numeroColumn.setMinWidth(100);
        numeroColumn.setCellValueFactory(new PropertyValueFactory<>("clienteNumero"));

        TableColumn<Cliente, String> domicilioColumn = new TableColumn<>("Domicilio");
        domicilioColumn.setMinWidth(400);
        domicilioColumn.setCellValueFactory(new PropertyValueFactory<>("clienteDomicilio"));

        TableColumn<Cliente, Integer> condicionColumn = new TableColumn<>("Condición Impositiva");
        condicionColumn.setMinWidth(100);
        condicionColumn.setCellValueFactory(new PropertyValueFactory<>("clienteCondicionImpositiva"));

        TableColumn<Cliente, String> tipoColumn = new TableColumn<>("Documento Tipo");
        tipoColumn.setMinWidth(50);
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("clienteDocumentoTipo"));

        TableColumn<Cliente, String> documentoNumeroColumn = new TableColumn<>("Documento Número");
        documentoNumeroColumn.setMinWidth(100);
        documentoNumeroColumn.setCellValueFactory(new PropertyValueFactory<>("clienteDocumentoNumero"));

        clienteDomicilioInput = new TextField();
        clienteDomicilioInput.setPromptText("Domicilio");
        clienteDomicilioInput.setMinWidth(100);

        clienteCondicionImpositivaInput = new TextField();
        clienteCondicionImpositivaInput.setPromptText("Condición Impositiva");
        clienteCondicionImpositivaInput.setMinWidth(100);

        clienteDocumentoTipoInput = new TextField();
        clienteDocumentoTipoInput.setPromptText("Documento Tipo");
        clienteDocumentoTipoInput.setMinWidth(100);

        clienteDocumentoNumeroInput = new TextField();
        clienteDocumentoNumeroInput.setPromptText("Documento Número");
        clienteDocumentoNumeroInput.setMinWidth(100);

        tablaClientes = new TableView<>();
        tablaClientes.setItems(getCliente());
        tablaClientes.getColumns().addAll(numeroColumn, domicilioColumn, condicionColumn, tipoColumn, documentoNumeroColumn);

        Button addClienteButton = new Button("Agregar");
        addClienteButton.setOnAction(e -> addClienteButtonClicked());
        Button deleteClienteButton = new Button("Borrar");
        deleteClienteButton.setOnAction(e -> deleteClienteButtonClicked());

        HBox botonesClientesBox = new HBox();
        botonesClientesBox.setPadding(new Insets(10, 10, 10, 10));
        botonesClientesBox.setSpacing(10);
        botonesClientesBox.getChildren().addAll(clienteDomicilioInput, clienteCondicionImpositivaInput, clienteDocumentoTipoInput, clienteDocumentoNumeroInput, addClienteButton, deleteClienteButton);

        VBox clientesBox = new VBox();
        clientesBox.getChildren().addAll(botonesClientesBox, tablaClientes);

        //////PRODUCTOS

        TableColumn<Producto, String> codigoColumn = new TableColumn<>("Codigo");
        codigoColumn.setMinWidth(100);
        codigoColumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        TableColumn<Producto, String> nombreColumn = new TableColumn<>("Nombre");
        nombreColumn.setMinWidth(400);
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Producto, Double> precioColumn = new TableColumn<>("Precio");
        precioColumn.setMinWidth(50);
        precioColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));

        productoNombreInput = new TextField();
        productoNombreInput.setPromptText("Nombre");
        productoNombreInput.setMinWidth(100);

        productoPrecioInput = new TextField();
        productoPrecioInput.setPromptText("Precio");

        tablaProductos = new TableView<>();
        tablaProductos.setItems(getProducto());
        tablaProductos.getColumns().addAll(codigoColumn, nombreColumn, precioColumn);

        Button addProductoButton = new Button("Agregar");
        addProductoButton.setOnAction(e -> addProductoButtonClicked());
        Button deleteProductoButton = new Button("Borrar");
        deleteProductoButton.setOnAction(e -> deleteProductoButtonClicked());

        HBox botonesProductosBox = new HBox();
        botonesProductosBox.setPadding(new Insets(10, 10, 10, 10));
        botonesProductosBox.setSpacing(10);
        botonesProductosBox.getChildren().addAll(productoNombreInput, productoPrecioInput, addProductoButton, deleteProductoButton);

        VBox productosBox = new VBox();
        productosBox.getChildren().addAll(botonesProductosBox, tablaProductos);

        //////PEDIDOS
        TableColumn<Pedido, String> pedidoNumeroColumn = new TableColumn<>("Número");
        pedidoNumeroColumn.setMinWidth(100);
        pedidoNumeroColumn.setCellValueFactory(new PropertyValueFactory<>("pedidoNumero"));

        TableColumn<Pedido, String> pedidoClienteColumn = new TableColumn<>("Cliente");
        pedidoClienteColumn.setMinWidth(100);
        pedidoClienteColumn.setCellValueFactory(new PropertyValueFactory<>("pedidoCliente"));

        TableColumn<Pedido, String> pedidoEstadoColumn = new TableColumn<>("Estado");
        pedidoEstadoColumn.setMinWidth(100);
        pedidoEstadoColumn.setCellValueFactory(new PropertyValueFactory<>("pedidoEstado"));

        pedidoClienteCombo.setItems(getPedidoClientes());
        pedidoClienteCombo.setPromptText("Cliente");
        pedidoClienteCombo.setMinWidth(100);

        tablaPedidos = new TableView<>();
        tablaPedidos.setItems(getPedido());
        tablaPedidos.getColumns().addAll(pedidoNumeroColumn, pedidoClienteColumn, pedidoEstadoColumn);

        Button addPedidoButton = new Button("Agregar");
        addPedidoButton.setOnAction(e -> addPedidoButtonClicked());
        Button deletePedidoButton = new Button("Borrar");
        deletePedidoButton.setOnAction(e -> deletePedidoButtonClicked());
        Button addPedidoDetalleButton = new Button("Detalles");
        addPedidoDetalleButton.setOnAction(e -> addPedidoDetalleButtonClicked());
        Button processPedidoDetalleButton = new Button("Procesar");
        processPedidoDetalleButton.setOnAction(e -> processPedidoDetalleButtonClicked());

        HBox botonesPedidosBox = new HBox();
        botonesPedidosBox.setPadding(new Insets(10, 10, 10, 10));
        botonesPedidosBox.setSpacing(10);
        botonesPedidosBox.getChildren().addAll(pedidoClienteCombo, addPedidoButton, deletePedidoButton, addPedidoDetalleButton, processPedidoDetalleButton);

        VBox pedidosBox = new VBox();
        pedidosBox.getChildren().addAll(botonesPedidosBox, tablaPedidos);

        //////FACTURAS

        TableColumn<Factura, String> facturaFechaColumn = new TableColumn<>("Fecha");
        facturaFechaColumn.setMinWidth(200);
        facturaFechaColumn.setCellValueFactory(new PropertyValueFactory<>("facturaFecha"));

        TableColumn<Factura, String> facturaNumeroColumn = new TableColumn<>("Número");
        facturaNumeroColumn.setMinWidth(100);
        facturaNumeroColumn.setCellValueFactory(new PropertyValueFactory<>("facturaNumero"));

        TableColumn<Factura, String> facturaTalonarioColumn = new TableColumn<>("Talonario");
        facturaTalonarioColumn.setMinWidth(100);
        facturaTalonarioColumn.setCellValueFactory(new PropertyValueFactory<>("facturaTalonario"));

        TableColumn<Factura, String> facturaLetraColumn = new TableColumn<>("Letra");
        facturaLetraColumn.setMinWidth(50);
        facturaLetraColumn.setCellValueFactory(new PropertyValueFactory<>("facturaLetra"));

        TableColumn<Factura, String> facturaClienteColumn = new TableColumn<>("Cliente");
        facturaClienteColumn.setMinWidth(100);
        facturaClienteColumn.setCellValueFactory(new PropertyValueFactory<>("facturaCliente"));

        TableColumn<Factura, String> facturaEstadoColumn = new TableColumn<>("Estado");
        facturaEstadoColumn.setMinWidth(100);
        facturaEstadoColumn.setCellValueFactory(new PropertyValueFactory<>("facturaEstado"));

        tablaFacturas = new TableView<>();
        tablaFacturas.setItems(getFactura());
        tablaFacturas.getColumns().addAll(facturaFechaColumn, facturaNumeroColumn, facturaTalonarioColumn, facturaLetraColumn, facturaClienteColumn, facturaEstadoColumn);

        Button deleteFacturaButton = new Button("Anular");
        deleteFacturaButton.setOnAction(e -> deleteFacturaButtonClicked());
        Button addFacturaDetalleButton = new Button("Detalles");
        addFacturaDetalleButton.setOnAction(e -> addFacturaDetalleButtonClicked());

        HBox botonesFacturasBox = new HBox();
        botonesFacturasBox.setPadding(new Insets(10, 10, 10, 10));
        botonesFacturasBox.setSpacing(10);
        botonesFacturasBox.getChildren().addAll(deleteFacturaButton, addFacturaDetalleButton);

        VBox facturasBox = new VBox();
        facturasBox.getChildren().addAll(botonesFacturasBox, tablaFacturas);

        //////NOTAS DE CRÉDITO
        TableColumn<NotaDeCredito, String> notaFechaColumn = new TableColumn<>("Fecha");
        notaFechaColumn.setMinWidth(200);
        notaFechaColumn.setCellValueFactory(new PropertyValueFactory<>("notaFecha"));

        TableColumn<NotaDeCredito, String> notaNumeroColumn = new TableColumn<>("Número");
        notaNumeroColumn.setMinWidth(100);
        notaNumeroColumn.setCellValueFactory(new PropertyValueFactory<>("notaNumero"));

        TableColumn<NotaDeCredito, String> notaTalonarioColumn = new TableColumn<>("Talonario");
        notaTalonarioColumn.setMinWidth(100);
        notaTalonarioColumn.setCellValueFactory(new PropertyValueFactory<>("notaTalonario"));

        TableColumn<NotaDeCredito, String> notaLetraColumn = new TableColumn<>("Letra");
        notaLetraColumn.setMinWidth(50);
        notaLetraColumn.setCellValueFactory(new PropertyValueFactory<>("notaLetra"));

        TableColumn<NotaDeCredito, String> notaClienteColumn = new TableColumn<>("Cliente");
        notaClienteColumn.setMinWidth(100);
        notaClienteColumn.setCellValueFactory(new PropertyValueFactory<>("notaCliente"));

        tablaNotasDeCredito = new TableView<>();
        tablaNotasDeCredito.setItems(getNotaDeCredito());
        tablaNotasDeCredito.getColumns().addAll(notaFechaColumn, notaNumeroColumn, notaTalonarioColumn, notaLetraColumn, notaClienteColumn);


        Button addNotaDetalleButton = new Button("Detalles");
        //addFacturaDetalleButton.setOnAction(e -> addFacturaDetalleButtonClicked());

        HBox botonesNotasBox = new HBox();
        botonesNotasBox.setPadding(new Insets(10, 10, 10, 10));
        botonesNotasBox.setSpacing(10);
        botonesNotasBox.getChildren().addAll(addNotaDetalleButton);

        VBox notasBox = new VBox();
        notasBox.getChildren().addAll(botonesNotasBox, tablaNotasDeCredito);

        //////RESUMEN
        TableColumn<Resumen, String> resumenClienteColumn = new TableColumn<>("Cliente");
        resumenClienteColumn.setMinWidth(200);
        resumenClienteColumn.setCellValueFactory(new PropertyValueFactory<>("resumenCliente"));

        TableColumn<Resumen, String> resumenTipoColumn = new TableColumn<>("Tipo Documento");
        resumenTipoColumn.setMinWidth(100);
        resumenTipoColumn.setCellValueFactory(new PropertyValueFactory<>("resumenTipo"));

        TableColumn<Resumen, String> resumenLetraColumn = new TableColumn<>("Letra");
        resumenLetraColumn.setMinWidth(100);
        resumenLetraColumn.setCellValueFactory(new PropertyValueFactory<>("resumenLetra"));

        TableColumn<Resumen, String> resumenFechaColumn = new TableColumn<>("Fecha de Emisión");
        resumenFechaColumn.setMinWidth(50);
        resumenFechaColumn.setCellValueFactory(new PropertyValueFactory<>("resumenFecha"));

        TableColumn<Resumen, Double> resumenMontoColumn = new TableColumn<>("Monto");
        resumenMontoColumn.setMinWidth(100);
        resumenMontoColumn.setCellValueFactory(new PropertyValueFactory<>("resumenMonto"));

        tablaResumen = new TableView<>();
        tablaResumen.setItems(getResumen());
        tablaResumen.getColumns().addAll(resumenClienteColumn, resumenTipoColumn, resumenLetraColumn, resumenFechaColumn, resumenMontoColumn);


        VBox resumenBox = new VBox();
        resumenBox.getChildren().addAll(tablaResumen);

        ////////////TABS

        TabPane pane = new TabPane();
        Tab tabClientes = new Tab();
        tabClientes.setText("Clientes");
        tabClientes.setClosable(false);
        tabClientes.setContent(clientesBox);

        Tab tabProductos = new Tab();
        tabProductos.setText("Productos");
        tabProductos.setClosable(false);
        tabProductos.setContent(productosBox);

        Tab tabPedidos = new Tab();
        tabPedidos.setText("Pedido");
        tabPedidos.setClosable(false);
        tabPedidos.setContent(pedidosBox);

        Tab tabFacturas = new Tab();
        tabFacturas.setText("Facturas");
        tabFacturas.setClosable(false);
        tabFacturas.setContent(facturasBox);

        Tab tabNotasDeCredito = new Tab();
        tabNotasDeCredito.setText("Notas de Crédito");
        tabNotasDeCredito.setClosable(false);
        tabNotasDeCredito.setContent(notasBox);

        Tab tabResumen = new Tab();
        tabResumen.setText("Resumen");
        tabResumen.setClosable(false);
        tabResumen.setContent(resumenBox);

        pane.getTabs().addAll(tabClientes, tabProductos, tabPedidos, tabFacturas, tabNotasDeCredito, tabResumen);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(pane);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    ////ACCIONES DE BOTONES

    public void addClienteButtonClicked() {
        Cliente cliente = new Cliente();
        cliente.setClienteNumero("C" + contadorClientes);
        contadorClientes++;
        cliente.setClienteDomicilio(clienteDomicilioInput.getText());
        cliente.setClienteCondicionImpositiva(parseInt(clienteCondicionImpositivaInput.getText()));
        cliente.setClienteDocumentoTipo(clienteDocumentoTipoInput.getText());
        cliente.setClienteDocumentoNumero(clienteDocumentoNumeroInput.getText());
        tablaClientes.getItems().add(cliente);
        pedidoClienteCombo.setItems(getPedidoClientes());
        clienteDomicilioInput.clear();
        clienteCondicionImpositivaInput.clear();
        clienteDocumentoTipoInput.clear();
        clienteDocumentoNumeroInput.clear();
    }

    public void deleteClienteButtonClicked() {
        ObservableList<Cliente> clienteSelected, allClientes;
        allClientes = tablaClientes.getItems();
        clienteSelected = tablaClientes.getSelectionModel().getSelectedItems();
        if (clienteSelected.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No seleccionó ningún Cliente");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione el cliente que desea eliminar.");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Cliente");
        alert.setHeaderText(null);
        alert.setContentText("¿Realmente desea eliminar el Cliente seleccionado?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            clienteSelected.forEach(allClientes::remove);
        }
        pedidoClienteCombo.setItems(getPedidoClientes());
    }

    public void addProductoButtonClicked() {
        Producto producto = new Producto();
        producto.setCodigo(Integer.toString(contadorProductos));
        contadorProductos++;
        producto.setNombre(productoNombreInput.getText());
        producto.setPrecio(parseDouble(productoPrecioInput.getText()));
        tablaProductos.getItems().add(producto);
        productoNombreInput.clear();
        productoPrecioInput.clear();
    }

    public void deleteProductoButtonClicked() {
        ObservableList<Producto> productoSelected, allProductos;
        allProductos = tablaProductos.getItems();
        productoSelected = tablaProductos.getSelectionModel().getSelectedItems();
        if (productoSelected.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No seleccionó ningún producto");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione el producto que desea eliminar.");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Producto");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro que desea eliminar el Producto seleccionado?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            productoSelected.forEach(allProductos::remove);
        }
    }

    public void addPedidoButtonClicked() {
        Pedido pedido = new Pedido();
        ArrayList<DetalleProducto> detalleProductos = new ArrayList<>();

        pedido.setPedidoNumero("P" + Integer.toString(contadorPedidos));
        contadorPedidos++;
        pedido.setPedidoCliente(pedidoClienteCombo.getSelectionModel().getSelectedItem());
        int codCliente = pedidoClienteCombo.getSelectionModel().getSelectedIndex();
        pedido.setPedidoClienteDomicilio(getCliente().get(codCliente).getClienteDomicilio());
        pedido.setPedidoClienteCondicionImpositiva(getCliente().get(codCliente).getClienteCondicionImpositiva());
        pedido.setPedidoClienteDocumentoTipo(getCliente().get(codCliente).getClienteDocumentoTipo());
        pedido.setPedidoClienteDocumentoNumero(getCliente().get(codCliente).getClienteDocumentoNumero());
        pedido.setPedidoEstado("PENDIENTE");
        pedido.setProductos(detalleProductos);
        tablaPedidos.getItems().add(pedido);
    }

    public void deletePedidoButtonClicked() {
        ObservableList<Pedido> pedidoSelected, allPedidos;
        allPedidos = tablaPedidos.getItems();
        pedidoSelected = tablaPedidos.getSelectionModel().getSelectedItems();
        pedidoSelected.forEach(allPedidos::remove);
    }

    public void addPedidoDetalleButtonClicked() {
        Stage pedidoDetalles = new Stage();
        ObservableList<Pedido> productoDetalleSelected;

        productoDetalleSelected = tablaPedidos.getSelectionModel().getSelectedItems();
        if (productoDetalleSelected.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No seleccionó ningún Pedido");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione un pedido para ver detalles.");
            alert.showAndWait();
            return;
        }

        TableColumn<DetalleProducto, String> pedidoDetalleCodigoColumn = new TableColumn<>("Código");
        pedidoDetalleCodigoColumn.setMinWidth(200);
        pedidoDetalleCodigoColumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        TableColumn<DetalleProducto, String> pedidoDetalleNombreColumn = new TableColumn<>("Descripción");
        pedidoDetalleNombreColumn.setMinWidth(400);
        pedidoDetalleNombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<DetalleProducto, Double> pedidoDetallePrecioColumn = new TableColumn<>("Precio");
        pedidoDetallePrecioColumn.setMinWidth(200);
        pedidoDetallePrecioColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<DetalleProducto, Integer> pedidoDetalleCantidadColumn = new TableColumn<>("Cantidad");
        pedidoDetalleCantidadColumn.setMinWidth(200);
        pedidoDetalleCantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<DetalleProducto, Double> pedidoDetallePrecioNetoColumn = new TableColumn<>("Total Neto");
        pedidoDetallePrecioNetoColumn.setMinWidth(200);
        pedidoDetallePrecioNetoColumn.setCellValueFactory(new PropertyValueFactory<>("precioNeto"));

        DetalleProductoCodigoInput = new TextField();
        DetalleProductoCodigoInput.setPromptText("Código");
        DetalleProductoCodigoInput.setMinWidth(100);

        DetalleProductoNombreInput = new TextField();
        DetalleProductoNombreInput.setPromptText("Nombre");
        DetalleProductoNombreInput.setMinWidth(100);

        DetalleProductoPrecioInput = new TextField();
        DetalleProductoPrecioInput.setPromptText("Precio");
        DetalleProductoNombreInput.setMinWidth(100);

        DetalleProductoCantidadInput = new TextField();
        DetalleProductoCantidadInput.setPromptText("Cantidad");
        DetalleProductoCantidadInput.setMinWidth(100);

        tablaPedidoDetalles = new TableView<>();

        int cod = 0;
        cod = tablaPedidos.getSelectionModel().getSelectedIndex();

        tablaPedidoDetalles.setItems(FXCollections.observableList(getPedido().get(cod).getProductos()));
        tablaPedidoDetalles.getColumns().addAll(pedidoDetalleCodigoColumn, pedidoDetalleNombreColumn, pedidoDetallePrecioColumn, pedidoDetalleCantidadColumn, pedidoDetallePrecioNetoColumn);

        Button addDetalleProductoButton = new Button("Agregar");
        addDetalleProductoButton.setOnAction(e -> addDetalleProductoButtonClicked());
        Button deleteDetalleProductoButton = new Button("Borrar");
        deleteDetalleProductoButton.setOnAction(e -> deleteDetalleProductoButtonClicked());

        HBox botonesProductosBox = new HBox();
        botonesProductosBox.setPadding(new Insets(10, 10, 10, 10));
        botonesProductosBox.setSpacing(10);
        botonesProductosBox.getChildren().addAll(DetalleProductoCodigoInput, DetalleProductoNombreInput, DetalleProductoPrecioInput, DetalleProductoCantidadInput, addDetalleProductoButton, deleteDetalleProductoButton);

        HBox totalPedidoDetallesBox = new HBox();
        totalPedidoDetallesBox.setPadding(new Insets(10, 10, 10, 10));
        totalPedidoDetallesBox.setSpacing(10);
        Label subTotal = new Label();
        subTotal.setText("Subtotal:  " + getPedido().get(cod).sumarPrecios(getPedido().get(cod).getProductos()));
        totalPedidoDetallesBox.getChildren().addAll(subTotal);

        VBox pedidoDetallesBox = new VBox();
        pedidoDetallesBox.getChildren().addAll(botonesProductosBox, tablaPedidoDetalles, totalPedidoDetallesBox);
        Scene detallesScene = new Scene(pedidoDetallesBox);
        pedidoDetalles.setScene(detallesScene);
        pedidoDetalles.show();

    }

    public void addDetalleProductoButtonClicked() {
        int cod = tablaPedidos.getSelectionModel().getSelectedIndex();
        String codigo = DetalleProductoCodigoInput.getText();
        String descripcion = DetalleProductoNombreInput.getText();
        double precio = parseDouble(DetalleProductoPrecioInput.getText());
        int cantidad = parseInt(DetalleProductoCantidadInput.getText());
        double precioNeto = precio * cantidad;
        pedidos.get(cod).agregarProducto(codigo, descripcion, precio, cantidad, precioNeto);
        tablaPedidoDetalles.setItems(FXCollections.observableList(getPedido().get(cod).getProductos()));
        subTotal.setText("Subtotal:  " + getPedido().get(cod).sumarPrecios(getPedido().get(cod).getProductos()));
    }

    public void deleteDetalleProductoButtonClicked() {
        int cod = tablaPedidos.getSelectionModel().getSelectedIndex();
        ObservableList<DetalleProducto> detalleProductoSelected, allDetalleProductos;
        allDetalleProductos = tablaPedidoDetalles.getItems();
        detalleProductoSelected = tablaPedidoDetalles.getSelectionModel().getSelectedItems();
        detalleProductoSelected.forEach(allDetalleProductos::remove);
        subTotal.setText("Subtotal:  " + getPedido().get(cod).sumarPrecios(getPedido().get(cod).getProductos()));
    }

    public void processPedidoDetalleButtonClicked() {
        int cod = tablaPedidos.getSelectionModel().getSelectedIndex();
        int comparador = getPedido().get(cod).getProductos().size();
        if (comparador > 0) {
            getPedido().get(cod).setPedidoEstado("PROCESADO");
            String pedido = getPedido().get(cod).getPedidoNumero();
            String facturaNumero = "F" + contadorFacturas;
            contadorFacturas++;
            String facturaTalonario;
            String facturaLetra;
            double facturaIva = 0.0;
            int letra = getPedido().get(cod).getPedidoClienteCondicionImpositiva();
            switch (letra) {
                case 1:
                    facturaLetra = "A";
                    facturaTalonario = "4444";
                    facturaIva = 0.105;
                    break;
                case 2:
                    facturaLetra = "B";
                    facturaTalonario = "5555";
                    facturaIva = 0.21;
                    break;
                case 3:
                    facturaLetra = "X";
                    facturaTalonario = "6666";
                    facturaIva = 0.70;
                    break;
                default:
                    facturaLetra = "A";
                    facturaTalonario = "4444";
                    facturaIva = 0.105;
            }

            getPedido().get(cod).setPedidoIva(facturaIva);

            String facturaCliente = getPedido().get(cod).getPedidoCliente();
            String facturaClienteDomicilio = getPedido().get(cod).getPedidoClienteDomicilio();
            int facturaClienteCondicionImpositiva = getPedido().get(cod).getPedidoClienteCondicionImpositiva();
            String facturaClienteDocumentoTipo = getPedido().get(cod).getPedidoClienteDocumentoTipo();
            String facturaClienteDocumentoNumero = getPedido().get(cod).getPedidoClienteDocumentoNumero();
            ArrayList<DetalleProducto> productosFactura = new ArrayList<>(getPedido().get(cod).getProductos());

            facturas.add(new Factura(facturaNumero, facturaTalonario, facturaLetra, facturaCliente, "PROCESADA", productosFactura, facturaClienteDomicilio, facturaClienteCondicionImpositiva, facturaClienteDocumentoTipo, facturaClienteDocumentoNumero, facturaIva));
            tablaFacturas.setItems(getFactura());
            tablaPedidos.setItems(getPedido());
            tablaResumen.setItems(getResumen());
            tablaPedidos.refresh();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso del Pedido");
            alert.setHeaderText(null);
            alert.setContentText("El Pedido nº " + pedido + " se procesó correctamente.");
            alert.showAndWait();
            return;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("¡La lista de productos no puede estar vacía!");
            alert.showAndWait();
            return;
        }
    }

    public void deleteFacturaButtonClicked() {

        int cod = tablaFacturas.getSelectionModel().getSelectedIndex();

        getFactura().get(cod).setFacturaEstado("ANUALDA");
        String factura = getFactura().get(cod).getFacturaLetra() + " " + getFactura().get(cod).getFacturaTalonario() + " " + getFactura().get(cod).getFacturaNumero();
        String notaNumero = "NC" + contadorNotas;
        contadorNotas++;
        String notaTalonario = getFactura().get(cod).getFacturaTalonario();
        String notaLetra = getFactura().get(cod).getFacturaLetra();
        double notaIva = getFactura().get(cod).getFacturaIva();


        String notaCliente = getFactura().get(cod).getFacturaCliente();
        String notaClienteDomicilio = getFactura().get(cod).getFacturaClienteDomicilio();
        int notaClienteCondicionImpositiva = getFactura().get(cod).getFacturaClienteCondicionImpositiva();
        String notaClienteDocumentoTipo = getFactura().get(cod).getFacturaClienteDocumentoTipo();
        String notaClienteDocumentoNumero = getFactura().get(cod).getFacturaClienteDocumentoNumero();
        ArrayList<DetalleProducto> productosNota = new ArrayList<>(getFactura().get(cod).getProductos());

        notas.add(new NotaDeCredito(notaNumero, notaTalonario, notaLetra, notaCliente, "PROCESADA", productosNota, notaClienteDomicilio, notaClienteCondicionImpositiva, notaClienteDocumentoTipo, notaClienteDocumentoNumero, notaIva));
        tablaFacturas.setItems(getFactura());
        tablaPedidos.setItems(getPedido());
        tablaResumen.setItems(getResumen());
        tablaFacturas.refresh();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso de la Facturas");
        alert.setHeaderText(null);
        alert.setContentText("La factura nº " + factura + " se anuló correctamente.");
        alert.showAndWait();
        return;
    }

    public void addFacturaDetalleButtonClicked() {
        Stage facturaDetalles = new Stage();
        ObservableList<Factura> productoDetalleSelected;

        productoDetalleSelected = tablaFacturas.getSelectionModel().getSelectedItems();
        if (productoDetalleSelected.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No seleccionó ninguna factura");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione una factura para ver detalles.");
            alert.showAndWait();
            return;
        }

        TableColumn<DetalleProducto, String> facturaDetalleCodigoColumn = new TableColumn<>("Código");
        facturaDetalleCodigoColumn.setMinWidth(200);
        facturaDetalleCodigoColumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        TableColumn<DetalleProducto, String> facturaDetalleNombreColumn = new TableColumn<>("Descripción");
        facturaDetalleNombreColumn.setMinWidth(400);
        facturaDetalleNombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<DetalleProducto, Double> facturaDetallePrecioColumn = new TableColumn<>("Precio");
        facturaDetallePrecioColumn.setMinWidth(200);
        facturaDetallePrecioColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<DetalleProducto, Integer> facturaDetalleCantidadColumn = new TableColumn<>("Cantidad");
        facturaDetalleCantidadColumn.setMinWidth(200);
        facturaDetalleCantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<DetalleProducto, Double> facturaDetallePrecioNetoColumn = new TableColumn<>("Total Neto");
        facturaDetallePrecioNetoColumn.setMinWidth(200);
        facturaDetallePrecioNetoColumn.setCellValueFactory(new PropertyValueFactory<>("precioNeto"));

        tablaFacturaDetalles = new TableView<>();

        int cod = 0;
        cod = tablaFacturas.getSelectionModel().getSelectedIndex();

        tablaFacturaDetalles.setItems(FXCollections.observableList(getFactura().get(cod).getProductos()));
        tablaFacturaDetalles.getColumns().addAll(facturaDetalleCodigoColumn, facturaDetalleNombreColumn, facturaDetallePrecioColumn, facturaDetalleCantidadColumn, facturaDetallePrecioNetoColumn);

        Label facturaFechaLbl = new Label();
        Label facturaNumeroLbl = new Label();
        Label facturaTalonarioLbl = new Label();
        Label facturaLetraLbl = new Label();
        Label facturaClienteLbl = new Label();

        facturaFechaLbl.setText("Fecha de Emisión: " + getFactura().get(cod).getFacturaFecha());
        facturaNumeroLbl.setText("   Número: " + getFactura().get(cod).getFacturaNumero());
        facturaTalonarioLbl.setText("   Código de Emisión: " + getFactura().get(cod).getFacturaTalonario());
        facturaLetraLbl.setText("   Letra: " + getFactura().get(cod).getFacturaLetra());
        facturaClienteLbl.setText("   Cliente: " + getFactura().get(cod).getFacturaCliente());

        HBox botonesProductosBox = new HBox();
        botonesProductosBox.setPadding(new Insets(10, 10, 10, 10));
        botonesProductosBox.setSpacing(10);
        botonesProductosBox.getChildren().addAll(facturaFechaLbl, facturaNumeroLbl, facturaTalonarioLbl, facturaLetraLbl, facturaClienteLbl);

        HBox totalFacturaDetallesBox = new HBox();
        totalFacturaDetallesBox.setPadding(new Insets(10, 10, 10, 10));
        totalFacturaDetallesBox.setSpacing(10);
        Label facturaSubTotalLbl = new Label();
        Label facturaIvalLbl = new Label();
        Label facturaTotalLbl = new Label();
        facturaSubTotalLbl.setText("Subtotal:  " + getFactura().get(cod).sumarPrecios(getFactura().get(cod).getProductos()));
        facturaIvalLbl.setText("     Iva:  " + getFactura().get(cod).sumarIva(getFactura().get(cod).getProductos()));
        facturaTotalLbl.setText("     Total:  " + getFactura().get(cod).sumarTotal(getFactura().get(cod).getProductos()));
        totalFacturaDetallesBox.getChildren().addAll(facturaSubTotalLbl, facturaIvalLbl, facturaTotalLbl);

        VBox facturaDetallesBox = new VBox();
        facturaDetallesBox.getChildren().addAll(botonesProductosBox, tablaFacturaDetalles, totalFacturaDetallesBox);
        Scene detallesScene = new Scene(facturaDetallesBox);
        facturaDetalles.setScene(detallesScene);
        facturaDetalles.show();

    }

    public ObservableList<Cliente> getCliente() {
        return clientes;
    }

    public ObservableList<Producto> getProducto() {
        return productos;
    }

    public ObservableList<Pedido> getPedido() {
        return pedidos;
    }

    public ObservableList<String> getPedidoClientes() {
        listaClientes.removeAll();
        for (int i = 0; i < tablaClientes.getItems().size(); i++) {
            listaClientes.add(tablaClientes.getItems().get(i).getClienteNumero());
        }
        return listaClientes;
    }

    public ObservableList<Factura> getFactura() {
        return facturas;
    }

    public ObservableList<NotaDeCredito> getNotaDeCredito() {
        return notas;
    }

    public void crearDemos() {
        int cod = 0;
        clientes.add(new Cliente("C" + contadorClientes, "RECOLETA", 1, "DNI", "33245612"));
        contadorClientes++;
        clientes.add(new Cliente("C" + contadorClientes, "BELGRANO", 3, "DNI", "303223323"));
        contadorClientes++;
        clientes.add(new Cliente("C" + contadorClientes, "PALERMO", 1, "CUIT", "45778591"));
        contadorClientes++;
        clientes.add(new Cliente("C" + contadorClientes, "LA PLATA", 2, "DNI", "18221387"));
        contadorClientes++;
        clientes.add(new Cliente("C" + contadorClientes, "ALMAGRO", 2, "DNI", "330003033"));
        contadorClientes++;
        productos.add(new Producto("100003356", "TORNILLO CABEZA HEXAGONAL, ROSCA TOTAL M10X40 8.8 FZB DIN933", 5.20));
        productos.add(new Producto("131046316", "LLAVE PARALELA A 10 X 8 X 063 DS96", 6.90));
        productos.add(new Producto("131085561", "ANILLO DE SEGURIDAD EXTERNO U 16X1 A – DIN471", 10.20));
        productos.add(new Producto("131122259", "TUERCA HEX. AUTOBLOCANTE M8 A2 DIN985", 9.20));
        productos.add(new Producto("131122301", "TUERCA HEX. AUTOBLOCANTE M12 A2 DIN985", 20.50));
        productos.add(new Producto("131165328", "CASQUILLO TAPERLOCK TL2517 Ø35", 300.10));
        productos.add(new Producto("131172073", "ANILLO DE FIELTRO 6 X 10 X 155, Ø40", 150.40));
        productos.add(new Producto("131172147", "POLEA DE CORREA HTD 8M, 34 TEETH, B50, TL1615", 2332.00));
        productos.add(new Producto("131122301", "TUERCA HEX. AUTOBLOCANTE M12 A2 DIN985", 25.50));
        productos.add(new Producto("131122316", "TUERCA HEX. DIN934-8 FZB", 20.20));
        pedidos.add(new Pedido("P" + contadorPedidos, "C100001", new ArrayList<DetalleProducto>(), "PENDIENTE", "", 0, "", ""));
        contadorPedidos++;
        pedidos.add(new Pedido("P" + contadorPedidos, "C100001", new ArrayList<DetalleProducto>(), "PENDIENTE", "", 0, "", ""));
        contadorPedidos++;
        pedidos.add(new Pedido("P" + contadorPedidos, "C100002", new ArrayList<DetalleProducto>(), "PENDIENTE", "", 0, "", ""));
        contadorPedidos++;
        pedidos.get(cod).agregarProducto("131122301", "TUERCA HEX. AUTOBLOCANTE M12 A2 DIN985", 25.50, 1, 51);
        pedidos.get(cod).agregarProducto("131172147", "POLEA DE CORREA HTD 8M, 34 TEETH, B50, TL1615", 2332.00, 1, 51);
        pedidos.get(cod).agregarProducto("131165328", "CASQUILLO TAPERLOCK TL2517 Ø35", 300.10, 1, 35);
        pedidos.get(cod).agregarProducto("100003356", "TORNILLO CABEZA HEXAGONAL, ROSCA TOTAL M10X40 8.8 FZB DIN933", 5.20, 2, 90);
        cod = 1;
        pedidos.get(cod).agregarProducto("131085561", "ANILLO DE SEGURIDAD EXTERNO U 16X1 A – DIN471", 10.20, 1, 25.50);
        cod = 2;
        pedidos.get(cod).agregarProducto("131046316", "LLAVE PARALELA A 10 X 8 X 063 DS96", 6.90, 2, 70);
    }

    public ObservableList<Resumen> getResumen() {
        ObservableList<Resumen> resumen = FXCollections.observableArrayList();
        double total;
        for (Factura fact : facturas) {
            total = fact.sumarTotal(fact.getProductos());
            resumen.add(new Resumen(fact.getFacturaCliente(), "FACTURA", fact.getFacturaLetra(), fact.getFacturaNumero(), fact.getFacturaFecha(), total));
        }
        for (NotaDeCredito not : notas) {
            total = not.sumarTotal(not.getProductos());
            resumen.add(new Resumen(not.getNotaCliente(), "NC", not.getNotaLetra(), not.getNotaNumero(), not.getNotaFecha(), total));
        }

        return resumen;
    }
}
