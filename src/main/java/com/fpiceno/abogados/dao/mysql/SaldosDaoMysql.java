/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao.mysql;

import com.fpiceno.abogados.config.HibernateUtil;
import com.fpiceno.abogados.dao.SaldosDao;
import com.fpiceno.abogados.dto.Saldos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author gnr_a
 */
public class SaldosDaoMysql implements SaldosDao{

    @Override
    public List<Saldos> read() {
        Criteria cr = getSession().createCriteria(Saldos.class);
        
        return cr.list();
    }
    
    public Session getSession() {

        return HibernateUtil.getSession();
    }
    
}
