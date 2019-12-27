package com.fpiceno.abogados.controller;

import com.fpiceno.abogados.entity.Usuario;
import com.fpiceno.abogados.dao.mysql.UsuarioDaoMysql;
import com.fpiceno.abogados.dao.UsuarioDao;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private void Entrar(ActionEvent event) throws IOException{
                
        UsuarioDao dao = new UsuarioDaoMysql();
        
        Usuario usuario = dao.checkUser(txtNickName.getText(), txtPassword.getText());
        
        System.out.println(usuario.getRol());
        
        Stage stage = new Stage();
        FXMLLoader load = new FXMLLoader();
        AnchorPane root = null;
        
        switch(usuario.getRol()){
            case ADMINISTRADOR: 
                root = (AnchorPane)load.load(getClass().getResource("FXML/Usuarios.fxml").openStream());                  
                // con esto ya solo se manda los datos que se quiera al constructor del controllador
                UsuariosController userController = (UsuariosController) load.getController();
                break;
                
            case INGRESOS: break;
            case EGRESOS: break;
            case CONSULTA: break;     
        }
        
        stage.setScene(new Scene(root));
        stage.show();
        
        //Para eliminar una escena
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
