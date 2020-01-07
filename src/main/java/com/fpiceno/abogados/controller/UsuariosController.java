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

import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author gnr_a
 */
public class UsuariosController implements Initializable {

    @FXML private TextField txtSearch, txtNickname;
    @FXML private PasswordField txtPassword, txtConfirmar;
    @FXML private RadioButton btnActivoSi, btnActivoNo;
    @FXML private ComboBox boxRol;
    
    @FXML private TableView<Usuario> tablaUsuario;
    @FXML private TableColumn <Usuario, String> columnNombre, columnNickname, columnPassword;
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
        
        
        boxRol.setItems(FXCollections.observableArrayList(Roles.values()));
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
        Date date = new Date();
        
        UsuarioDao dao = new UsuarioDaoMysql();
        Usuario usuario = new Usuario();
        
        //usuario.setNombre(txtNombre.getText());
        usuario.setNickName(txtNickname.getText());
        usuario.setPassword(txtPassword.getText());
        usuario.setFechaCreacion(date);
        usuario.setRol((Roles) boxRol.getSelectionModel().getSelectedItem());
        
        if(verificarCampos()){
            dao.insert(usuario);
            obtenerUsuarios();   
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
            UsuarioDao dao = new UsuarioDaoMysql();
            dao.delete(usuario);
            obtenerUsuarios();
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
            
       return permitido;
    }
    
}
