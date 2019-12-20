/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.controller;

import com.fpiceno.abogados.dao.ClienteDao;
import com.fpiceno.abogados.dao.mysql.ClienteDaoMysql;
import com.fpiceno.abogados.entity.Cliente;


import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author gnr_a
 */
public class ClienteController implements Initializable {

    @FXML Button btnGuardar;
    @FXML TextField txtNombre, txtTelefono, txtDomicilio, txtRFC, txtCorreo, txtBusqueda;
    @FXML TableView<Cliente> tablaClientes;
    @FXML TableColumn<Cliente, String> columnNombre, columnTelefono, columnDomicilio, columnRFC, columnCorreo;
    ObservableList <Cliente> oblist= FXCollections.observableArrayList();
    
    int idCliente = 0;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        obtenerClientes();
        btnGuardar.setDisable(true);
    }
    
    @FXML private void addCliente(ActionEvent event){
        if(validacionCorreo()){
            Cliente cliente = new Cliente();

            cliente.setId(idCliente);
            cliente.setCorreo(txtCorreo.getText());
            cliente.setDomicilio(txtDomicilio.getText());
            cliente.setNombre(txtNombre.getText());
            cliente.setRfc(txtRFC.getText());
            cliente.setTelefono(txtTelefono.getText());

            ClienteDao dao = new ClienteDaoMysql();
            dao.insert(cliente);
            obtenerClientes();
        }else{
            System.out.println("ERROR");
        }
    }
    
    @FXML private void searchCliente(KeyEvent event){
        if(txtBusqueda.getText().equals("")){
            obtenerClientes();
        }else{
            ClienteDao dao = new ClienteDaoMysql();
                        
            tablaClientes.getItems().clear();
            oblist.addAll(dao.readLike(txtBusqueda.getText()));   
            tablaClientes.setItems(oblist);
        }
    }
    
    @FXML private void deleteCliente(ActionEvent event){
        Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();
        ClienteDao dao = new ClienteDaoMysql();
        dao.delete(cliente);
        obtenerClientes();
    }
    
    @FXML private void updateCliente(ActionEvent evet){
        Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();
        ClienteDao dao = new ClienteDaoMysql();
        
        txtCorreo.setText(cliente.getCorreo());
        txtDomicilio.setText(cliente.getDomicilio());
        txtNombre.setText(cliente.getNombre());
        txtRFC.setText(cliente.getRfc());
        txtTelefono.setText(cliente.getTelefono());
        idCliente = cliente.getId();
        
        obtenerClientes();
        btnGuardar.setDisable(false);
    }
    
    @FXML private void saveCliente(){
        Cliente cliente = new Cliente();
        
        cliente.setId(idCliente);
        cliente.setCorreo(txtCorreo.getText());
        cliente.setDomicilio(txtDomicilio.getText());
        cliente.setNombre(txtNombre.getText());
        cliente.setRfc(txtRFC.getText());
        cliente.setTelefono(txtTelefono.getText());
        
        ClienteDao dao = new ClienteDaoMysql();
        dao.update(cliente);
        
        btnGuardar.setDisable(true);
        this.idCliente = 0;
        obtenerClientes();
    }
    
    private void obtenerClientes(){
        tablaClientes.getItems().clear();
        ClienteDao dao = new ClienteDaoMysql();
        
        Iterator<Cliente> i = dao.read().iterator();
        
        while(i.hasNext()){
            oblist.add(i.next());
        }
        
        columnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnRFC.setCellValueFactory(new PropertyValueFactory("rfc"));
        columnDomicilio.setCellValueFactory(new PropertyValueFactory("domicilio"));
        columnTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        columnCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        
        tablaClientes.setItems(oblist);
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
