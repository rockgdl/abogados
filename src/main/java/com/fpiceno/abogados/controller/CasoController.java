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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.exception.JDBCConnectionException;

/**
 * FXML Controller class
 *
 * @author gnr_a
 */
public class CasoController implements Initializable {
    
    private static final org.apache.log4j.Logger LOG= org.apache.log4j.Logger.getLogger(CasoController.class.getSimpleName());

    @FXML ComboBox boxRazonSocialBusqueda, boxStatusBusqueda, boxClienteBusqueda;
    @FXML DatePicker boxDate, boxDate2;
    
    
    @FXML TableView<Caso> tablaCaso;
    @FXML TableColumn <Caso, String> ColumnRazonSocial, ColumnStatus, ColumnCliente, ColumnTipoPago, ColumnFecha,columnStatusPago,columnBancoPago;
    @FXML TableColumn <Caso, Integer> ColumnId;
    @FXML TableColumn <Caso, Double> ColumnIngresos, ColumnCostoCaso;
    ObservableList <Caso> oblistCaso= FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        obtenerCasos();
        
        
        ClienteDao daoc = new ClienteDaoMysql();
        
        try {
            boxClienteBusqueda.setItems(FXCollections.observableArrayList(daoc.read()));
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
        boxRazonSocialBusqueda.setItems(FXCollections.observableArrayList(RazonSocial.values()));
        boxStatusBusqueda.setItems(FXCollections.observableArrayList(Status.values()));
        
        new AutoCompleteBox(boxClienteBusqueda);
        
    
    }
    
