/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpiceno.abogados.servicios.impl;

import com.fpiceno.abogados.entity.Usuario;
import com.fpiceno.abogados.mail.Email;
import com.fpiceno.abogados.mail.MensajeCorreo;
import com.fpiceno.abogados.mail.ServidorDeCorreo;
import com.fpiceno.abogados.servicios.LoginServicesInterface;
import java.util.Properties;

/**
 *
 * @author fpiceno
 */
public class LoginServices implements LoginServicesInterface{

    @Override
    public void sendEmail(Usuario usuario) {
        
        
        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	 
	 
	 ServidorDeCorreo servicioCorreo=new ServidorDeCorreo(prop);
	 MensajeCorreo mensaje=new MensajeCorreo();
	// mensaje.setMimeType("text/plain");
	 mensaje.setSubject("Recuperacion de contraseña ");
	 mensaje.setMimeType("text/html; charset=utf-8");
	 
	 mensaje.setText("HOLA : "+usuario.getNickName()+" este correo es para la recuperacion de tu password que es: "+usuario.getPassword()+" saludos");
	 Email email=new Email();
	 email.setFrom("fpiceno87@gmail.com");
	 email.setTo(usuario.getCorreo());
	 email.setMimeType("text/html; charset=utf-8");
	 email.setText(mensaje.getText());
	 email.setSubject(mensaje.getSubject());
	 
//	 Attachment attachment1 = new Attachment("ABCDEFGH".getBytes(), "test1.txt","text/plain");
//	 email.addAttachment(attachment1);
	 
	 servicioCorreo.setMensaje(mensaje);
	 servicioCorreo.setEmail(email);
	 servicioCorreo.enviarCorreo(email);
    }
    
}
