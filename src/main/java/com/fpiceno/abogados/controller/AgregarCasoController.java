/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.controller;

import Tools.RazonSocial;
import Tools.tipoPago;
import com.fpiceno.abogados.dao.CasoDao;
import com.fpiceno.abogados.dao.ClienteDao;
import com.fpiceno.abogados.dao.PagoDao;
import com.fpiceno.abogados.dao.mysql.CasoDaoMysql;
import com.fpiceno.abogados.dao.mysql.ClienteDaoMysql;
import com.fpiceno.abogados.dao.mysql.PagoDaoMysql;
import com.fpiceno.abogados.entity.AutoCompleteBox;
import com.fpiceno.abogados.entity.Caso;
import com.fpiceno.abogados.entity.Cliente;
import com.fpiceno.abogados.entity.Pago;
import com.fpiceno.abogados.entity.Status;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author gnr_a
 */
public class AgregarCasoController implements Initializable{

    @FXML ComboBox boxCliente;
    @FXML ComboBox boxTipoPago, boxRazonSocial;
    @FXML TextArea txtConcepto;
    @FXML TextField txtCantidadPago;
    
    
      //@FXML Label lblCantidadPagos;
    @FXML Button btnAgregarRow, btnAgregar, btnGuardar;
    @FXML TableView <Pago> tablaPago;
    @FXML TableColumn <Pago, String> columnConcepto;
    @FXML TableColumn <Pago, Integer> columnFolio;
    @FXML TableColumn <Pago, Double> columnCantidad;
    @FXML TableColumn <Pago, Date> columnFecha;
    ObservableList <Pago> oblistPago= FXCollections.observableArrayList();
    
    private CasoController casoController;
    private Caso caso;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ClienteDao daoc = new ClienteDaoMysql();
            
