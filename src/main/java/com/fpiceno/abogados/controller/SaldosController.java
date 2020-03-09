package com.fpiceno.abogados.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Tools.Meses;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author fpiceno
 */
public class SaldosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
     private ComboBox comboBoxMes;
    @FXML
    private  TableView tablaSaldos;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
              comboBoxMes.setItems(FXCollections.observableArrayList(Meses.values()));
              
              
//               tablaSaldos.setCellValueFactory(new PropertyValueFactory<String,String>("firstName"));
             ObservableList<String> data = FXCollections.observableArrayList("A", "Z", "a@example.com","fdsafd0","tesxt","dsfafdsa","eiruipturew");
             tablaSaldos.getItems().add(data);
        
    }    
    
}
