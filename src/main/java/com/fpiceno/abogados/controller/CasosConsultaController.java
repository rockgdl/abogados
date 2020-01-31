package com.fpiceno.abogados.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Tools.RazonSocial;
import com.fpiceno.abogados.dao.CasoDao;
import com.fpiceno.abogados.dao.ClienteDao;
import com.fpiceno.abogados.dao.mysql.CasoDaoMysql;
import com.fpiceno.abogados.dao.mysql.ClienteDaoMysql;
import com.fpiceno.abogados.entity.AutoCompleteBox;
import com.fpiceno.abogados.entity.Caso;
import com.fpiceno.abogados.entity.Status;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.exception.JDBCConnectionException;

/**
 * FXML Controller class
 *
 * @author gnr_a
 */
public class CasosConsultaController implements Initializable {

    private RazonSocial razon;
    @FXML Tab tabFML, tabFMLSE, tabML, tabMDP, tabFMLMartinez;
    @FXML TabPane tabPanel;
    
    
    //Datos de FXML
    @FXML ComboBox boxStatusFML, boxClienteFML;
    @FXML DatePicker boxDateFML, boxDate2FML;
    
    @FXML TableView<Caso> tablaCasoFML;
    @FXML TableColumn <Caso, String> ColumnIngresosFML, ColumnRazonSocialFML, ColumnStatusFML, ColumnClienteFML, ColumnTipoPagoFML, ColumnFechaFML;
    @FXML TableColumn <Caso, Integer> ColumnIdFML;
    ObservableList <Caso> oblistCasoFML= FXCollections.observableArrayList();
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
    @FXML ComboBox boxStatusFMLSE, boxClienteFMLSE;
    @FXML DatePicker boxDateFMLSE, boxDate2FMLSE;
    
    
    @FXML TableView<Caso> tablaCasoFMLSE;
    @FXML TableColumn <Caso, String> ColumnIngresosFMLSE, ColumnRazonSocialFMLSE, ColumnStatusFMLSE, ColumnClienteFMLSE, ColumnTipoPagoFMLSE, ColumnFechaFMLSE;
    @FXML TableColumn <Caso, Integer> ColumnIdFMLSE;
    ObservableList <Caso> oblistCasoFMLSE = FXCollections.observableArrayList();
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    @FXML ComboBox boxStatusML, boxClienteML;
    @FXML DatePicker boxDateML, boxDate2ML;
    
    @FXML TableView<Caso> tablaCasoML;
    @FXML TableColumn <Caso, String> ColumnIngresosML, ColumnRazonSocialML, ColumnStatusML, ColumnClienteML, ColumnTipoPagoML, ColumnFechaML;
    @FXML TableColumn <Caso, Integer> ColumnIdML;
    ObservableList <Caso> oblistCasoML= FXCollections.observableArrayList();
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @FXML ComboBox boxStatusMDP, boxClienteMDP;
    @FXML DatePicker boxDateMDP, boxDate2MDP;
    
    @FXML TableView<Caso> tablaCasoMDP;
    @FXML TableColumn <Caso, String> ColumnIngresosMDP, ColumnRazonSocialMDP, ColumnStatusMDP, ColumnClienteMDP, ColumnTipoPagoMDP, ColumnFechaMDP;
    @FXML TableColumn <Caso, Integer> ColumnIdMDP;
    ObservableList <Caso> oblistCasoMDP= FXCollections.observableArrayList();
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML ComboBox boxStatusFMLMartinez, boxClienteFMLMartinez;
    @FXML DatePicker boxDateFMLMartinez, boxDate2FMLMartinez;
    
