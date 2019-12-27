/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao;

import com.fpiceno.abogados.entity.Factura;
import java.util.List;

/**
 *
 * @author gnr_a
 */
public interface FacturaDao {
    public void insert(Factura factura);
    public void delete(Factura factura);
    public void update(Factura factura);
    public List<Factura> read();
    public Factura readFactura(int code);
    public List<Factura> readLike(String cadena);
    
}
