/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiceno.abogados.dao;

import com.opiceno.abogados.Entity.Usuario;
import java.util.List;

/**
 *
 * @author gnr_a
 */

public interface usuarioDao {
    public void insert(Usuario usuario);
    public void delete(Usuario usuario);
    public void update(Usuario usuario);
    public List<Usuario> read();
    public Usuario readUser(int code);
    
}
