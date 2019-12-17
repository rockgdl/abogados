/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiceno.abogados.dao.sql;

import com.opiceno.abogados.Entity.Usuario;
import com.opiceno.abogados.dao.usuarioDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gnr_a
 */

public class UsuarioDaoSqlImpl implements usuarioDao {

    @Override
    public void insert(Usuario usuario) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(usuario);
        session.getTransaction().commit();
        
	getSessionFactory().openSession().close();
    }

    @Override
    public void delete(Usuario usuario) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        
        session.delete(usuario);
        session.getTransaction().commit();
        
	getSessionFactory().openSession().close();
    }

    @Override
    public void update(Usuario usuario) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(usuario);
        session.getTransaction().commit();
        
	getSessionFactory().openSession().close();
    }

    @Override
    public List<Usuario> read() {
        Criteria cr = getSessionFactory().openSession().createCriteria(Usuario.class);
        return cr.list();
    }

    @Override
    public Usuario readUser(int code) {
        Criteria cr = getSessionFactory().openSession().createCriteria(Usuario.class);
        cr.add(Restrictions.eq("id", code));

        return (Usuario) cr.uniqueResult();
    }
    
    private SessionFactory getSessionFactory(){
        SessionFact session = new SessionFact();
        return session.getSessionFactory();
    }
    
}
