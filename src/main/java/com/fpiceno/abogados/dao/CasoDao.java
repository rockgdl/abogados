/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao;

import com.fpiceno.abogados.entity.Caso;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.util.List;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author gnr_a
 */
public interface CasoDao {
    public void insert(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public void delete(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public void update(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> read() throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public Caso readCaso(int code) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> readRazonSocial(String cadena) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> readStatus(String cadena) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> readFilter(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    
    //public List<Caso> searchForClienteAndFechaAndRazonAndStatus(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForClienteAndFechaAndRazon(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForClienteAndFechaAndStatus(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForClienteAndRazonAndStatus(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForClienteAndFecha(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForClienteAndRazon(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForClienteAndStatus(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForCliente(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    
    public List<Caso> searchForFechaAndRazonAndStatus(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForFechaAndRazon(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForFechaAndStatus(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForFecha(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    
    public List<Caso> searchForRazonAndStatus(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForRazon(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;
    public List<Caso> searchForStatus(Caso caso) throws ConnectException,JDBCConnectionException,CommunicationsException,InvocationTargetException,ExceptionInInitializerError;

}
