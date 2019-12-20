/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao.mysql;

import com.fpiceno.abogados.config.HibernateUtil;
import com.fpiceno.abogados.dao.CasoDao;
import com.fpiceno.abogados.entity.Caso;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
        return cr.list();
    }

    @Override
    public Caso readClient(int code) {
        Criteria cr = getSession().createCriteria(Caso.class);
        cr.add(Restrictions.eq("id", code));

        return (Caso) cr.uniqueResult();
    }
    
    @Override
    public List<Caso> readLike(String cadena) {
        Criteria cr = getSession().createCriteria(Caso.class);
        cr.add(Restrictions.like("nombre", cadena+"%"));
        return cr.list();
    }
    
    public Session getSession() {

        return HibernateUtil.getSession();
    }
    
}
