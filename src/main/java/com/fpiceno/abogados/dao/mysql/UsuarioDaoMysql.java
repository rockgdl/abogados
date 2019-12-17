/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao.mysql;

import com.fpiceno.abogados.config.HibernateUtil;
import com.fpiceno.abogados.dao.UsuarioDao;
import com.fpiceno.abogados.entity.Usuario;
import org.hibernate.Session;


/**
 *
 * @author fpiceno
 */
public class UsuarioDaoMysql implements UsuarioDao {

    @Override
    public Integer agregarUsuario(Usuario usuario) {
       
        
        Session session =getSession();
         session.save(usuario);
         session.close();
        return 0;
    }
    
    public  Session getSession()
    {
        
        
        return HibernateUtil.getSession();
    }
}