    @FXML TableView<Caso> tablaCasoFMLMartinez;
    @FXML TableColumn <Caso, String> ColumnIngresosFMLMartinez, ColumnRazonSocialFMLMartinez, ColumnStatusFMLMartinez, ColumnClienteFMLMartinez, ColumnTipoPagoFMLMartinez, ColumnFechaFMLMartinez;
    @FXML TableColumn <Caso, Integer> ColumnIdFMLMartinez;
    ObservableList <Caso> oblistCasoFMLMartinez= FXCollections.observableArrayList();
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        obtenerCasosFML();
        obtenerCasosFMLMartinez();
        obtenerCasosFMLSE();
        obtenerCasosMDP();
        obtenerCasosML();
        iniciaComboBox();
    }
    
    private void iniciaComboBox(){
        ClienteDao daoc = new ClienteDaoMysql();
        
        try {
            boxClienteFML.setItems(FXCollections.observableArrayList(daoc.read()));
            boxStatusFML.setItems(FXCollections.observableArrayList(Status.values()));
            new AutoCompleteBox(boxClienteFML);
            
            boxClienteFMLSE.setItems(FXCollections.observableArrayList(daoc.read()));
            boxStatusFMLSE.setItems(FXCollections.observableArrayList(Status.values()));
            new AutoCompleteBox(boxClienteFMLSE);
            
            boxClienteML.setItems(FXCollections.observableArrayList(daoc.read()));
            boxStatusML.setItems(FXCollections.observableArrayList(Status.values()));
            new AutoCompleteBox(boxClienteML);
            
            boxClienteMDP.setItems(FXCollections.observableArrayList(daoc.read()));
            boxStatusMDP.setItems(FXCollections.observableArrayList(Status.values()));
            new AutoCompleteBox(boxClienteMDP);
            
            boxClienteFMLMartinez.setItems(FXCollections.observableArrayList(daoc.read()));
            boxStatusFMLMartinez.setItems(FXCollections.observableArrayList(Status.values()));
            new AutoCompleteBox(boxClienteFMLMartinez);
            
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
    
    @FXML private void Detectar(ActionEvent event){
        Button btn= (Button) event.getSource();
        System.out.println(btn.getId());
    }
    
    @FXML private void abrirPagos(MouseEvent event){
        Caso caso = null;
        
        if(tabFML.isSelected()){
            System.out.println("FML");
            caso = tablaCasoFML.getSelectionModel().getSelectedItem();
        }else if (tabFMLMartinez.isSelected()){
            System.out.println("FML Martinez");
            caso = tablaCasoFMLMartinez.getSelectionModel().getSelectedItem();
        }else if(tabFMLSE.isSelected()){
            System.out.println("FMLSE");
            caso = tablaCasoFMLSE.getSelectionModel().getSelectedItem();
        }else if (tabMDP.isSelected()){
            System.out.println("MDP Abogados");
            caso = tablaCasoMDP.getSelectionModel().getSelectedItem();
        }else if (tabML.isSelected()){
            System.out.println("ML Consultores");
            caso = tablaCasoML.getSelectionModel().getSelectedItem();
        }
        
        if (event.getClickCount() == 2 && caso != null){
            
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = null;
            Stage stage = new Stage();
            
            try {
                
                root = (Parent) fxmlLoader.load(getClass().getResource("/fxml/Pago.fxml").openStream());
                
                stage.setScene(new Scene(root));
                
                PagoController controlador = (PagoController) fxmlLoader.getController();
                controlador.setCaso(caso);
                controlador.obtenerPagos();
                
                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
           
            System.out.println("No entro");
        }
    }
    
    @FXML private void seleccionarTab(Event event){
        
        if(tabFML.isSelected()){
            System.out.println("FML");
            razon = RazonSocial.FML;
        }else if (tabFMLMartinez.isSelected()){
            System.out.println("FML Martinez");
            razon = RazonSocial.FMLMARTINEZ;
        }else if(tabFMLSE.isSelected()){
            System.out.println("FMLSE");
            razon = RazonSocial.FMLSE;
        }else if (tabMDP.isSelected()){
            System.out.println("MDP Abogados");
            razon = RazonSocial.MDPABOGADOS;
        }else if (tabML.isSelected()){
            System.out.println("ML Consultores");             
            razon = RazonSocial.MLCONSULTORES;
        }
    }
    
    
    
    @FXML private void buscarCasosFML(ActionEvent event){
            try {
            //Cliente cliente = boxClienteBusqueda.getValue();adan
           
            CasoDao dao = new CasoDaoMysql();
            
            //Este if es en caso de tener el campo de busqueda por fechaFinal lleno, de no ser asi lo pasa por alto no afecta en el filtrado si es nulo
            Date fechaFin = null;
            if(boxDate2FML.getValue() != null){
                //Se le asigna la ultima hora con el ultimo milisegundo del dia para compararlo con la misma fecha
             fechaFin = Date.from(boxDate2FML.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                    fechaFin.setHours(23);
                    fechaFin.setMinutes(59);
                    fechaFin.setSeconds(59);
            }
            
            //Desde aqui se compara todos los Filtrados
            if(boxClienteFML.getValue() != null && boxDateFML.getValue() != null && boxStatusFML.getValue() != null){
                //buscar por todo
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FML);
                caso.setStatus((Status) boxStatusFML.getValue());
                caso.setFechaInicio(Date.from(boxDateFML.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FML.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                String[] cadenaCliente = boxClienteFML.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFML.getItems().clear();
                oblistCasoFML.addAll(dao.readFilter(caso));
                
                tablaCasoFML.setItems(oblistCasoFML);
            }else if(boxClienteFML.getValue() != null && boxDateFML.getValue() != null){
                //Buscar por cliente, fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FML);
                caso.setFechaInicio(Date.from(boxDateFML.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FML.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                
                String[] cadenaCliente = boxClienteFML.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFML.getItems().clear();
                oblistCasoFML.addAll(dao.searchForClienteAndFechaAndRazon(caso));
                
                tablaCasoFML.setItems(oblistCasoFML);
                
            }else if (boxClienteFML.getValue() != null && boxStatusFML.getValue() != null){
                //busqueda por cliente, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FML);
                caso.setStatus((Status) boxStatusFML.getValue());
                
                String[] cadenaCliente = boxClienteFML.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFML.getItems().clear();
                oblistCasoFML.addAll(dao.searchForClienteAndRazonAndStatus(caso));
                
                tablaCasoFML.setItems(oblistCasoFML);
            }else if(boxClienteFML.getValue() != null){
                //buscar por cliente y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FML);
                
                String[] cadenaCliente = boxClienteFML.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFML.getItems().clear();
                oblistCasoFML.addAll(dao.searchForClienteAndRazon(caso));
                
                tablaCasoFML.setItems(oblistCasoFML);
            }else if (boxDateFML.getValue() != null && boxStatusFML.getValue() != null){
                // buscar por fecha, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FML);
                caso.setStatus((Status) boxStatusFML.getValue());
                caso.setFechaInicio(Date.from(boxDateFML.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FML.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCasoFML.getItems().clear();
                oblistCasoFML.addAll(dao.searchForFechaAndRazonAndStatus(caso));
                
                tablaCasoFML.setItems(oblistCasoFML);
            }else if (boxDateFML.getValue() != null){
                //buscar por fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FML);
                caso.setFechaInicio(Date.from(boxDateFML.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FML.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCasoFML.getItems().clear();
                oblistCasoFML.addAll(dao.searchForFechaAndRazon(caso));
                
                tablaCasoFML.setItems(oblistCasoFML);
            }else if (boxStatusFML.getValue() != null){
                //buscar por razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FML);
                caso.setStatus((Status) boxStatusFML.getValue());
                
                tablaCasoFML.getItems().clear();
                oblistCasoFML.addAll(dao.searchForRazonAndStatus(caso));
                
                tablaCasoFML.setItems(oblistCasoFML);
            }else{
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                
                alerta.setHeaderText("No ha filtrado nada en la búsqueda");
                //alerta.setContentText(ex.getMessage());
                alerta.show();
            }
                
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
    
    @FXML private void limpiarFML(ActionEvent event){
        obtenerCasosFML();
        boxClienteFML.setValue(null);
        boxDate2FML.setValue(null);
        boxDateFML.setValue(null);
        boxStatusFML.setValue(null);
    }
    
    private void obtenerCasosFML(){
        try {
            CasoDao dao = new CasoDaoMysql();
            
            Caso caso = new Caso();
            caso.setRazonSocial(RazonSocial.FML);
            
            tablaCasoFML.getItems().clear();
            oblistCasoFML.addAll(dao.searchForRazon(caso));
            
            ColumnIdFML.setCellValueFactory(new PropertyValueFactory("id"));
            ColumnRazonSocialFML.setCellValueFactory(new PropertyValueFactory("razonSocial"));
            ColumnStatusFML.setCellValueFactory(new PropertyValueFactory("status"));
            ColumnClienteFML.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
            ColumnTipoPagoFML.setCellValueFactory(new PropertyValueFactory("tipo"));
            ColumnFechaFML.setCellValueFactory(new PropertyValueFactory("fechaInicioFormato"));

            
            tablaCasoFML.setItems(oblistCasoFML);
        } catch (ConnectException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDBCConnectionException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CommunicationsException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionInInitializerError ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   /////////////////////////////////////////////////////////////////////////
    
    
    @FXML private void buscarCasosFMLSE(ActionEvent event){
            try {
            //Cliente cliente = boxClienteBusqueda.getValue();adan
           
            CasoDao dao = new CasoDaoMysql();
            
            //Este if es en caso de tener el campo de busqueda por fechaFinal lleno, de no ser asi lo pasa por alto no afecta en el filtrado si es nulo
            Date fechaFin = null;
            if(boxDate2FMLSE.getValue() != null){
                //Se le asigna la ultima hora con el ultimo milisegundo del dia para compararlo con la misma fecha
             fechaFin = Date.from(boxDate2FMLSE.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                    fechaFin.setHours(23);
                    fechaFin.setMinutes(59);
                    fechaFin.setSeconds(59);
            }
            
            //Desde aqui se compara todos los Filtrados
            if(boxClienteFMLSE.getValue() != null && boxDateFMLSE.getValue() != null && boxStatusFMLSE.getValue() != null){
                //buscar por todo
                
                Caso caso = new Caso();
                caso.setRazonSocial(razon);
                caso.setStatus((Status) boxStatusFMLSE.getValue());
                caso.setFechaInicio(Date.from(boxDateFMLSE.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FMLSE.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                String[] cadenaCliente = boxClienteFMLSE.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFMLSE.getItems().clear();
                oblistCasoFMLSE.addAll(dao.readFilter(caso));
                
                tablaCasoFMLSE.setItems(oblistCasoFMLSE);
            }else if(boxClienteFMLSE.getValue() != null && boxDateFMLSE.getValue() != null){
                //Buscar por cliente, fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLSE);
                caso.setFechaInicio(Date.from(boxDateFMLSE.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FMLSE.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                
                String[] cadenaCliente = boxClienteFMLSE.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFMLSE.getItems().clear();
                oblistCasoFMLSE.addAll(dao.searchForClienteAndFechaAndRazon(caso));
                
                tablaCasoFMLSE.setItems(oblistCasoFMLSE);
                
            }else if (boxClienteFMLSE.getValue() != null && boxStatusFMLSE.getValue() != null){
                //busqueda por cliente, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLSE);
                caso.setStatus((Status) boxStatusFMLSE.getValue());
                
                String[] cadenaCliente = boxClienteFMLSE.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFMLSE.getItems().clear();
                oblistCasoFMLSE.addAll(dao.searchForClienteAndRazonAndStatus(caso));
                
                tablaCasoFMLSE.setItems(oblistCasoFMLSE);
            }else if(boxClienteFMLSE.getValue() != null){
                //buscar por cliente y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLSE);
                
                String[] cadenaCliente = boxClienteFMLSE.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFMLSE.getItems().clear();
                oblistCasoFMLSE.addAll(dao.searchForClienteAndRazon(caso));
                
                tablaCasoFMLSE.setItems(oblistCasoFMLSE);
            }else if (boxDateFMLSE.getValue() != null && boxStatusFMLSE.getValue() != null){
                // buscar por fecha, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLSE);
                caso.setStatus((Status) boxStatusFMLSE.getValue());
                caso.setFechaInicio(Date.from(boxDateFMLSE.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FMLSE.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCasoFMLSE.getItems().clear();
                oblistCasoFMLSE.addAll(dao.searchForFechaAndRazonAndStatus(caso));
                
                tablaCasoFMLSE.setItems(oblistCasoFMLSE);
            }else if (boxDateFMLSE.getValue() != null){
                //buscar por fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLSE);
                caso.setFechaInicio(Date.from(boxDateFMLSE.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FMLSE.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCasoFMLSE.getItems().clear();
                oblistCasoFMLSE.addAll(dao.searchForFechaAndRazon(caso));
                
                tablaCasoFMLSE.setItems(oblistCasoFMLSE);
            }else if (boxStatusFMLSE.getValue() != null){
                //buscar por razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLSE);
                caso.setStatus((Status) boxStatusFMLSE.getValue());
                
                tablaCasoFMLSE.getItems().clear();
                oblistCasoFMLSE.addAll(dao.searchForRazonAndStatus(caso));
                
                tablaCasoFMLSE.setItems(oblistCasoFMLSE);
            }else{
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                
                alerta.setHeaderText("No ha filtrado nada en la búsqueda");
                //alerta.setContentText(ex.getMessage());
                alerta.show();
            }
                
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
    
    @FXML private void limpiarFMLSE(ActionEvent event){
        obtenerCasosFMLSE();
        boxClienteFMLSE.setValue(null);
        boxDate2FMLSE.setValue(null);
        boxDateFMLSE.setValue(null);
        boxStatusFMLSE.setValue(null);
    }
    
    private void obtenerCasosFMLSE(){
        try {
            CasoDao dao = new CasoDaoMysql();
            
            Caso caso = new Caso();
            caso.setRazonSocial(RazonSocial.FMLSE);
            
            tablaCasoFMLSE.getItems().clear();
            oblistCasoFMLSE.addAll(dao.searchForRazon(caso));
            
            ColumnIdFMLSE.setCellValueFactory(new PropertyValueFactory("id"));
            ColumnRazonSocialFMLSE.setCellValueFactory(new PropertyValueFactory("razonSocial"));
            ColumnStatusFMLSE.setCellValueFactory(new PropertyValueFactory("status"));
            ColumnClienteFMLSE.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
            ColumnTipoPagoFMLSE.setCellValueFactory(new PropertyValueFactory("tipo"));
            ColumnFechaFMLSE.setCellValueFactory(new PropertyValueFactory("fechaInicioFormato"));

            
            tablaCasoFMLSE.setItems(oblistCasoFMLSE);
        } catch (ConnectException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDBCConnectionException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CommunicationsException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionInInitializerError ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    @FXML private void buscarCasosML(ActionEvent event){
            try {
            //Cliente cliente = boxClienteBusqueda.getValue();adan
           
            CasoDao dao = new CasoDaoMysql();
            
            //Este if es en caso de tener el campo de busqueda por fechaFinal lleno, de no ser asi lo pasa por alto no afecta en el filtrado si es nulo
            Date fechaFin = null;
            if(boxDate2ML.getValue() != null){
                //Se le asigna la ultima hora con el ultimo milisegundo del dia para compararlo con la misma fecha
             fechaFin = Date.from(boxDate2ML.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                    fechaFin.setHours(23);
                    fechaFin.setMinutes(59);
                    fechaFin.setSeconds(59);
            }
            
            //Desde aqui se compara todos los Filtrados
            if(boxClienteML.getValue() != null && boxDateML.getValue() != null && boxStatusML.getValue() != null){
                //buscar por todo
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MLCONSULTORES);
                caso.setStatus((Status) boxStatusML.getValue());
                caso.setFechaInicio(Date.from(boxDateML.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2ML.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                String[] cadenaCliente = boxClienteML.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoML.getItems().clear();
                oblistCasoML.addAll(dao.readFilter(caso));
                
                tablaCasoML.setItems(oblistCasoML);
            }else if(boxClienteML.getValue() != null && boxDateML.getValue() != null){
                //Buscar por cliente, fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MLCONSULTORES);
                caso.setFechaInicio(Date.from(boxDateML.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2ML.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                
                String[] cadenaCliente = boxClienteML.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoML.getItems().clear();
                oblistCasoML.addAll(dao.searchForClienteAndFechaAndRazon(caso));
                
                tablaCasoML.setItems(oblistCasoML);
                
            }else if (boxClienteML.getValue() != null && boxStatusML.getValue() != null){
                //busqueda por cliente, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MLCONSULTORES);
                caso.setStatus((Status) boxStatusML.getValue());
                
                String[] cadenaCliente = boxClienteML.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoML.getItems().clear();
                oblistCasoML.addAll(dao.searchForClienteAndRazonAndStatus(caso));
                
                tablaCasoML.setItems(oblistCasoML);
            }else if(boxClienteML.getValue() != null){
                //buscar por cliente y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MLCONSULTORES);
                
                String[] cadenaCliente = boxClienteML.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoML.getItems().clear();
                oblistCasoML.addAll(dao.searchForClienteAndRazon(caso));
                
                tablaCasoML.setItems(oblistCasoML);
            }else if (boxDateML.getValue() != null && boxStatusML.getValue() != null){
                // buscar por fecha, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MLCONSULTORES);
                caso.setStatus((Status) boxStatusML.getValue());
                caso.setFechaInicio(Date.from(boxDateML.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2ML.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCasoML.getItems().clear();
                oblistCasoML.addAll(dao.searchForFechaAndRazonAndStatus(caso));
                
                tablaCasoML.setItems(oblistCasoML);
            }else if (boxDateML.getValue() != null){
                //buscar por fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MLCONSULTORES);
                caso.setFechaInicio(Date.from(boxDateML.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2ML.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCasoML.getItems().clear();
                oblistCasoML.addAll(dao.searchForFechaAndRazon(caso));
                
                tablaCasoML.setItems(oblistCasoML);
            }else if (boxStatusML.getValue() != null){
                //buscar por razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MLCONSULTORES);
                caso.setStatus((Status) boxStatusML.getValue());
                
                tablaCasoML.getItems().clear();
                oblistCasoML.addAll(dao.searchForRazonAndStatus(caso));
                
                tablaCasoML.setItems(oblistCasoML);
            }else{
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                
                alerta.setHeaderText("No ha filtrado nada en la búsqueda");
                //alerta.setContentText(ex.getMessage());
                alerta.show();
            }
                
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
    
    @FXML private void limpiarML(ActionEvent event){
        obtenerCasosML();
        boxClienteML.setValue(null);
        boxDate2ML.setValue(null);
        boxDateML.setValue(null);
        boxStatusML.setValue(null);
    }
    
    private void obtenerCasosML(){
        try {
            CasoDao dao = new CasoDaoMysql();
            
            Caso caso = new Caso();
            caso.setRazonSocial(RazonSocial.MLCONSULTORES);
            
            tablaCasoML.getItems().clear();
            oblistCasoML.addAll(dao.searchForRazon(caso));
            
            ColumnIdML.setCellValueFactory(new PropertyValueFactory("id"));
            ColumnRazonSocialML.setCellValueFactory(new PropertyValueFactory("razonSocial"));
            ColumnStatusML.setCellValueFactory(new PropertyValueFactory("status"));
            ColumnClienteML.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
            ColumnTipoPagoML.setCellValueFactory(new PropertyValueFactory("tipo"));
            ColumnFechaML.setCellValueFactory(new PropertyValueFactory("fechaInicioFormato"));

            
            tablaCasoML.setItems(oblistCasoML);
        } catch (ConnectException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDBCConnectionException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CommunicationsException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionInInitializerError ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    @FXML private void buscarCasosMDP(ActionEvent event){
            try {
            //Cliente cliente = boxClienteBusqueda.getValue();adan
           
            CasoDao dao = new CasoDaoMysql();
            
            //Este if es en caso de tener el campo de busqueda por fechaFinal lleno, de no ser asi lo pasa por alto no afecta en el filtrado si es nulo
            Date fechaFin = null;
            if(boxDate2MDP.getValue() != null){
                //Se le asigna la ultima hora con el ultimo milisegundo del dia para compararlo con la misma fecha
             fechaFin = Date.from(boxDate2MDP.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                    fechaFin.setHours(23);
                    fechaFin.setMinutes(59);
                    fechaFin.setSeconds(59);
            }
            
            //Desde aqui se compara todos los Filtrados
            if(boxClienteMDP.getValue() != null && boxDateMDP.getValue() != null && boxStatusMDP.getValue() != null){
                //buscar por todo
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MDPABOGADOS);
                caso.setStatus((Status) boxStatusMDP.getValue());
                caso.setFechaInicio(Date.from(boxDateMDP.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2MDP.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                String[] cadenaCliente = boxClienteMDP.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoMDP.getItems().clear();
                oblistCasoMDP.addAll(dao.readFilter(caso));
                
                tablaCasoMDP.setItems(oblistCasoMDP);
            }else if(boxClienteMDP.getValue() != null && boxDateMDP.getValue() != null){
                //Buscar por cliente, fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MDPABOGADOS);
                caso.setFechaInicio(Date.from(boxDateMDP.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2MDP.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                
                String[] cadenaCliente = boxClienteMDP.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoMDP.getItems().clear();
                oblistCasoMDP.addAll(dao.searchForClienteAndFechaAndRazon(caso));
                
                tablaCasoMDP.setItems(oblistCasoMDP);
                
            }else if (boxClienteMDP.getValue() != null && boxStatusMDP.getValue() != null){
                //busqueda por cliente, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MDPABOGADOS);
                caso.setStatus((Status) boxStatusMDP.getValue());
                
                String[] cadenaCliente = boxClienteMDP.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoMDP.getItems().clear();
                oblistCasoMDP.addAll(dao.searchForClienteAndRazonAndStatus(caso));
                
                tablaCasoMDP.setItems(oblistCasoMDP);
            }else if(boxClienteMDP.getValue() != null){
                //buscar por cliente y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MDPABOGADOS);
                
                String[] cadenaCliente = boxClienteMDP.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoMDP.getItems().clear();
                oblistCasoMDP.addAll(dao.searchForClienteAndRazon(caso));
                
                tablaCasoMDP.setItems(oblistCasoMDP);
            }else if (boxDateMDP.getValue() != null && boxStatusMDP.getValue() != null){
                // buscar por fecha, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MDPABOGADOS);
                caso.setStatus((Status) boxStatusMDP.getValue());
                caso.setFechaInicio(Date.from(boxDateMDP.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2MDP.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCasoMDP.getItems().clear();
                oblistCasoMDP.addAll(dao.searchForFechaAndRazonAndStatus(caso));
                
                tablaCasoMDP.setItems(oblistCasoMDP);
            }else if (boxDateMDP.getValue() != null){
                //buscar por fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MDPABOGADOS);
                caso.setFechaInicio(Date.from(boxDateMDP.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2MDP.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCasoMDP.getItems().clear();
                oblistCasoMDP.addAll(dao.searchForFechaAndRazon(caso));
                
                tablaCasoMDP.setItems(oblistCasoMDP);
            }else if (boxStatusMDP.getValue() != null){
                //buscar por razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.MDPABOGADOS);
                caso.setStatus((Status) boxStatusMDP.getValue());
                
                tablaCasoMDP.getItems().clear();
                oblistCasoMDP.addAll(dao.searchForRazonAndStatus(caso));
                
                tablaCasoMDP.setItems(oblistCasoMDP);
            }else{
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                
                alerta.setHeaderText("No ha filtrado nada en la búsqueda");
                //alerta.setContentText(ex.getMessage());
                alerta.show();
            }
                
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
    
    @FXML private void limpiarMDP(ActionEvent event){
        obtenerCasosMDP();
        boxClienteMDP.setValue(null);
        boxDate2MDP.setValue(null);
        boxDateMDP.setValue(null);
        boxStatusMDP.setValue(null);
    }
    
    private void obtenerCasosMDP(){
        try {
            CasoDao dao = new CasoDaoMysql();
            
            Caso caso = new Caso();
            caso.setRazonSocial(RazonSocial.MDPABOGADOS);
            
            tablaCasoMDP.getItems().clear();
            oblistCasoMDP.addAll(dao.searchForRazon(caso));
            
            ColumnIdMDP.setCellValueFactory(new PropertyValueFactory("id"));
            ColumnRazonSocialMDP.setCellValueFactory(new PropertyValueFactory("razonSocial"));
            ColumnStatusMDP.setCellValueFactory(new PropertyValueFactory("status"));
            ColumnClienteMDP.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
            ColumnTipoPagoMDP.setCellValueFactory(new PropertyValueFactory("tipo"));
            ColumnFechaMDP.setCellValueFactory(new PropertyValueFactory("fechaInicioFormato"));

            
            tablaCasoMDP.setItems(oblistCasoMDP);
        } catch (ConnectException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDBCConnectionException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CommunicationsException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionInInitializerError ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    @FXML private void buscarCasosFMLMartinez(ActionEvent event){
            try {
            //Cliente cliente = boxClienteBusqueda.getValue();adan
           
            CasoDao dao = new CasoDaoMysql();
            
            //Este if es en caso de tener el campo de busqueda por fechaFinal lleno, de no ser asi lo pasa por alto no afecta en el filtrado si es nulo
            Date fechaFin = null;
            if(boxDate2FMLMartinez.getValue() != null){
                //Se le asigna la ultima hora con el ultimo milisegundo del dia para compararlo con la misma fecha
             fechaFin = Date.from(boxDate2FMLMartinez.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                    fechaFin.setHours(23);
                    fechaFin.setMinutes(59);
                    fechaFin.setSeconds(59);
            }
            
            //Desde aqui se compara todos los Filtrados
            if(boxClienteFMLMartinez.getValue() != null && boxDateFMLMartinez.getValue() != null && boxStatusFMLMartinez.getValue() != null){
                //buscar por todo
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLMARTINEZ);
                caso.setStatus((Status) boxStatusFMLMartinez.getValue());
                caso.setFechaInicio(Date.from(boxDateFMLMartinez.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FMLMartinez.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                String[] cadenaCliente = boxClienteFMLMartinez.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFMLMartinez.getItems().clear();
                oblistCasoFMLMartinez.addAll(dao.readFilter(caso));
                
                tablaCasoFMLMartinez.setItems(oblistCasoFMLMartinez);
            }else if(boxClienteFMLMartinez.getValue() != null && boxDateFMLMartinez.getValue() != null){
                //Buscar por cliente, fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLMARTINEZ);
                caso.setFechaInicio(Date.from(boxDateFMLMartinez.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FMLMartinez.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                
                String[] cadenaCliente = boxClienteFMLMartinez.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFMLMartinez.getItems().clear();
                oblistCasoFMLMartinez.addAll(dao.searchForClienteAndFechaAndRazon(caso));
                
                tablaCasoFMLMartinez.setItems(oblistCasoFMLMartinez);
                
            }else if (boxClienteFMLMartinez.getValue() != null && boxStatusFMLMartinez.getValue() != null){
                //busqueda por cliente, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLMARTINEZ);
                caso.setStatus((Status) boxStatusFMLMartinez.getValue());
                
                String[] cadenaCliente = boxClienteFMLMartinez.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFMLMartinez.getItems().clear();
                oblistCasoFMLMartinez.addAll(dao.searchForClienteAndRazonAndStatus(caso));
                
                tablaCasoFMLMartinez.setItems(oblistCasoFMLMartinez);
            }else if(boxClienteFMLMartinez.getValue() != null){
                //buscar por cliente y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLMARTINEZ);
                
                String[] cadenaCliente = boxClienteFMLMartinez.getEditor().getText().split("\\-");
                int idCliente = Integer.parseInt(cadenaCliente[0]);
                System.out.println(idCliente);

                ClienteDao daoClient = new ClienteDaoMysql();
                caso.setCliente(daoClient.readCliente(idCliente));
                
                tablaCasoFMLMartinez.getItems().clear();
                oblistCasoFMLMartinez.addAll(dao.searchForClienteAndRazon(caso));
                
                tablaCasoFMLMartinez.setItems(oblistCasoFMLMartinez);
            }else if (boxDateFMLMartinez.getValue() != null && boxStatusFMLMartinez.getValue() != null){
                // buscar por fecha, razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLMARTINEZ);
                caso.setStatus((Status) boxStatusFMLMartinez.getValue());
                caso.setFechaInicio(Date.from(boxDateFMLMartinez.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FMLMartinez.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCasoFMLMartinez.getItems().clear();
                oblistCasoFMLMartinez.addAll(dao.searchForFechaAndRazonAndStatus(caso));
                
                tablaCasoFMLMartinez.setItems(oblistCasoFMLMartinez);
            }else if (boxDateFMLMartinez.getValue() != null){
                //buscar por fecha y razon social
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLMARTINEZ);
                caso.setFechaInicio(Date.from(boxDateFMLMartinez.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                
                if(boxDate2FMLMartinez.getValue() == null){
                    caso.setFechaFin(new Date());
                }else{
                    caso.setFechaFin(fechaFin);
                }
                
                tablaCasoFMLMartinez.getItems().clear();
                oblistCasoFMLMartinez.addAll(dao.searchForFechaAndRazon(caso));
                
                tablaCasoFMLMartinez.setItems(oblistCasoFMLMartinez);
            }else if (boxStatusFMLMartinez.getValue() != null){
                //buscar por razon social y status
                
                Caso caso = new Caso();
                caso.setRazonSocial(RazonSocial.FMLMARTINEZ);
                caso.setStatus((Status) boxStatusFMLMartinez.getValue());
                
                tablaCasoFMLMartinez.getItems().clear();
                oblistCasoFMLMartinez.addAll(dao.searchForRazonAndStatus(caso));
                
                tablaCasoFMLMartinez.setItems(oblistCasoFMLMartinez);
            }else{
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                
                alerta.setHeaderText("No ha filtrado nada en la búsqueda");
                //alerta.setContentText(ex.getMessage());
                alerta.show();
            }
                
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
    
    @FXML private void limpiarFMLMartinez(ActionEvent event){
        obtenerCasosFMLMartinez();
        boxClienteFMLMartinez.setValue(null);
        boxDate2FMLMartinez.setValue(null);
        boxDateFMLMartinez.setValue(null);
        boxStatusFMLMartinez.setValue(null);
    }
    
    private void obtenerCasosFMLMartinez(){
        try {
            CasoDao dao = new CasoDaoMysql();
            
            Caso caso = new Caso();
            caso.setRazonSocial(RazonSocial.FMLMARTINEZ);
            
            tablaCasoFMLMartinez.getItems().clear();
            oblistCasoFMLMartinez.addAll(dao.searchForRazon(caso));
            
            ColumnIdFMLMartinez.setCellValueFactory(new PropertyValueFactory("id"));
            ColumnRazonSocialFMLMartinez.setCellValueFactory(new PropertyValueFactory("razonSocial"));
            ColumnStatusFMLMartinez.setCellValueFactory(new PropertyValueFactory("status"));
            ColumnClienteFMLMartinez.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
            ColumnTipoPagoFMLMartinez.setCellValueFactory(new PropertyValueFactory("tipo"));
            ColumnFechaFMLMartinez.setCellValueFactory(new PropertyValueFactory("fechaInicioFormato"));

            
            tablaCasoFMLMartinez.setItems(oblistCasoFMLMartinez);
        } catch (ConnectException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDBCConnectionException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CommunicationsException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionInInitializerError ex) {
            Logger.getLogger(CasosConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
