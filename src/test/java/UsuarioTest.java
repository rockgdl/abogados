/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fpiceno.abogados.dao.UsuarioDao;
import com.fpiceno.abogados.dao.mysql.UsuarioDaoMysql;
import com.fpiceno.abogados.entity.Usuario;
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
         Usuario usuario=new Usuario();
        usuario.setNombre("fabian");
        UsuarioDao dao=new UsuarioDaoMysql();
        dao.agregarUsuario(usuario);
    }
    
}
