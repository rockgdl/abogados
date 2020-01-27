package com.fpiceno.abogados.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fpiceno.abogados.entity.Caso;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author gnr_a
 */
public class CasosConsultaController implements Initializable {

    @FXML Tab tabFML, tabFMLSE, tabML, tabMDP, tabFMLMartinez;
    
    //Datos de FXML
    @FXML ComboBox boxRazonSocialFML, boxStatusBusquedaFML, boxClienteBusquedaFML;
    @FXML DatePicker boxDateFML, boxDate2FML;
    
    
    @FXML TableView<Caso> tablaCasoFML;
    @FXML TableColumn <Caso, String> ColumnIngresosFML, ColumnRazonSocialFML, ColumnStatusFML, ColumnClienteFML, ColumnTipoPagoFML, ColumnFechaFML;
    @FXML TableColumn <Caso, Integer> ColumnIdFML;
    ObservableList <Caso> oblistCasoFML= FXCollections.observableArrayList();
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML private void Detectar(ActionEvent event){
        Button btn= (Button) event.getSource();
        System.out.println(btn.getId());
    }
    
    @FXML private void abrirPagos(MouseEvent event){
        
    }
    
    @FXML private void seleccionarTab(Event event){
        if(tabFML.isSelected()){
            System.out.println("FML");
        }else if (tabFMLMartinez.isSelected()){
            System.out.println("FML Martinez");
        }else if(tabFMLSE.isSelected()){
            System.out.println("FMLSE");
        }else if (tabMDP.isSelected()){
            System.out.println("MDP Abogados");
        }else if (tabML.isSelected()){
            System.out.println("ML Consultores");
        }
    }
}
