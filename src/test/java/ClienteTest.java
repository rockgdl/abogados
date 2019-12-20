/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fpiceno.abogados.dao.ClienteDao;
import com.fpiceno.abogados.dao.mysql.ClienteDaoMysql;
import com.fpiceno.abogados.entity.Cliente;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gnr_a
 */
public class ClienteTest {
    
    public ClienteTest() {
    }
    
//    @Test
//    public void add(){
//        ClienteDao dao = new ClienteDaoMysql();
//        
//        Cliente cliente = new Cliente();
//        cliente.setNombre("Adan");
//        cliente.setCorreo("asdj@asd");
//        cliente.setDomicilio("algun lugar");
//        cliente.setRfc("PIRA2378hadhjd23");
//        cliente.setTelefono("24234342");
//        
//        dao.insert(cliente);
//    }
//    
//    @Test
//    public void read(){
//        ClienteDao dao = new ClienteDaoMysql();
//        
//        Iterator<Cliente> i = dao.read().iterator();
//        
//        while(i.hasNext()){
//            System.out.println(i.next().getNombre());
//        }
//    }
//    
//    @Test
//    public void update(){
//        ClienteDao dao = new ClienteDaoMysql();
//        
//        Cliente cliente = new Cliente();
//        cliente.setId(1);
//        cliente.setNombre("Escarlet");
//        cliente.setCorreo("asdj@asd");
//        cliente.setDomicilio("algun lugar");
//        cliente.setRfc("FCE980307asdaeew3t");
//        cliente.setTelefono("24234342");
//        
//        dao.update(cliente);
//    }
//    
//    @Test
//    public void delete(){
//        ClienteDao dao = new ClienteDaoMysql();
//        
//        Cliente cliente = new Cliente();
//        cliente.setId(2);
//        
//        dao.delete(cliente);
//    }
    
}
