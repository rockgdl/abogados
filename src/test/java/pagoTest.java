/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Tools.tipoPago;
import com.fpiceno.abogados.dao.CasoDao;
import com.fpiceno.abogados.dao.PagoDao;
import com.fpiceno.abogados.dao.mysql.CasoDaoMysql;
import com.fpiceno.abogados.dao.mysql.PagoDaoMysql;
import com.fpiceno.abogados.entity.Pago;
import java.util.Date;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gnr_a
 */
public class pagoTest {
    private Date date = new Date();
    
    public pagoTest() {
    }
    
//    @Test
//    public void add(){
//        PagoDao dao = new PagoDaoMysql();
//        CasoDao daoCaso = new CasoDaoMysql();
//        Pago pago = new Pago();
//        
//        pago.setConcepto("Pago 1");
//        pago.setIdFacutura(1);
//        pago.setFechaPago(date);
//        pago.setCantidad(3);
//        //pago.setCaso(daoCaso.readCaso(1));
//        dao.insert(pago);
//        
//        pago.setConcepto("Pago 2");
//        pago.setIdFacutura(1);
//        pago.setFechaPago(date);
//        pago.setCantidad(3);
//        //pago.setCaso(daoCaso.readCaso(1));
//        
//             
//        dao.insert(pago);
//        
//        pago.setConcepto("Pago 3");
//        pago.setIdFacutura(2);
//        pago.setFechaPago(date);
//        pago.setCantidad(3);
//        //pago.setCaso(daoCaso.readCaso(1));
//             
//        dao.insert(pago);
//        
//    }
//    
//    @Test
//    public void read(){
//        PagoDao dao = new PagoDaoMysql();
//        
//        Iterator<Pago> i = dao.read().iterator();
//        
//        while(i.hasNext()){
//            System.out.println(i.next().getConcepto());
//        }
//    }
//    
//    @Test
//    public void update(){
//        PagoDao dao = new PagoDaoMysql();
//        
//        Pago pago = new Pago();
//        pago.setId(1);
//        pago.setConcepto("Pago Modificado");
//        pago.setIdFacutura(4);
//        pago.setFechaPago(date);
//        pago.setCantidad(4);
//        
//        
//        dao.update(pago);
//    }
//    
//    @Test
//    public void delete(){
//        PagoDao dao = new PagoDaoMysql();
//        
//        Pago pago = new Pago();
//        pago.setId(2);
//        
//        dao.delete(pago);
//    }
    
}
