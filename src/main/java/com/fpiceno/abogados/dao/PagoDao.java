/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao;

import com.fpiceno.abogados.entity.Pago;
import java.util.List;

/**
 *
 * @author gnr_a
 */
public interface PagoDao {
    public void insert(Pago pago);
    public void delete(Pago pago);
    public void update(Pago pago);
    public List<Pago> read();
    public Pago readPayment(int code);
    public List<Pago> readLike(String cadena);
}
