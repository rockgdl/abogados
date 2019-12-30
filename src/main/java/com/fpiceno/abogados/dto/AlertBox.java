/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dto;
import javafx.application.Platform;
import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author fpiceno
 */
public class AlertBox {
    
    
    
    public  void display(String title ,String message)
    {
        Stage windows=new Stage();
        windows.initModality(Modality.APPLICATION_MODAL);
        windows.setTitle(title);
        windows.setMinWidth(350);
        
        Label label=new Label();
        label.setText(message);
        
        Button button=new Button("Ok");
        button.setOnAction(e ->windows.close());
        
        VBox layout=new VBox(10);
        layout.getChildren().addAll(label,button);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene=new Scene(layout);
         windows.setScene(scene);
        // Platform.runLater(windows::showAndWait);
         windows.showAndWait();
        
        
        
        
    }
}