    public void obtenerCasos(){
        try {
            tablaCaso.getItems().clear();
            CasoDao dao = new CasoDaoMysql();
            
            oblistCaso.addAll(dao.read());
            
            ColumnId.setCellValueFactory(new PropertyValueFactory("id"));
            ColumnRazonSocial.setCellValueFactory(new PropertyValueFactory("razonSocial"));
            ColumnStatus.setCellValueFactory(new PropertyValueFactory("status"));
            ColumnCliente.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
            ColumnTipoPago.setCellValueFactory(new PropertyValueFactory("tipo"));
            ColumnFecha.setCellValueFactory(new PropertyValueFactory("fechaInicioFormato"));
            ColumnCostoCaso.setCellValueFactory(new PropertyValueFactory("costoCaso"));
            
           
            ColumnIngresos.setCellValueFactory(new PropertyValueFactory("ingresos"));
            
            tablaCaso.setItems(oblistCaso);
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
    
    @FXML private void AbrirPagos(MouseEvent event){
        Caso caso = tablaCaso.getSelectionModel().getSelectedItem();
        
        if (event.getClickCount() == 2 && caso != null){
        
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AgregarCaso.fxml"));
            Parent root;   
            
            try {
                
            if(caso != null){
                root = (Parent) fxmlLoader.load();
                AgregarCasoController agregarCasoController = (AgregarCasoController) fxmlLoader.getController();
                agregarCasoController.setCaso(caso);
                agregarCasoController.setCasoController(this);
                agregarCasoController.inicializarPagos();
                agregarCasoController.abrirDatos();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root));
                stage.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Debe seleccionar un caso para poder editar");
                alert.show();
            }

                
            } catch (IOException ex) {
                Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
           
            LOG.info("No entro");
           
        }
    }
    
    @FXML private void buscar(ActionEvent event){
        try {
            //Cliente cliente = boxClienteBusqueda.getValue();adan
           
            CasoDao dao = new CasoDaoMysql();
            
            //Este if es en caso de tener el campo de busqueda por fechaFinal lleno, de no ser asi lo pasa por alto no afecta en el filtrado si es nulo
            Date fechaFin = null;
            if(boxDate2.getValue() != null){
                //Se le asigna la ultima hora con el ultimo milisegundo del dia para compararlo con la misma fecha
             fechaFin = Date.from(boxDate2.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                    fechaFin.setHours(23);
                    fechaFin.setMinutes(59);
                    fechaFin.setSeconds(59);
            }
            
            //Desde aqui se compara todos los diltrados
            if(boxClienteBusqueda.getValue() != null && boxDate.getValue() != null && boxRazonSocialBusqueda.getValue() != null && boxStatusBusqueda.getValue() != null){
                //buscar por todo
                
                Caso caso = new Caso();
                caso.setRazonSocial((RazonSocial) boxRazonSocialBusqueda.getValue());
                caso.setStatus((Status) boxStatusBusqueda.getValue());
                caso.setFechaInicio(Date.from(boxDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                String[] cadenaCliente = boxClienteBusqueda.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.readFilter(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if(boxClienteBusqueda.getValue() != null && boxDate.getValue() != null && boxRazonSocialBusqueda.getValue() != null){
                //Buscar por cliente, fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial((RazonSocial) boxRazonSocialBusqueda.getValue());
                caso.setFechaInicio(Date.from(boxDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                
                String[] cadenaCliente = boxClienteBusqueda.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForClienteAndFechaAndRazon(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if(boxClienteBusqueda.getValue() != null && boxDate.getValue() != null && boxStatusBusqueda.getValue() != null){
                //buscar por cliente, fecha y status
                
                Caso caso = new Caso();
                caso.setStatus((Status) boxStatusBusqueda.getValue());
                caso.setFechaInicio(Date.from(boxDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                String[] cadenaCliente = boxClienteBusqueda.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForClienteAndFechaAndStatus(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if (boxClienteBusqueda.getValue() != null && boxRazonSocialBusqueda.getValue() != null && boxStatusBusqueda.getValue() != null){
                //busqueda por cliente, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial((RazonSocial) boxRazonSocialBusqueda.getValue());
                caso.setStatus((Status) boxStatusBusqueda.getValue());
                
                String[] cadenaCliente = boxClienteBusqueda.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForClienteAndRazonAndStatus(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if (boxClienteBusqueda.getValue() != null && boxDate.getValue() != null){
                //buscar por cliente y fecha
                
                Caso caso = new Caso();
                caso.setFechaInicio(Date.from(boxDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                if(boxDate2.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                String[] cadenaCliente = boxClienteBusqueda.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForClienteAndFecha(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if(boxClienteBusqueda.getValue() != null && boxRazonSocialBusqueda.getValue() != null){
                //buscar por cliente y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial((RazonSocial) boxRazonSocialBusqueda.getValue());
                
                String[] cadenaCliente = boxClienteBusqueda.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForClienteAndRazon(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if(boxClienteBusqueda.getValue() != null && boxStatusBusqueda.getValue() != null){
                //buscar por cliente y status
                
                Caso caso = new Caso();
                caso.setStatus((Status) boxStatusBusqueda.getValue());
                
                String[] cadenaCliente = boxClienteBusqueda.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForClienteAndStatus(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if(boxClienteBusqueda.getValue() != null){
                //buscar por cliente
                
                Caso caso = new Caso();
                
                String[] cadenaCliente = boxClienteBusqueda.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForCliente(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if (boxDate.getValue() != null && boxRazonSocialBusqueda.getValue() != null && boxStatusBusqueda.getValue() != null){
                // buscar por fecha, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial((RazonSocial) boxRazonSocialBusqueda.getValue());
                caso.setStatus((Status) boxStatusBusqueda.getValue());
                caso.setFechaInicio(Date.from(boxDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForFechaAndRazonAndStatus(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if (boxDate.getValue() != null && boxRazonSocialBusqueda.getValue() != null){
                //buscar por fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial((RazonSocial) boxRazonSocialBusqueda.getValue());
                caso.setFechaInicio(Date.from(boxDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForFechaAndRazon(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if (boxDate.getValue() != null && boxStatusBusqueda.getValue() != null){
                //buscar por fecha y status
                
                Caso caso = new Caso();
                caso.setStatus((Status) boxStatusBusqueda.getValue());
                caso.setFechaInicio(Date.from(boxDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForFechaAndStatus(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if(boxDate.getValue() != null){
                //buscar por fecha
                Caso caso = new Caso();
                caso.setFechaInicio(Date.from(boxDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForFecha(caso));
                
                tablaCaso.setItems(oblistCaso);
                
            }else if (boxRazonSocialBusqueda.getValue() != null && boxStatusBusqueda.getValue() != null){
                //buscar por razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial((RazonSocial) boxRazonSocialBusqueda.getValue());
                caso.setStatus((Status) boxStatusBusqueda.getValue());
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForRazonAndStatus(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if (boxRazonSocialBusqueda.getValue() != null){
                //buscar por razon social
                Caso caso = new Caso();
                caso.setRazonSocial((RazonSocial) boxRazonSocialBusqueda.getValue());
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForRazon(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else if (boxStatusBusqueda.getValue() != null){
                //buscar por status
                
                Caso caso = new Caso();
                caso.setStatus((Status) boxStatusBusqueda.getValue());
                
                tablaCaso.getItems().clear();
                oblistCaso.addAll(dao.searchForStatus(caso));
                
                tablaCaso.setItems(oblistCaso);
            }else{
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                
                alerta.setHeaderText("No ha filtrado nada en la búsqueda");
                //alerta.setContentText(ex.getMessage());
                alerta.show();
            }
                
//
//        
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
                Alert alerta = new Alert(Alert.AlertType.ERROR);

                alerta.setHeaderText("Debe de agregar un cliente");
                alerta.setContentText(ex.getMessage());
                alerta.show();
            }
    }
    
    @FXML private void SeleccionarBusqueda(ActionEvent event){
        
    }
    
    @FXML private void Eliminar(ActionEvent event){
        try {
            CasoDao dao = new CasoDaoMysql();
            
            dao.delete(tablaCaso.getSelectionModel().getSelectedItem());
            
            obtenerCasos();
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
    
    @FXML private void limpiarConsulta(ActionEvent event){
        obtenerCasos();
        boxClienteBusqueda.setValue(null);
        boxRazonSocialBusqueda.setValue(null);
        boxStatusBusqueda.setValue(null);
        boxDate.setValue(null);
        boxDate2.setValue(null);
    }
    
    @FXML private void nuevoCaso(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AgregarCaso.fxml"));
        Parent root;
        try {
            root = (Parent) fxmlLoader.load();
            AgregarCasoController agregarCasoController = (AgregarCasoController) fxmlLoader.getController();
            agregarCasoController.setCasoController(this);
            agregarCasoController.inicializarPagos();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));  
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML private void EditarCaso(ActionEvent event){
        Caso caso = tablaCaso.getSelectionModel().getSelectedItem();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AgregarCaso.fxml"));
        Parent root;
        try {
            if(caso != null){
                root = (Parent) fxmlLoader.load();
                AgregarCasoController agregarCasoController = (AgregarCasoController) fxmlLoader.getController();
                agregarCasoController.setCaso(caso);
                agregarCasoController.setCasoController(this);
                agregarCasoController.inicializarPagos();
                agregarCasoController.abrirDatos();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root));
                stage.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Debe seleccionar un caso para poder editar");
                alert.show();
            }

        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
