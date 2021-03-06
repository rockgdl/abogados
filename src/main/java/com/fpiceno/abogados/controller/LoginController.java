package com.fpiceno.abogados.controller;

import Tools.Roles;
import com.fpiceno.abogados.entity.Usuario;
import com.fpiceno.abogados.dao.mysql.UsuarioDaoMysql;
import com.fpiceno.abogados.dao.UsuarioDao;
import com.fpiceno.abogados.servicios.LoginServicesInterface;
import com.fpiceno.abogados.servicios.impl.LoginServices;
import com.mysql.cj.exceptions.CJCommunicationsException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.hibernate.exception.JDBCConnectionException;

public class LoginController implements Initializable {
    
    private UsuarioDao dao = new UsuarioDaoMysql();
    
    @FXML private TextField txtNickName;
    @FXML private PasswordField txtPassword;
    @FXML private AnchorPane rootPane;
    @FXML private ImageView imageView;
    
    private static final org.apache.log4j.Logger LOG= org.apache.log4j.Logger.getLogger(LoginController.class.getSimpleName());

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
              
        try {
            for(Usuario user: dao.read()){
                System.out.println(user.getNickName());
            }
        } catch (ConnectException ex) {
           java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            Alert  alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText("Error Autentificando al Usuario "+txtNickName.getText() );
           alert.setTitle("Notificación");
           alert.setContentText("Error con la comunicacion a la base de datos favor de revisar el servicio de Mysql" +ex.getMessage());
           alert.showAndWait();
           
        } catch (JDBCConnectionException ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CommunicationsException ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionInInitializerError ex) {
            java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      LOG.info("entrando a inicializar el contenido del login");
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
    public void buttonPressed(KeyEvent e)
    {
        if(e.getCode().toString().equals("ENTER"))
            {
                LOG.info("tecla presionada de enter");
            try {
                Entrar();
                //do something
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CommunicationsException ex) {
                java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
    
    
    @FXML
    public void recoverPassword()
    {
            LoginServicesInterface services=new LoginServices();
           Alert  alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setHeaderText("correo registrado" );
           alert.setTitle("Recuperar Contraseña");
           alert.setContentText("Ingresa tu correo para enviar la contraseña ");
           //alert.showAndWait();
            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("Recuperar Contraseña");
            dialog.setHeaderText("¿Deseas recuperar la contraseña?");
            dialog.setContentText("Ingresa tu correo para enviar la contraseña");

                
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                LOG.info("tu correo es : " + result.get());
                    Usuario usuario= null;
                   UsuarioDao dao = new UsuarioDaoMysql();
               try {
                   usuario=dao.readUserByEmail(result.get());
                   LOG.info("mandare correo a este usuario"+usuario);
                   services.sendEmail(usuario);
                   //envio de correo metodo 
               } catch (ConnectException ex) {
                   java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (JDBCConnectionException ex) {
                   java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (CommunicationsException ex) {
                   java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (InvocationTargetException ex) {
                   java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ExceptionInInitializerError ex) {
                   java.util.logging.Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
    }
    
    @FXML
    private void Entrar() throws IOException, CommunicationsException{
        AnchorPane pane;
        UsuarioDao dao = new UsuarioDaoMysql();
        AnchorPane content = null;
        Usuario usuario= null;
        try{
         usuario = dao.checkUser(txtNickName.getText(), txtPassword.getText());
       // log.info(" entrando  a la aplicacion con el rol "+usuario.getRol());
        //usuario.setRol(Roles.ADMINISTRADOR);
        }catch(ConnectException e)
        {
             LOG.error("error al conectar ");
             Alert  alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText("Error Autentificando al Usuario "+txtNickName.getText() );
           alert.setTitle("Notificación");
           alert.setContentText("Error con la comunicacion a la base de datos favor de revisar el servicio de Mysql" +e.getMessage());
           alert.showAndWait();
           
        }
    catch (JDBCConnectionException e1)
    {
         LOG.error("error jdbc");
           Alert  alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText("Error Autentificando al Usuario "+txtNickName.getText() );
           alert.setTitle("Notificación");
           alert.setContentText("Error con la comunicacion a la base de datos favor de revisar el servicio de Mysql "+e1.getMessage());
           alert.showAndWait();
    }
        catch (InvocationTargetException e2)
        {
             LOG.error("error invocation");
              Alert  alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText("Error Autentificando al Usuario "+txtNickName.getText() );
           alert.setTitle("Notificación");
           alert.setContentText("Error con la comunicacion a la base de datos favor de revisar el servicio de Mysql "+e2.getMessage());
           alert.showAndWait();
        }
        catch (ExceptionInInitializerError e4)
        {
                   LOG.error("error al inicializar la base de datos favor de revisar el servicio de mysql");
              Alert  alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText("Error Autentificando al Usuario "+txtNickName.getText() );
           alert.setTitle("Notificación");
           alert.setContentText("Error con la comunicacion a la base de datos favor de revisar el servicio de Mysql "+e4.getMessage());
           alert.showAndWait();
        }
  

  
       if(usuario!=null && usuario.getRol()!=null)
       {
        
        switch(usuario.getRol()){
            case ADMINISTRADOR: 
                 LOG.info("cargando vista Administrador");
                 pane= FXMLLoader.load(getClass().getResource("/fxml/Administrador.fxml"));
                 rootPane.getChildren().setAll(pane);
                break;
                
            case INGRESOS:
                    LOG.info("cargando vista de ingresos");
                  pane = FXMLLoader.load(getClass().getResource("/fxml/Administrador.fxml"));
                 rootPane.getChildren().setAll(pane);
                break;
            case EGRESOS:
                    LOG.info("cargando vista Egregos");
                  pane = FXMLLoader.load(getClass().getResource("/fxml/Administrador.fxml"));
                 rootPane.getChildren().setAll(pane);
                 break;
            case CONSULTA: 
                    LOG.info("cargando vista Reportes");
                  pane = FXMLLoader.load(getClass().getResource("/fxml/Administrador.fxml"));
                 rootPane.getChildren().setAll(pane);
                 break;
             default:
            {
                  Alert  alert = new Alert(Alert.AlertType.ERROR);
                  alert.setHeaderText("header");
                  alert.setTitle("Notificación");
                  alert.setContentText("Error desconocido , Favor de Contactar a USD");
                  alert.showAndWait();
            }
                break;
        }
        
       }
       else
       {
           Alert  alert = new Alert(Alert.AlertType.WARNING);
           alert.setHeaderText("Error Autentificando al Usuario "+txtNickName.getText() );
           alert.setTitle("Notificación");
           alert.setContentText("No existe el usuario en la base de datos  o la contraseña es incorrecta");
           alert.showAndWait();
       }
        

    }
    
    
    @FXML
    private void Register() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Usuarios.fxml"));
        Parent root;
        
        root = fxmlLoader.load();
        UsuariosController controller = fxmlLoader.getController();
        controller.boxRol.setDisable(true);
        
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
