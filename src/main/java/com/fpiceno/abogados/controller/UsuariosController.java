/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.controller;

import Tools.Roles;
import com.fpiceno.abogados.entity.Usuario;
import com.fpiceno.abogados.dao.UsuarioDao;
import com.fpiceno.abogados.dao.mysql.UsuarioDaoMysql;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;

import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import org.hibernate.exception.JDBCConnectionException;

/**
 * FXML Controller class
 *
 * @author gnr_a
 */
public class UsuariosController implements Initializable {

    @FXML private TextField txtSearch, txtNickname, txtCorreo;
    @FXML private PasswordField txtPassword, txtConfirmar ;
    @FXML private RadioButton btnActivoSi, btnActivoNo;
    @FXML public ComboBox boxRol;
    
    @FXML private TableView<Usuario> tablaUsuario;
    @FXML private TableColumn <Usuario, String> columnCorreo, columnNickname, columnPassword;
    ObservableList <Usuario> oblist= FXCollections.observableArrayList();
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        obtenerUsuarios();
        
        //Agregar los radio button a un grupo para que solo seleccione uno de los 2 casos (si o no)
        ToggleGroup grupo = new ToggleGroup();
        btnActivoNo.setToggleGroup(grupo);
        btnActivoSi.setToggleGroup(grupo);
        
        btnActivoSi.setSelected(true);
        
        
        boxRol.setItems(FXCollections.observableArrayList(Roles.values()));
    }
    
    private void obtenerUsuarios(){
        try {
            tablaUsuario.getItems().clear();
            UsuarioDao dao = new UsuarioDaoMysql();
            
            Iterator<Usuario> i = dao.read().iterator();
            
            while(i.hasNext()){
                oblist.add(i.next());
            }
            
            columnCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
            columnNickname.setCellValueFactory(new PropertyValueFactory("nickName"));
            columnPassword.setCellValueFactory(new PropertyValueFactory("password"));
            
            tablaUsuario.setItems(oblist);
        } catch (ConnectException ex) {
                
                Alert alerta = new Alert(AlertType.ERROR);
                
                alerta.setHeaderText("No se pudo conectar a mysql");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (JDBCConnectionException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                
                Alert alerta = new Alert(AlertType.ERROR);
                
                alerta.setHeaderText("Se encontro un error al quere insertar la información");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (CommunicationsException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                
                Alert alerta = new Alert(AlertType.ERROR);
                
                alerta.setHeaderText("No se pudo comunicar con la base de datos mysql");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (InvocationTargetException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExceptionInInitializerError ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @FXML private void addUser(ActionEvent event){
        Date date = new Date();
        
        UsuarioDao dao = new UsuarioDaoMysql();
        Usuario usuario = new Usuario();
        
        //usuario.setNombre(txtNombre.getText());
        usuario.setNickName(txtNickname.getText());
        usuario.setPassword(txtPassword.getText());
        usuario.setFechaCreacion(date);
        usuario.setRol((Roles) boxRol.getSelectionModel().getSelectedItem());
        usuario.setCorreo(txtCorreo.getText());
        
        if(verificarCampos()){
            try {
                dao.insert(usuario);   
                obtenerUsuarios();
            } catch (ConnectException ex) {
                
                Alert alerta = new Alert(AlertType.ERROR);
                
                alerta.setHeaderText("No se pudo conectar a mysql");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (JDBCConnectionException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                
                Alert alerta = new Alert(AlertType.ERROR);
                
                alerta.setHeaderText("Se encontro un error al quere insertar la información");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (CommunicationsException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                
                Alert alerta = new Alert(AlertType.ERROR);
                
                alerta.setHeaderText("No se pudo comunicar con la base de datos mysql");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (InvocationTargetException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExceptionInInitializerError ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML private void deleteUser(ActionEvent event){
        Usuario usuario = tablaUsuario.getSelectionModel().getSelectedItem();
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMACION");
        alert.setHeaderText("Se va a eliminar al usuario " + usuario.getNickName());
        alert.setContentText("¿Seguro que desea eliminarlo?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            try {
                UsuarioDao dao = new UsuarioDaoMysql();
                dao.delete(usuario);
                obtenerUsuarios();
            } catch (ConnectException ex) {
                
                Alert alerta = new Alert(AlertType.ERROR);
                
                alerta.setHeaderText("No se pudo conectar a mysql");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (JDBCConnectionException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                
                Alert alerta = new Alert(AlertType.ERROR);
                
                alerta.setHeaderText("Se encontro un error al quere insertar la información");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (CommunicationsException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                
                Alert alerta = new Alert(AlertType.ERROR);
                
                alerta.setHeaderText("No se pudo comunicar con la base de datos mysql");
                alerta.setContentText(ex.getMessage());
                alerta.show();
                
            } catch (InvocationTargetException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExceptionInInitializerError ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
        }
        
    }
    
    @FXML private void seacrh(KeyEvent evet){
        if(txtSearch.getText().equals("")){
            obtenerUsuarios();
        }
    }
    
    private void obtenerBusqueda(){
        
    }
    
    @FXML private void limitarCaracteres(KeyEvent event){
        if(txtNickname.getText().length() > 20){
            txtNickname.setText(txtNickname.getText().substring(0, 20));
            txtNickname.positionCaret(20);
        }
    }
    
    private boolean verificarCampos(){
        boolean permitido = true;
        
        if(txtNickname.getText().equals("")){
            permitido = false;
            Alert alerta  = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("¡Error!");
            alerta.setHeaderText("El usuario no puede quedar vacio");
            alerta.show();
        }
        
        if (txtPassword.getText().equals("")){
            permitido = false;
            Alert alerta  = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("¡Error!");
            alerta.setHeaderText("Ingrese una contraseña");
            alerta.show();
            
        }else if (!txtConfirmar.getText().equals(txtPassword.getText())){
            permitido = false;
            Alert alerta  = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("¡Error!");
            alerta.setHeaderText("La contraseña no es la misma");
            alerta.show();
        }
        
        if (boxRol.getSelectionModel().isEmpty()){
            permitido = false;
            Alert alerta  = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("¡Error!");
                alerta.setHeaderText("Seleccione un rol");
                alerta.show();
        }
        
        if(!validacionCorreo() && txtCorreo.getText().equals("")){
            Alert alerta  = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("¡Error!");
                alerta.setHeaderText("Verifique si el campo no esta vacio");
                alerta.show();
        }
            
       return permitido;
    }
    
    
    public boolean validacionCorreo(){
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9._]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(txtCorreo.getText());
        
        if(m.find() && m.group().equals(txtCorreo.getText())){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("¡Error!");
            alert.setContentText("El formato de correo es invalido");
            alert.showAndWait();
            return false;
        }   
    }
}
