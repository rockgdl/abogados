/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.entity;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author gnr_a
 */

@Entity
@Table(name = "Factura")
public class Factura {
    @Transient
    private static final float iva = (float) 1.16;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "concepto", columnDefinition = "text")
    private String concepto;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Caso caso;
    
    @Column (name = "fechaEmision")
    private Date fechaEmision;
    
    @Column (name = "numFactura")
    private int numFactura;
    
    @Column (name = "rep")
    private int rep;
    
    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cliente cliente;
    
    @Column (name = "cantidad")
    private int cantidad;
    
    @Transient
    private double total;
    
    @Transient
    private double ivaIncluido = total*iva;
    
    @Column (name = "fechaPago")
    private Date fechaPago;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column (name = "region")
    private int region;
    
    @Column (name = "serie")
    private String serie;
    

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
     * @return the caso
     */
    public Caso getCaso() {
        return caso;
    }

    /**
     * @param caso the caso to set
     */
    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    /**
     * @return the fechaEmision
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * @param fechaEmision the fechaEmision to set
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * @return the numFactura
     */
    public int getNumFactura() {
        return numFactura;
    }

    /**
     * @param numFactura the numFactura to set
     */
    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    /**
     * @return the rep
     */
    public int getRep() {
        return rep;
    }

    /**
     * @param rep the rep to set
     */
    public void setRep(int rep) {
        this.rep = rep;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the ivaIncluido
     */
    public double getIvaIncluido() {
        return ivaIncluido;
    }

    /**
     * @param ivaIncluido the ivaIncluido to set
     */
    public void setIvaIncluido(double ivaIncluido) {
        this.ivaIncluido = ivaIncluido;
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
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the region
     */
    public int getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(int region) {
        this.region = region;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    
}
