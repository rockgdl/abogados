/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.controller;

import com.fpiceno.abogados.entity.Usuario;
import com.fpiceno.abogados.dao.UsuarioDao;
import com.fpiceno.abogados.dao.mysql.UsuarioDaoMysql;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author gnr_a
 */
public class UsuariosController implements Initializable {

    @FXML private TextField txtNombre, txtNickname;
    @FXML private PasswordField txtPassword, txtConfirmar;
    
    @FXML private TableView<Usuario> tablaUsuario;
    @FXML private TableColumn <Usuario, String> columnNombre, columnNickname, columnPassword;
    ObservableList <Usuario> oblist= FXCollections.observableArrayList();
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        obtenerUsuarios();
    }
    
    private void obtenerUsuarios(){
        tablaUsuario.getItems().clear();
        UsuarioDao dao = new UsuarioDaoMysql();
        
        Iterator<Usuario> i = dao.read().iterator();
        
        while(i.hasNext()){
            oblist.add(i.next());
        }
        
        columnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnNickname.setCellValueFactory(new PropertyValueFactory("nickName"));
        columnPassword.setCellValueFactory(new PropertyValueFactory("password"));
        
        tablaUsuario.setItems(oblist);
    }
    
    @FXML private void addUser(ActionEvent event){
        UsuarioDao dao = new UsuarioDaoMysql();
        Usuario usuario = new Usuario();
        
        usuario.setNombre(txtNombre.getText());
        usuario.setNickName(txtNickname.getText());
        usuario.setPassword(txtPassword.getText());
        
        if(usuario.getPassword().equals(txtConfirmar.getText())){
            dao.insert(usuario);
            System.out.println("Claves iguales");
            obtenerUsuarios();
        }else{
            //Alert.AlertType.INFORMATION;
            
        }
        
    }
    
    @FXML private void deleteUser(ActionEvent event){
        Usuario usuario = tablaUsuario.getSelectionModel().getSelectedItem();
        UsuarioDao dao = new UsuarioDaoMysql();
        
        usuario.setNombre(txtNombre.getText());
        usuario.setNickName(txtNickname.getText());
        usuario.setPassword(txtPassword.getText());
        
        dao.delete(usuario);
        obtenerUsuarios();
    }
    
   
}