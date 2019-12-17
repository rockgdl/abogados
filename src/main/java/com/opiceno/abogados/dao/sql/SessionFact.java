/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiceno.abogados.dao.sql;

import javax.imageio.spi.ServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 *
 * @author gnr_a
 */
public class SessionFact {
    
    SessionFactory sessionFactory;
    
    Configuration configuration = new Configuration();
    
    
   public  SessionFactory getSessionFactory(){
       configuration.configure("hibernate.cfg.xml");
       sessionFactory = configuration.buildSessionFactory();
       
       return sessionFactory;
   }
}
