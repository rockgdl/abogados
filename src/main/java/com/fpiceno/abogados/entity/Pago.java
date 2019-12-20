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
    private int cantidad;
    
}
