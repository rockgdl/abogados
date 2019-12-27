/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao;

import com.fpiceno.abogados.entity.Cliente;
import java.util.List;

/**
 *
 * @author gnr_a
 */
public interface ClienteDao {
    public void insert(Cliente cliente);
    public void delete(Cliente cliente);
    public void update(Cliente cliente);
    public List<Cliente> read();
    public Cliente readCliente(int code);
    public List<Cliente> readLike(String cadena);

    
}
