/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao.mysql;

import com.fpiceno.abogados.config.HibernateUtil;
import com.fpiceno.abogados.dao.ClienteDao;
import com.fpiceno.abogados.entity.Cliente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gnr_a
 */
public class ClienteDaoMysql implements ClienteDao{

    @Override
    public void insert(Cliente cliente) {
        Session session = getSession();
        session.beginTransaction();

        session.save(cliente);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public void delete(Cliente cliente) {
        Session session = getSession();
        session.beginTransaction();

        session.delete(cliente);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public void update(Cliente cliente) {
        Session session = getSession();
        session.beginTransaction();

        session.update(cliente);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public List<Cliente> read() {
        Criteria cr = getSession().createCriteria(Cliente.class);
        return cr.list();
    }

    @Override
    public Cliente readClient(int code) {
        Criteria cr = getSession().createCriteria(Cliente.class);
        cr.add(Restrictions.eq("id", code));

        return (Cliente) cr.uniqueResult();
    }
    
    public Session getSession() {

        return HibernateUtil.getSession();
    }
    
}
