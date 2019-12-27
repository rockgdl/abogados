/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao.mysql;

import com.fpiceno.abogados.config.HibernateUtil;
import com.fpiceno.abogados.dao.FacturaDao;
import com.fpiceno.abogados.entity.Factura;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gnr_a
 */
public class FacturaDaoMysql implements FacturaDao {
    @Override
    public void insert(Factura factura) {
        Session session = getSession();
        session.beginTransaction();

        session.save(factura);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public void delete(Factura factura) {
        Session session = getSession();
        session.beginTransaction();

        session.delete(factura);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public void update(Factura factura) {
        Session session = getSession();
        session.beginTransaction();

        session.update(factura);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public List<Factura> read() {
        Criteria cr = getSession().createCriteria(Factura.class);
        return cr.list();
    }

    @Override
    public Factura readFactura(int code) {
        Criteria cr = getSession().createCriteria(Factura.class);
        cr.add(Restrictions.eq("id", code));

        return (Factura) cr.uniqueResult();
    }
    
    @Override
    public List<Factura> readLike(String cadena) {
        Criteria cr = getSession().createCriteria(Factura.class);
        cr.add(Restrictions.like("nombre", cadena+"%"));
        return cr.list();
    }
    
    public Session getSession() {

        return HibernateUtil.getSession();
    }
}
