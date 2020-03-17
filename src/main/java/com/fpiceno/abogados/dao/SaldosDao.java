/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dao;

import com.fpiceno.abogados.dto.Saldos;
import java.util.List;

/**
 *
 * @author gnr_a
 */
public interface SaldosDao {
    public List<Saldos> read();
}