            boxTipoPago.setItems(FXCollections.observableArrayList(tipoPago.values()));
            boxRazonSocial.setItems(FXCollections.observableArrayList(RazonSocial.values()));
            boxCliente.setItems(FXCollections.observableArrayList(daoc.read()));
            new AutoCompleteBox(boxCliente);
        } catch (ConnectException ex) {
                
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                
                alerta.setHeaderText("No se pudo conectar a mysql");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (JDBCConnectionException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                
                alerta.setHeaderText("Se encontro un error al quere insertar la información");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (CommunicationsException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                
                alerta.setHeaderText("No se pudo comunicar con la base de datos mysql");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (InvocationTargetException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExceptionInInitializerError ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @FXML private void agregarCaso(ActionEvent event){
        Date date = new Date();
        Caso caso = new Caso();
        
        //Obtener el id del cliente
        String[] cadenaCliente = boxCliente.getEditor().getText().split("\\-");
        int idCliente = Integer.parseInt(cadenaCliente[0]);
        
        //Pasar parametros
        ClienteDao daoC = new ClienteDaoMysql();
        
        try {
            caso.setCliente(daoC.readCliente(idCliente));
            caso.setFechaInicio(date);
            caso.setRazonSocial((RazonSocial)boxRazonSocial.getValue());
            caso.setTipo((tipoPago) boxTipoPago.getValue());
            caso.setStatus(Status.APROBADO);
            caso.setConcepto(txtConcepto.getText());
            caso.setFechaInicio(date);
            caso.setCantidadPagos(tablaPago.getItems().size());
            caso.setListaPagos(tablaPago.getItems());

            CasoDao dao = new CasoDaoMysql();

            dao.insert(caso);
            getCasoController().obtenerCasos();
            
        } catch (ConnectException ex) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setHeaderText("No se pudo conectar a mysql");
            alerta.setContentText(ex.getMessage());
            alerta.show();

        } catch (JDBCConnectionException ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);

            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setHeaderText("Se encontro un error al quere insertar la información");
            alerta.setContentText(ex.getMessage());
            alerta.show();

        } catch (CommunicationsException ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);

            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setHeaderText("No se pudo comunicar con la base de datos mysql");
            alerta.setContentText(ex.getMessage());
            alerta.show();

        } catch (InvocationTargetException ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionInInitializerError ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NumberFormatException ex){
            
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);

            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setHeaderText("No se caputuro un numero");
            alerta.setContentText(ex.getMessage());
            alerta.show();
        }
        
        
    }
        
    @FXML private void nuevoCliente(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Cliente.fxml"));
        Parent root;
        try {
            root = (Parent) fxmlLoader.load();
            ClienteController clienteController = (ClienteController) fxmlLoader.getController();
            clienteController.setAgregarCasoController(this);
            Stage stage = new Stage();
            stage.setScene(new Scene(root)); 
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML private void agregarRow(ActionEvent event){
        if(tablaPago.getItems().size() < 5){
            Pago pago = new Pago();
            pago.setFechaPago(new Date());
            
            tablaPago.getItems().add(pago);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText("La cantidad de pagos establecida es de " +getCaso().getCantidadPagos()+", No puede agregar mas pagos");
            alert.show();
        }
    
    }
    
    @FXML private void eliminarRow(ActionEvent event){
        Pago pago = tablaPago.getSelectionModel().getSelectedItem();
        
        if(pago != null){
            tablaPago.getItems().remove(tablaPago.getSelectionModel().getFocusedIndex());
        }else{
            System.out.println("No agarro el pago");
        }
    }
    
    @FXML private void CapturaEnTabla(KeyEvent event){
        try{
            Pago pago = tablaPago.getSelectionModel().getSelectedItem();
            System.out.println("Entro");
        }catch(NumberFormatException ex){
            System.out.println("NO se tiene un numero");
        }
    }
    
    @FXML private void guardar(ActionEvent event){
        try {
            
            //Obtener el id del cliente
            String[] cadenaCliente = boxCliente.getEditor().getText().split("\\-");
            int idCliente = Integer.parseInt(cadenaCliente[0]);

            //Pasar parametros
            ClienteDao daoC = new ClienteDaoMysql();
            //getCaso().setListaPagos(tablaPago.getItems());
            caso.setCliente(daoC.readCliente(idCliente));
            caso.setFechaInicio(new Date());
            caso.setRazonSocial((RazonSocial)boxRazonSocial.getValue());
            caso.setTipo((tipoPago) boxTipoPago.getValue());
            caso.setStatus(Status.APROBADO);
            caso.setConcepto(txtConcepto.getText());
            caso.setFechaInicio(new Date());
            caso.setCantidadPagos(tablaPago.getItems().size());
            caso.setListaPagos(tablaPago.getItems());
          
            CasoDao dao = new CasoDaoMysql();
            for(Pago pago: getCaso().getListaPagos()){
                System.out.println(pago);
            }
            dao.update(getCaso());
        } catch (ConnectException ex) {
            Logger.getLogger(PagoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDBCConnectionException ex) {
            Logger.getLogger(PagoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CommunicationsException ex) {
            Logger.getLogger(PagoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PagoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionInInitializerError ex) {
            Logger.getLogger(PagoController.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NumberFormatException ex){
            
        }
        
    }

    public void abrirDatos(){
        PagoDao dao = new PagoDaoMysql();
        
//        for (Pago pago: getPagos()){
//            System.out.println(pago.getId());
//        }
        oblistPago.addAll(getCaso().getListaPagos());
        
        try{
            columnCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
            columnCantidad.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
            
            columnCantidad.setOnEditCommit(data ->{ 
                Pago pago = data.getRowValue();
                pago.setCantidad(data.getNewValue());
            });

            columnConcepto.setCellValueFactory(new PropertyValueFactory("concepto"));
            columnConcepto.setCellFactory(TextFieldTableCell.forTableColumn());
            columnConcepto.setOnEditCommit(data ->{ 
                Pago pago = data.getRowValue();
                pago.setConcepto(data.getNewValue());
            });

            columnFecha.setCellValueFactory(new PropertyValueFactory("fechaPago"));

            columnFolio.setCellValueFactory(new PropertyValueFactory("id"));

            tablaPago.setItems(oblistPago);
            boxCliente.setValue(getCaso().getCliente());
            boxRazonSocial.setValue(getCaso().getRazonSocial());
            boxTipoPago.setValue(getCaso().getTipo());
            txtConcepto.setText(getCaso().getConcepto());
            
        }catch(NumberFormatException ne){
            System.out.println("se ingreso una cadena");
        }catch(NullPointerException ex){
            System.out.println("Hay un campo que no puede ser nulo");
        }
        
    }

    /**
     * @return the caso
     */
    public Caso getCaso() {
        return caso;
    }

    /**
     * @param caso the caso to set
     */
    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    /**
     * @return the casoController
     */
    public CasoController getCasoController() {
        return casoController;
    }

    /**
     * @param casoController the casoController to set
     */
    public void setCasoController(CasoController casoController) {
        this.casoController = casoController;
        
        //PARA AVILITAR LOS BOTONES SEGUN SE VAYA A EDITAR O AGREGAR UNO NUEVO
        if(getCaso() == null){
            btnGuardar.setDisable(true);
        }else{
            btnAgregar.setDisable(true);
        }
    }
    
    public void obtenerCliente(Cliente cliente){
        boxCliente.setValue(cliente);
        getCasoController().boxClienteBusqueda.getItems().add(cliente);
    }
    
    
}
