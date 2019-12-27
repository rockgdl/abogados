/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Tools.statusCaso;
import Tools.tipoPago;
import com.fpiceno.abogados.dao.CasoDao;
import com.fpiceno.abogados.dao.mysql.CasoDaoMysql;
import com.fpiceno.abogados.entity.Caso;
import com.fpiceno.abogados.entity.Pago;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gnr_a
 */
public class CasoTest {
    
//    private Date date = new Date();
//    public CasoTest() {
//    }
//
//    
//    @Test
//    public void add(){
//        CasoDao dao = new CasoDaoMysql();
//        
//        Pago pago1 = new Pago();
//        pago1.setConcepto("Pago 1");
//        pago1.setIdFacutura(1);
//        pago1.setFechaPago(date);
//        pago1.setCantidad(3);
//        //pago.setCaso(daoCaso.readCaso(1));
//        
//        Pago pago2 = new Pago();
//        pago2.setConcepto("Pago 2");
//        pago2.setIdFacutura(5);
//        pago2.setFechaPago(date);
//        pago2.setCantidad(5);
//        //pago.setCaso(daoCaso.readCaso(1));
//        
//        Pago pago3 = new Pago();
//        pago3.setConcepto("Pago 3");
//        pago3.setIdFacutura(2);
//        pago3.setFechaPago(date);
//        pago3.setCantidad(3);
//        //pago.setCaso(daoCaso.readCaso(1));
//                
//        Caso caso = new Caso();
//        
//        caso.setConcepto("Caso 1");
//        caso.setFechaFin(date);
//        caso.setFechaInicio(date);
//        caso.setFechaPago(date);
//        caso.setStatus(statusCaso.ABONADO);
//        caso.setTipo(tipoPago.CHEQUE);
//        caso.getListaPagos().add(pago1);
//        caso.getListaPagos().add(pago2);
//        dao.insert(caso);
//        
//        Caso casoI = new Caso();
//        casoI.setConcepto("Caso 2");
//        casoI.setFechaFin(date);
//        casoI.setFechaInicio(date);
//        casoI.setFechaPago(date);
//        casoI.setStatus(statusCaso.ABONADO);
//        casoI.setTipo(tipoPago.CHEQUE);
//        dao.insert(casoI);
//        
//        Caso casoII = new Caso();
//        casoII.setConcepto("Caso 3");
//        casoII.setFechaFin(date);
//        casoII.setFechaInicio(date);
//        casoII.setFechaPago(date);
//        casoII.setStatus(statusCaso.ABONADO);
//        casoII.setTipo(tipoPago.CHEQUE);
//        casoII.getListaPagos().add(pago3);
//        dao.insert(casoII);
//    }
//    
//    @Test
//    public void read(){
//        CasoDao dao = new CasoDaoMysql();
//        
//        for (Caso caso : dao.read()){
//            System.out.println("-------------------------------------------------------------------------");
//            System.out.println("Este es el caso" + caso.getId());
//            for (Pago pago : caso.getListaPagos()){
//                System.out.println("Este es el pago" + pago);
//            }
//        }
//    }
//    
//    @Test
//    public void update(){
//        CasoDao dao = new CasoDaoMysql();
//        
//        Caso caso = new Caso();
//        caso.setId(1);
//        caso.setConcepto("Se ha modificado");
//        caso.setFechaFin(date);
//        caso.setFechaInicio(date);
//        caso.setFechaPago(date);
//        caso.setStatus(statusCaso.CERRADO);
//        caso.setTipo(tipoPago.CHEQUE);
//        
//        dao.update(caso);
//    }
//    
//    @Test
//    public void delete(){
//        CasoDao dao = new CasoDaoMysql();
//        
//        Caso caso = new Caso();
//        caso.setId(2);
//        
//        dao.delete(caso);
//    }
}
