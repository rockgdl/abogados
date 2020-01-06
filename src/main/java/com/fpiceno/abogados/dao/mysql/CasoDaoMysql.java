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
import org.hibernate.Query;
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
        cr.add(Restrictions.eq("cliente", caso.getCliente())).add(Restrictions.eq("razonSocial", caso.getRazonSocial())).add(Restrictions.eq("status", caso.getStatus()));

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
    
    
}
