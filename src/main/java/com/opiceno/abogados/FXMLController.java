package com.opiceno.abogados;

import com.opiceno.abogados.Entity.Usuario;
import com.opiceno.abogados.dao.sql.UsuarioDaoSqlImpl;
import com.opiceno.abogados.dao.usuarioDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    private usuarioDao dao = new UsuarioDaoSqlImpl();
    
    @FXML private TextField txtNickName;
    @FXML private PasswordField txtPassword;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       
        
        for(Usuario user: dao.read()){
            System.out.println(user.getNombre());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
