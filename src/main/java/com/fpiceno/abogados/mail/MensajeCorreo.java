/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpiceno.abogados.mail;

/**
 *
 * @author melizalde
 */
public class MensajeCorreo {
    
    private String subject;
    private String text;
    private String mimeType;

    public MensajeCorreo() {
        subject = "No definido";
        text= "Este correo fue enviado sin especificar ningun contenido";
        mimeType = "text/html;charset=UTF-8";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
    
    
    
    
}
