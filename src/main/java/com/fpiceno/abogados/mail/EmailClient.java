package com.fpiceno.abogados.mail;

import java.util.Date;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;



/*
 * FABIAN PICENO ROQUE 
 * 
 * CLASE QUE IMPLEMENTA UN SERVICIO PARA EMAIL CON LA POSIBILIDAD DE ADJUNTAR 
 * UN byte[]
 * 24/07/15
para correr esta clase es necesario click derecho run maven goals y poner esto
exec:java -Dexec.mainClass="com.fpiceno.abogados.mail.EmailClient"  
 */


public class EmailClient

{

 public static void main(String[] args)

 {
        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	 
	 
	 ServidorDeCorreo servicioCorreo=new ServidorDeCorreo(prop);
	 MensajeCorreo mensaje=new MensajeCorreo();
	// mensaje.setMimeType("text/plain");
	 mensaje.setSubject("test correos");
	 mensaje.setMimeType("text/html; charset=utf-8");
	 

	 
	 mensaje.setText("Hola <br>"
                 + "Tienes un nuevo numero de caso para darle seguimiento");
	 Email email=new Email();
	 email.setFrom("fpiceno87@gmail.com");
	 email.setTo("fpiceno@urrea.com.mx");
	 email.setMimeType("text/html; charset=utf-8");
	 email.setText(mensaje.getText());
	 email.setSubject(mensaje.getSubject());

       
//         Session session = Session.getInstance(prop,new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(ConexionMail.getUserMail(), ConexionMail.getPassMail());
//                    }
//                });
	 
//	 Attachment attachment1 = new Attachment("ABCDEFGH".getBytes(), "test1.txt","text/plain");
//	 email.addAttachment(attachment1);
	 
	 servicioCorreo.setMensaje(mensaje);
	 servicioCorreo.setEmail(email);
	 servicioCorreo.enviarCorreo(email);

   

 }

 
}
