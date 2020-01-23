/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.controller;

import com.fpiceno.abogados.dao.CasoDao;
import com.fpiceno.abogados.dao.PagoDao;
import com.fpiceno.abogados.dao.mysql.CasoDaoMysql;
import com.fpiceno.abogados.dao.mysql.PagoDaoMysql;
import com.fpiceno.abogados.entity.Caso;
import com.fpiceno.abogados.entity.Pago;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.URL;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.util.converter.DoubleStringConverter;
import org.hibernate.exception.JDBCConnectionException;

/**
 * FXML Controller class
 *
 * @author gnr_a
 */
public class PagoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Label lblCantidadPagos;
    @FXML Button btnAgregarRow;
    @FXML TableView <Pago> tablaPago;
    @FXML TableColumn <Pago, String> columnConcepto;
    @FXML TableColumn <Pago, Integer> columnFolio;
    @FXML TableColumn <Pago, Double> columnCantidad;
    @FXML TableColumn <Pago, Date> columnFecha;
    ObservableList <Pago> oblistPago= FXCollections.observableArrayList();
            
    
    private Caso caso;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //obtenerPagos();
    }
    
    @FXML private void agregarRow(ActionEvent event){
        if(tablaPago.getItems().size() < 5){
            Pago pago = new Pago();
            pago.setFechaPago(new Date());
            
            tablaPago.getItems().add(pago);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText("La cantidad de pagos establecida es de " +caso.getCantidadPagos()+", No puede agregar mas pagos");
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
            getCaso().setListaPagos(tablaPago.getItems());
            
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
        }
        
    }

    public void obtenerPagos(){
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
    
}
