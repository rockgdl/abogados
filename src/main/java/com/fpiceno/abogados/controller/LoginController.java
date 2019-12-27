package com.fpiceno.abogados.controller;

import com.fpiceno.abogados.entity.Usuario;
import com.fpiceno.abogados.dao.mysql.UsuarioDaoMysql;
import com.fpiceno.abogados.dao.UsuarioDao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class LoginController implements Initializable {
    
    private UsuarioDao dao = new UsuarioDaoMysql();
    
    @FXML private TextField txtNickName;
    @FXML private PasswordField txtPassword;
    @FXML private AnchorPane rootPane;
    @FXML private ImageView imageView;
    
    private final Logger log= Logger.getLogger(LoginController.class.getSimpleName());
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
              
        for(Usuario user: dao.read()){
            System.out.println(user.getNickName());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      log.info("entrando a inicializar el contenido del login");
      FileInputStream input;
//        try {
            //input = new FileInputStream("/imagenes/logo1.jpg");
            Image image = new Image("/imagenes/logo1.jpg");
         //imageView = new ImageView(image);+
                 imageView.setImage(image);
//        } catch (FileNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }


    }    
    
    @FXML
    private void Entrar(ActionEvent event) throws IOException{
                
        UsuarioDao dao = new UsuarioDaoMysql();
         AnchorPane content = null;
        Usuario usuario = dao.checkUser(txtNickName.getText(), txtPassword.getText());
        log.info("error al entrar a la aplicacion ");
       log.info(usuario.getRol());
  
       
        
        switch(usuario.getRol()){
            case ADMINISTRADOR: 
                 AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Caso.fxml"));
                 rootPane.getChildren().setAll(pane);
                break;
                
            case INGRESOS: break;
            case EGRESOS: break;
            case CONSULTA: break;     
        }
        
   
        

    }
}
