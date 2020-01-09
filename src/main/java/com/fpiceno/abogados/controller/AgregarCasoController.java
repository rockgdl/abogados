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
import com.fpiceno.abogados.dao.mysql.CasoDaoMysql;
import com.fpiceno.abogados.dao.mysql.ClienteDaoMysql;
import com.fpiceno.abogados.entity.AutoCompleteBox;
import com.fpiceno.abogados.entity.Caso;
import com.fpiceno.abogados.entity.Cliente;
import com.fpiceno.abogados.entity.Status;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author gnr_a
 */
public class AgregarCasoController implements Initializable{

    @FXML ComboBox boxCliente;
    @FXML ComboBox boxTipoPago, boxRazonSocial;
    @FXML TextArea txtConcepto;
    
    private CasoController casoController;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ClienteDao daoc = new ClienteDaoMysql();
        
        boxTipoPago.setItems(FXCollections.observableArrayList(tipoPago.values()));
        boxRazonSocial.setItems(FXCollections.observableArrayList(RazonSocial.values()));
        boxCliente.setItems(FXCollections.observableArrayList(daoc.read()));
        new AutoCompleteBox(boxCliente);
    }
    
        @FXML private void agregarCaso(ActionEvent event){
        Date date = new Date();
        Caso caso = new Caso();
        
        //Obtener el id del cliente
        String[] cadenaCliente = boxCliente.getEditor().getText().split("\\-");
        int idCliente = Integer.parseInt(cadenaCliente[0]);
        
        //Pasar parametros
        ClienteDao daoC = new ClienteDaoMysql();
        
        caso.setCliente(daoC.readCliente(idCliente));
        caso.setFechaInicio(date);
        caso.setRazonSocial((RazonSocial)boxRazonSocial.getValue());
        caso.setTipo((tipoPago) boxTipoPago.getValue());
        caso.setStatus(Status.APROBADO);
        caso.setConcepto(txtConcepto.getText());
        
        CasoDao dao = new CasoDaoMysql();
        
        dao.insert(caso);
        getCasoController().obtenerCasos();
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
    }
    
    public void obtenerCliente(Cliente cliente){
        boxCliente.setValue(cliente);
        getCasoController().boxClienteBusqueda.getItems().add(cliente);
    }
}
