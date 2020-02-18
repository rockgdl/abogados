/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fpiceno
 */
public class AdministradorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Logger log=Logger.getLogger(this.getClass().getSimpleName());
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
       @FXML private void nuevoCaso(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AgregarCaso.fxml"));
        Parent root;
        try {
            root = (Parent) fxmlLoader.load();
            AgregarCasoController agregarCasoController = (AgregarCasoController) fxmlLoader.getController();
            CasoController caso=new CasoController();
            agregarCasoController.setCasoController(caso);
            agregarCasoController.inicializarPagos();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));  
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void agregarClientes ()
    {
        log.info("agregando clientes ");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Cliente.fxml"));
        Parent root1;
        try {
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
                 stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    public void agregarUsuarios()
    {
        
           log.info("agregando usuarios ");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Usuarios.fxml"));
        Parent root1;
        try {
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
                 stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    @FXML
    public void addCasos()
    {
        log.info("agregando casoss");
        
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Caso.fxml"));
        Parent root1;
        try {
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
                 stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void consultarCasos(){
          log.info("Consultar Casos ");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/CasosConsulta.fxml"));
        Parent root1;
        try {
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
