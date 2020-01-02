/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.entity;

import Tools.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author gnr_a
 */
@Entity
@Table(name="Caso")
public class Caso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name="fechaPago")
    private Date fechaPago;
    
    @Column(name="concepto", columnDefinition = "text")
    private String concepto;
    
   @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column(name="fechaInicio")
    private Date fechaInicio;
    
    @Column(name="fechaFin")
    private Date fechaFin;
    
    @Column(name="tipoPago")
    private tipoPago tipo;
    
    @Column(name = "serie", columnDefinition = "varchar(20)")
    private String serie;
    
    @ManyToOne (optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cliente cliente;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_caso")
    private List<Pago> ListaPagos = new ArrayList<Pago>();
    
    @Enumerated(EnumType.STRING)
    private RazonSocial razonSocial;

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
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the tipo
     */
    public tipoPago getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(tipoPago tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the ListaPagos
     */
    public List<Pago> getListaPagos() {
        return ListaPagos;
    }

    /**
     * @param ListaPagos the ListaPagos to set
     */
    public void setListaPagos(List<Pago> ListaPagos) {
        this.ListaPagos = ListaPagos;
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
     * @return the razonSocial
     */
    public RazonSocial getRazonSocial() {
        return razonSocial;
    }

    /**
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(RazonSocial razonSocial) {
        this.razonSocial = razonSocial;
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
