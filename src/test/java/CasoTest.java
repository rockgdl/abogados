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
import java.util.Date;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gnr_a
 */
public class CasoTest {
    
    private Date date = new Date();
    public CasoTest() {
    }

    
    @Test
    public void add(){
        CasoDao dao = new CasoDaoMysql();
        
        Caso caso = new Caso();
        
        caso.setConcepto("Caso 1");
        caso.setFechaFin(date);
        caso.setFechaInicio(date);
        caso.setFechaPago(date);
        caso.setStatus(statusCaso.pagado);
        caso.setTipo(tipoPago.Pesos);
        dao.insert(caso);
        
          caso.setConcepto("Caso 2");
        caso.setFechaFin(date);
        caso.setFechaInicio(date);
        caso.setFechaPago(date);
        caso.setStatus(statusCaso.abonado);
        caso.setTipo(tipoPago.Dolar);
        dao.insert(caso);
        
         caso.setConcepto("Caso 3");
        caso.setFechaFin(date);
        caso.setFechaInicio(date);
        caso.setFechaPago(date);
        caso.setStatus(statusCaso.pagado);
        caso.setTipo(tipoPago.Pesos);
        dao.insert(caso);
    }
    
    @Test
    public void read(){
        CasoDao dao = new CasoDaoMysql();
        
        Iterator<Caso> i = dao.read().iterator();
        
        while(i.hasNext()){
            System.out.println(i.next().getStatus());
        }
    }
    
    @Test
    public void update(){
        CasoDao dao = new CasoDaoMysql();
        
        Caso caso = new Caso();
        caso.setId(1);
        caso.setConcepto("Se ha modificado");
        caso.setFechaFin(date);
        caso.setFechaInicio(date);
        caso.setFechaPago(date);
        caso.setStatus(statusCaso.concebido);
        caso.setTipo(tipoPago.Dolar);
        
        dao.update(caso);
    }
    
    @Test
    public void delete(){
        CasoDao dao = new CasoDaoMysql();
        
        Caso caso = new Caso();
        caso.setId(2);
        
        dao.delete(caso);
    }
}
