/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao.mysql;

import com.fpiceno.abogados.config.HibernateUtil;
import com.fpiceno.abogados.dao.PagoDao;
import com.fpiceno.abogados.entity.Pago;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gnr_a
 */
public class PagoDaoMysql implements PagoDao{
    @Override
    public void insert(Pago pago) {
        Session session = getSession();
        session.beginTransaction();

        session.save(pago);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public void delete(Pago pago) {
        Session session = getSession();
        session.beginTransaction();

        session.delete(pago);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public void update(Pago pago) {
        Session session = getSession();
        session.beginTransaction();

        session.update(pago);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public List<Pago> read() {
        Criteria cr = getSession().createCriteria(Pago.class);
        return cr.list();
    }

    @Override
    public Pago readPayment(int code) {
        Criteria cr = getSession().createCriteria(Pago.class);
        cr.add(Restrictions.eq("id", code));

        return (Pago) cr.uniqueResult();
    }
    
    @Override
    public List<Pago> readLike(String cadena) {
        Criteria cr = getSession().createCriteria(Pago.class);
        cr.add(Restrictions.like("nombre", cadena+"%"));
        return cr.list();
    }
    
    public Session getSession() {

        return HibernateUtil.getSession();
    }
}
