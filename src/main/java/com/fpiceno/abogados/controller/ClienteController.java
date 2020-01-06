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
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    @FXML Label lblNombre, lblCorreo, lblRFC, lblTelefono, lblDomicilio;
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
        if(verificar()){
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
            limpiar();
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
            
            if(oblist.size() == 0){
                oblist.clear();
                oblist.addAll(dao.readRFC(txtBusqueda.getText()));
            }
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
        if (verificar()){
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
            limpiar();
        }
    }
    
    /* VErificar que ningun campo sea nulo y sea correcto*/
    private boolean verificar(){
        boolean permitido = true;
        
        if(txtNombre.getText().equals("")){
            lblNombre.setVisible(true);
            permitido = false;
        }else{
            lblNombre.setVisible(false);    
        }
        
        if(txtCorreo.getText().equals("") || !validacionCorreo()){
            lblCorreo.setVisible(true);
            permitido = false;
        }else{
            lblCorreo.setVisible(false);    
        }
        
        if(txtDomicilio.getText().equals("")){
            lblDomicilio.setVisible(true);
            permitido = false;
        }else{
            lblDomicilio.setVisible(false);    
        }
        
        if(txtRFC.getText().equals("")){
            lblRFC.setVisible(true);
            permitido = false;
        }else{
            lblRFC.setVisible(false);    
        }
        
        try{
            Integer.parseInt(txtTelefono.getText());
            lblTelefono.setVisible(false);
        }catch(NumberFormatException ex){
            permitido = false;
            lblTelefono.setVisible(true);
        }
        
        
        return permitido;
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
    
    @FXML private void LimitarCaracteres(KeyEvent event){
        if(txtNombre.getText().length() > 30){
            txtNombre.setText(txtNombre.getText().substring(0, 30));
            txtNombre.positionCaret(30);
        }
        
        if(txtRFC.getText().length() > 13){
            txtRFC.setText(txtRFC.getText().substring(0, 13));
            txtRFC.positionCaret(13);
        }
        
        if(txtCorreo.getText().length() > 30){
            txtCorreo.setText(txtCorreo.getText().substring(0, 30));
            txtCorreo.positionCaret(30);
        }
        
        if(txtDomicilio.getText().length() > 40){
            txtNombre.setText(txtNombre.getText().substring(0, 40));
            txtNombre.positionCaret(40);
        }
        
        if(txtTelefono.getText().length() > 10){
            txtTelefono.setText(txtTelefono.getText().substring(0, 10));
            txtTelefono.positionCaret(10);
        }
        
    }
    
    private void limpiar(){
        txtCorreo.clear();
        txtDomicilio.clear();
        txtNombre.clear();
        txtRFC.clear();
        txtTelefono.clear();
    }
}
