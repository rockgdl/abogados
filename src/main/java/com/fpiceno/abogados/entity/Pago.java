/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.entity;

import Tools.Banco;
import Tools.StatusPago;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author gnr_a
 */

@Entity
@Table(name="Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="idFactura")
    private int idFacutura;
    
    @Column(name = "concepto", columnDefinition = "text")
    private String concepto;
    
    @Column(name = "fechaPago")
    private Date fechaPago;
    
    @Column (name = "cantidad")
    private double cantidad;
    
    @Enumerated(EnumType.STRING)
    private Banco banco;
    
    @Enumerated(EnumType.STRING)
    private StatusPago status;
    
//    @ManyToOne
//    @JoinColumn(name = "caso_id")
//    private Caso caso;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idFacutura
     */
    public int getIdFacutura() {
        return idFacutura;
    }

    /**
     * @param idFacutura the idFacutura to set
     */
    public void setIdFacutura(int idFacutura) {
        this.idFacutura = idFacutura;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the fechaPago
     */
    public Date getFechaPago() {
        return fechaPago;
    }

    /**
     * @param fechaPago the fechaPago to set
     */
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

//    /**
//     * @return the caso
//     */
//    public Caso getCaso() {
//        return caso;
//    }
//
//    /**
//     * @param caso the caso to set
//     */
//    public void setCaso(Caso caso) {
//        this.caso = caso;
//    }

    @Override
    public String toString() {
        return "Pago{" + "id=" + id + ", idFacutura=" + idFacutura + ", concepto=" + concepto + ", fechaPago=" + fechaPago + ", cantidad=" + cantidad + '}';
    }

    /**
     * @return the banco
     */
    public Banco getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    /**
     * @return the status
     */
    public StatusPago getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(StatusPago status) {
        this.status = status;
    }
    
    
}
