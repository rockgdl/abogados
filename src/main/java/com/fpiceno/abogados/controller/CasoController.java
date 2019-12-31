package com.fpiceno.abogados.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Tools.tipoPago;
import com.fpiceno.abogados.dao.CasoDao;
import com.fpiceno.abogados.dao.mysql.CasoDaoMysql;
import com.fpiceno.abogados.entity.Caso;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author gnr_a
 */
public class CasoController implements Initializable {
    
    @FXML TableView<Caso> tablaCaso;
    @FXML TableColumn <Caso, String> ColumnIngresos, ColumnRazonSocial, ColumnStatus, ColumnCliente, ColumnTipoPago;
    @FXML TableColumn <Caso, Integer> ColumnId;
    ObservableList <Caso> oblistCaso= FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        obtenerCasos();
    }
    
    private void obtenerCasos(){
        CasoDao dao = new CasoDaoMysql();
        
        oblistCaso.addAll(dao.read());
        
        ColumnId.setCellValueFactory(new PropertyValueFactory("id"));
        ColumnRazonSocial.setCellValueFactory(new PropertyValueFactory("razonSocial"));
        ColumnStatus.setCellValueFactory(new PropertyValueFactory("status"));
        ColumnCliente.setCellValueFactory(new PropertyValueFactory("cliente"));
        ColumnTipoPago.setCellValueFactory(new PropertyValueFactory("tipo"));
        
        tablaCaso.setItems(oblistCaso);
    }
    
    @FXML private void AbrirPagos(MouseEvent event){
        
    }
    
}
