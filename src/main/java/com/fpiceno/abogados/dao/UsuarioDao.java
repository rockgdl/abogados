/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao;

import com.fpiceno.abogados.entity.Usuario;
import java.util.List;

/**
 *
 * @author fpiceno
 */
public interface UsuarioDao {
    
    public Integer agregarUsuario(Usuario usuario);
    
    public void insert(Usuario usuario);
    public void delete(Usuario usuario);
    public void update(Usuario usuario);
    public List<Usuario> read();
    public Usuario readUser(int code);
    
}
