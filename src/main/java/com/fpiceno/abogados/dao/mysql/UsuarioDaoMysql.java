/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao.mysql;

import com.fpiceno.abogados.config.HibernateUtil;
import com.fpiceno.abogados.dao.UsuarioDao;
import com.fpiceno.abogados.entity.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author fpiceno
 */
public class UsuarioDaoMysql implements UsuarioDao {

    @Override
    public Integer agregarUsuario(Usuario usuario) {

        Session session = getSession();
        session.save(usuario);
        session.close();
        return 0;
    }

    @Override
    public void insert(Usuario usuario) {
        Session session = getSession();
        session.beginTransaction();

        session.save(usuario);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public void delete(Usuario usuario) {
        Session session = getSession();
        session.beginTransaction();

        session.delete(usuario);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public void update(Usuario usuario) {
        Session session = getSession();
        session.beginTransaction();

        session.update(usuario);
        session.getTransaction().commit();

        getSession().close();
    }

    @Override
    public List<Usuario> read() {
        Criteria cr = getSession().createCriteria(Usuario.class);
        return cr.list();
    }

    @Override
    public Usuario readUser(int code) {
        Criteria cr = getSession().createCriteria(Usuario.class);
        cr.add(Restrictions.eq("id", code));

        return (Usuario) cr.uniqueResult();
    }

    

    @Override
    public Usuario checkUser(String nickName, String password) {
        Criteria cr = getSession().createCriteria(Usuario.class);
        cr.add(Restrictions.eq("nickName",nickName)).add(Restrictions.eq("password",password));

        return (Usuario) cr.uniqueResult();
    }
    
    public Session getSession() {

        return HibernateUtil.getSession();
    }
}
