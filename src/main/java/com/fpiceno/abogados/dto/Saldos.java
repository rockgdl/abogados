/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.dto;

import Tools.Banco;
import Tools.RazonSocial;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

/**
 *
 * @author gnr_a
 */
@Entity
@Immutable
@Subselect("SELECT p.id, p.banco, c.razonSocial, SUM(p.cantidad) AS suma FROM pago p INNER JOIN caso c ON p.id_caso = c.id WHERE p.status = 'PAGADO' AND YEAR(p.fechaPago) = YEAR(NOW()) GROUP BY p.banco, c.razonSocial")
@Synchronize({ "pago", "caso" })
public class Saldos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(insertable = false, updatable = false)
    private String banco;
    
    @Column(insertable = false, updatable = false)
    private String razonSocial;
    
    @Column(insertable = false, updatable = false)
    private Double suma;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the razon
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @param razon the razon to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * @return the suma
     */
    public Double getSuma() {
        return suma;
    }

    /**
     * @param suma the suma to set
     */
    public void setSuma(Double suma) {
        this.suma = suma;
    }
}
