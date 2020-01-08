/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Tools.Roles;
import com.fpiceno.abogados.dao.UsuarioDao;
import com.fpiceno.abogados.dao.mysql.UsuarioDaoMysql;
import com.fpiceno.abogados.entity.Usuario;
import java.util.Date;
import javax.management.relation.Role;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fpiceno
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }
    
    @Test
    public void addUsuario()
    {
        Date date = new Date();
        Usuario usuario=new Usuario();
        usuario.setNickName("rockgdl");
        usuario.setPassword("123");
        usuario.setRol(Roles.ADMINISTRADOR);
        usuario.setActivo(true);
        usuario.setFechaCreacion(date);
        
        Usuario usuario2=new Usuario();
        usuario2.setNickName("Adan");
        usuario2.setPassword("123");
        usuario2.setRol(Roles.EGRESOS);
        usuario2.setActivo(false);
        usuario2.setFechaCreacion(date);
        
        UsuarioDao dao=new UsuarioDaoMysql();
        dao.insert(usuario);
//        dao.insert(usuario2);
    }
    
    @Test
    public void update(){
        Date date = new Date();
        
        Usuario usuario2=new Usuario();
        usuario2.setId(2);
        usuario2.setNickName("Adan");
        usuario2.setPassword("12343");
        usuario2.setRol(Roles.INGRESOS);
        usuario2.setActivo(false);
        usuario2.setFechaCreacion(date);
        
        UsuarioDao dao=new UsuarioDaoMysql();
        dao.update(usuario2);
    }
    
}
