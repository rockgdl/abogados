/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao;

import com.fpiceno.abogados.entity.Usuario;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.util.List;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author fpiceno
 */
public interface UsuarioDao {
    
    public Integer agregarUsuario(Usuario usuario);
    
    public void insert(Usuario usuario);
    public void delete(Usuario usuario);
    public void update(Usuario usuario);
    public List<Usuario> read();
    public Usuario readUser(int code);
    public Usuario checkUser(String nickName, String password) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    
}
