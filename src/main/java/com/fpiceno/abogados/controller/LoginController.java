package com.fpiceno.abogados.controller;

import com.fpiceno.abogados.entity.Usuario;
import com.fpiceno.abogados.dao.mysql.UsuarioDaoMysql;
import com.fpiceno.abogados.dao.UsuarioDao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
    
    private UsuarioDao dao = new UsuarioDaoMysql();
    
    @FXML private TextField txtNickName;
    @FXML private PasswordField txtPassword;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
              
        for(Usuario user: dao.read()){
            System.out.println(user.getNickName());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void Entrar(ActionEvent event){
                
        UsuarioDao dao = new UsuarioDaoMysql();
        
        Usuario usuario = dao.checkUser(txtNickName.getText(), txtPassword.getText());
        
        System.out.println(usuario.getRol());
        
        switch(usuario.getRol()){
            case ADMINISTRADOR: break;
            case INGRESOS: break;
            case EGRESOS: break;
            case CONSULTA: break;     
        }

    }
}
