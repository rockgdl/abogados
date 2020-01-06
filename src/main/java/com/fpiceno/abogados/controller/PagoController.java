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
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author gnr_a
 */
public class PagoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML TableView <Pago> tablaPago;
    @FXML TableColumn <Pago, String> columnConcepto;
    @FXML TableColumn <Pago, Integer> columnFolio, columnCantidad;
    @FXML TableColumn <Pago, Date> columnFecha;
    ObservableList <Pago> oblistPago= FXCollections.observableArrayList();
            
    
    private List<Pago> pagos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //obtenerPagos();
    }    

    public void obtenerPagos(){
        PagoDao dao = new PagoDaoMysql();
        
//        for (Pago pago: getPagos()){
//            System.out.println(pago.getId());
//        }
        oblistPago.addAll(getPagos());
        
        columnCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        columnConcepto.setCellValueFactory(new PropertyValueFactory("concepto"));
        columnFecha.setCellValueFactory(new PropertyValueFactory("fechaPago"));
        columnFolio.setCellValueFactory(new PropertyValueFactory("id"));
        
        tablaPago.setItems(oblistPago);
    }

    /**
     * @return the pagos
     */
    public List<Pago> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
    
    
}
