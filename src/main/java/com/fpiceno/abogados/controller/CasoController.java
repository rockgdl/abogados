package com.fpiceno.abogados.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Tools.RazonSocial;
import Tools.tipoPago;
import com.fpiceno.abogados.dao.CasoDao;
import com.fpiceno.abogados.dao.ClienteDao;
import com.fpiceno.abogados.dao.mysql.CasoDaoMysql;
import com.fpiceno.abogados.dao.mysql.ClienteDaoMysql;
import com.fpiceno.abogados.entity.AutoCompleteBox;
import com.fpiceno.abogados.entity.Caso;
import com.fpiceno.abogados.entity.Cliente;
import com.fpiceno.abogados.entity.Pago;
import com.fpiceno.abogados.entity.Status;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gnr_a
 */
public class CasoController implements Initializable {
    
    
    @FXML ComboBox boxRazonSocialBusqueda, boxStatusBusqueda;
    @FXML ComboBox boxTipoPago, boxRazonSocial;
    @FXML ComboBox boxClienteBusqueda, boxCliente;
    
    @FXML TextArea txtConcepto;
    
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
        
        
        ClienteDao daoc = new ClienteDaoMysql();
        boxCliente.setItems(FXCollections.observableArrayList(daoc.read()));
        boxClienteBusqueda.setItems(FXCollections.observableArrayList(daoc.read()));
        boxRazonSocialBusqueda.setItems(FXCollections.observableArrayList(RazonSocial.values()));
        boxRazonSocial.setItems(FXCollections.observableArrayList(RazonSocial.values()));
        boxStatusBusqueda.setItems(FXCollections.observableArrayList(Status.values()));
        boxTipoPago.setItems(FXCollections.observableArrayList(tipoPago.values()));
        
        new AutoCompleteBox(boxClienteBusqueda);
        new AutoCompleteBox(boxCliente);
    
    }
    
    private void obtenerCasos(){
        tablaCaso.getItems().clear();
        CasoDao dao = new CasoDaoMysql();
        
        oblistCaso.addAll(dao.read());
        
        ColumnId.setCellValueFactory(new PropertyValueFactory("id"));
        ColumnRazonSocial.setCellValueFactory(new PropertyValueFactory("razonSocial"));
        ColumnStatus.setCellValueFactory(new PropertyValueFactory("status"));
        ColumnCliente.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
        ColumnTipoPago.setCellValueFactory(new PropertyValueFactory("tipo"));
        
        tablaCaso.setItems(oblistCaso);
    }
    
    @FXML private void AbrirPagos(MouseEvent event){
                
//        tablaCaso.setRowFactory( tv -> { 
//            TableRow<Caso> row = new TableRow<>();
//            row.setOnMouseClicked(ev ->{
//                if (event.getClickCount() == 2 && (!row.isEmpty())){
//                    Caso caso = row.getItem();
//                    System.out.println(caso.getId());
//                }else{
//                    System.out.println("No se que hace xD");
//                }
//            });
//            return row;
//        });
        
        Caso caso = tablaCaso.getSelectionModel().getSelectedItem();
        
        if (event.getClickCount() == 2 && caso != null){
            
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = null;
            Stage stage = new Stage();
            
            try {
                
                root = (Parent) fxmlLoader.load(getClass().getResource("/fxml/Pago.fxml").openStream());
                
                stage.setScene(new Scene(root));
                
                PagoController controlador = (PagoController) fxmlLoader.getController();
                controlador.setPagos(caso.getListaPagos());
                controlador.obtenerPagos();
                
                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
           
            System.out.println("No entro");
        }
    }
    
    @FXML private void buscar(ActionEvent event){
        //Cliente cliente = boxClienteBusqueda.getValue();
       String[] cadenaCliente = boxClienteBusqueda.getEditor().getText().split("\\-");
       int idCliente = Integer.parseInt(cadenaCliente[0]);
        System.out.println(idCliente);
        
        Caso caso = new Caso();
        
        ClienteDao daoClient = new ClienteDaoMysql();
        caso.setCliente(daoClient.readCliente(idCliente));
        caso.setRazonSocial((RazonSocial) boxRazonSocialBusqueda.getValue());
        caso.setStatus((Status) boxStatusBusqueda.getValue());
        
        CasoDao dao = new CasoDaoMysql();
        
        tablaCaso.getItems().clear();
        oblistCaso.addAll(dao.readFilter(caso));
        
        tablaCaso.setItems(oblistCaso);
    }
    
    @FXML private void SeleccionarBusqueda(ActionEvent event){
        
    }
    
    @FXML private void Eliminar(ActionEvent event){
        CasoDao dao = new CasoDaoMysql();
        
        dao.delete(tablaCaso.getSelectionModel().getSelectedItem());
        
        obtenerCasos();
    }
    
    @FXML private void nuevoCliente(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Cliente.fxml"));
        Parent root;
        try {
            root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML private void limpiarConsulta(ActionEvent event){
        obtenerCasos();
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
    }
}
