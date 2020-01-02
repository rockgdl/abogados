/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao;

import com.fpiceno.abogados.entity.Caso;
import java.util.List;

/**
 *
 * @author gnr_a
 */
public interface CasoDao {
    public void insert(Caso caso);
    public void delete(Caso caso);
    public void update(Caso caso);
    public List<Caso> read();
    public Caso readCaso(int code);
    public List<Caso> readRazonSocial(String cadena);
    public List<Caso> readStatus(String cadena);

}
