/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao.mysql;

import com.fpiceno.abogados.config.HibernateUtil;
import com.fpiceno.abogados.dao.CasoDao;
import com.fpiceno.abogados.entity.Caso;
import com.fpiceno.abogados.entity.Status;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author gnr_a
 */
public class CasoDaoMysql implements CasoDao{
    @Override
    public void insert(Caso caso) {
        Session session = getSession();
        session.beginTransaction();

        session.save(caso);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public void delete(Caso caso) {
        Session session = getSession();
        session.beginTransaction();

        session.delete(caso);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public void update(Caso caso) {
        Session session = getSession();
        session.beginTransaction();

        session.update(caso);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public List<Caso> read() {
        Criteria cr = getSession().createCriteria(Caso.class);
        cr.add(Restrictions.ne("status", Status.FINALIZADO));
        return cr.list();
    }

    @Override
    public Caso readCaso(int code) {
        Criteria cr = getSession().createCriteria(Caso.class);
        cr.add(Restrictions.eq("id", code));

        return (Caso) cr.uniqueResult();
    }
    
    @Override
    public List<Caso> readRazonSocial(String cadena) {
        Criteria cr = getSession().createCriteria(Caso.class);
        cr.add(Restrictions.like("razonSocial", "%"+cadena+"%"));
        return cr.list();
    }
    
    @Override
    public List<Caso> readStatus(String cadena) {
        Criteria cr = getSession().createCriteria(Caso.class);
        cr.add(Restrictions.like("status", "%"+cadena+"%"));
        return cr.list();
    }
    
    @Override
    public List<Caso> readFilter(Caso caso){
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("cliente", caso.getCliente())).add(Restrictions.eq("razonSocial", caso.getRazonSocial())).add(Restrictions.eq("status", caso.getStatus())).add(Restrictions.between("fechaInicio", caso.getFechaInicio(), caso.getFechaFin()));

        return cr.list();
        
//        Query query = getSession().createQuery("SELECT c.* FROM Caso c INNER JOIN cliente cl ON c.cliente_id = cl.id AND c.razonSocial =:rs AND c.status =: sta");
//        
//        query.setParameter("sta", caso.getStatus());
//        query.setParameter("rs", caso.getRazonSocial());
//        
//        query.executeUpdate();
//        
//        return query.list();
    }
    
    public Session getSession() {

        return HibernateUtil.getSession();
    }

    @Override
    public List<Caso> searchForClienteAndFechaAndRazon(Caso caso) {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("cliente", caso.getCliente())).add(Restrictions.eq("razonSocial", caso.getRazonSocial())).add(Restrictions.between("fechaInicio", caso.getFechaInicio(), caso.getFechaFin()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForClienteAndFechaAndStatus(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("cliente", caso.getCliente())).add(Restrictions.eq("status", caso.getStatus())).add(Restrictions.between("fechaInicio", caso.getFechaInicio(), caso.getFechaFin()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForClienteAndRazonAndStatus(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("cliente", caso.getCliente())).add(Restrictions.eq("razonSocial", caso.getRazonSocial())).add(Restrictions.eq("status", caso.getStatus()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForClienteAndFecha(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("cliente", caso.getCliente())).add(Restrictions.between("fechaInicio", caso.getFechaInicio(), caso.getFechaFin()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForClienteAndRazon(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("cliente", caso.getCliente())).add(Restrictions.eq("razonSocial", caso.getRazonSocial()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForClienteAndStatus(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("cliente", caso.getCliente())).add(Restrictions.eq("status", caso.getStatus()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForCliente(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("cliente", caso.getCliente()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForFechaAndRazonAndStatus(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("razonSocial", caso.getRazonSocial())).add(Restrictions.eq("status", caso.getStatus())).add(Restrictions.between("fechaInicio", caso.getFechaInicio(), caso.getFechaFin()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForFechaAndRazon(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("razonSocial", caso.getRazonSocial())).add(Restrictions.between("fechaInicio", caso.getFechaInicio(), caso.getFechaFin()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForFechaAndStatus(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("status", caso.getStatus())).add(Restrictions.between("fechaInicio", caso.getFechaInicio(), caso.getFechaFin()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForFecha(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.between("fechaInicio", caso.getFechaInicio(), caso.getFechaFin()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForRazonAndStatus(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("razonSocial", caso.getRazonSocial())).add(Restrictions.eq("status", caso.getStatus()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForRazon(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("razonSocial", caso.getRazonSocial()));

        return cr.list();
    }

    @Override
    public List<Caso> searchForStatus(Caso caso) throws ConnectException, JDBCConnectionException, CommunicationsException, InvocationTargetException, ExceptionInInitializerError {
        Criteria cr = getSession().createCriteria(Caso.class);
        
        //System.out.println(caso.getCliente().getNombre());
        cr.add(Restrictions.eq("status", caso.getStatus()));

        return cr.list();
    }
    
    
}
