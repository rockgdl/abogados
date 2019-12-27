package com.fpiceno.abogados.mail;

import java.util.Date;



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

//  EmailConfiguration configuration = new EmailConfiguration();
//  configuration.setProperty(EmailConfiguration.SMTP_HOST, ConexionMail.getIpMail());
//  configuration.setProperty(EmailConfiguration.SMTP_AUTH, ConexionMail.getSmtpAuthMail());
//  configuration.setProperty(EmailConfiguration.SMTP_TLS_ENABLE, ConexionMail.getSmtpStarttlsMail());
//  configuration.setProperty(EmailConfiguration.SMTP_AUTH_USER, ConexionMail.getUserMail());
//  configuration.setProperty(EmailConfiguration.SMTP_AUTH_PWD, ConexionMail.getPassMail());
//   System.out.println("PROPIEDADES DEL SERVIDOR "+configuration.toString());
//
//  EmailService emailService = new EmailService(configuration);
//  Email email = new Email();
//  email.setFrom("Scheduler@urrea.com.mx");
//  email.setTo("mgutierrez@urrea.com.mx");
////  email.setCc("skitrock@hotmail.com");
//  
//  email.setSubject("TEST PARA URREA  ENVIO DE CORREO");
//  email.setText("Hi, <h1>Test Envio Correo Scheduler me dices si te llega correo no deseado o deseado porfavor xD  </h1>");
//  email.setMimeType("text/html");
//
//  Attachment attachment1 = new Attachment("ABCDEFGH".getBytes(), "test1.txt","text/plain");
//  email.addAttachment(attachment1);
//  Attachment attachment2 = new Attachment("XYZZZZZZ".getBytes(), "test2.txt","text/plain");
//  email.addAttachment(attachment2);
//  emailService.sendEmail(email);
	 
	 
	 ServidorDeCorreo servicioCorreo=new ServidorDeCorreo();
	 MensajeCorreo mensaje=new MensajeCorreo();
	// mensaje.setMimeType("text/plain");
	 mensaje.setSubject("Scheduler correo");
	 mensaje.setMimeType("text/html; charset=utf-8");
	 
//	 mensaje.setText("<div style='width: 600px; height: 400px;"
//	 		+ " background-image: url(\"https://i.ibb.co/8mdZBMm/plantilla-aplausos-HAS.jpg\");background-size: auto;"
//	 		+ "  background-position: center;" + 
//	 		"  background-repeat: no-repeat;" + 
//	 		"  position: relative;'>contenido</div>");
	 
	 mensaje.setText("<table role=\"presentation\" width=\"800\" style=\"width:640px;\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">" + 
	 		"<tr>" + 
	 		"<td align=\"center\" bgcolor=\"#000000\" background=\"https://i.ibb.co/6NBFdFW/aplausos.jpg\" width=\"640\" height=\"400\" valign=\"top\" style=\"background: url('https://i.ibb.co/6NBFdFW/aplausos.jpg') center / cover no-repeat #000000;\">" + 
	 		"<!--[if gte mso 9]>" + 
	 		"<v:image xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"true\" stroke=\"false\" style=\" border: 0;display: inline-block; width: 480pt; height: 300pt;\" src=\"https://i.ibb.co/6NBFdFW/aplausos.jpg\" /><v:rect xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"true\" stroke=\"false\" style=\" border: 0;display: inline-block;position: absolute; width: 480pt; height:300pt;\">" + 
	 		"<v:fill  opacity=\"0%\" color=\"#000000”  />" + 
	 		"<v:textbox inset=\"0,0,0,0\">" + 
	 		"<![endif]-->" + 
	 		"<div>" + 
	 		"<div style=\"font-size: 0;\">" + 
	 		"<table role=\"presentation\" width=\"800\" style=\"width:640px;\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\r\n" + 
	 		"<tr>\r\n" + 
	 		"<td height=\"600\" align=\"center\">CONTENT</td>\r\n" + 
	 		"</tr>\r\n" + 
	 		"</table>\r\n" + 
	 		"</div>\r\n" + 
	 		"</div>\r\n" + 
	 		"<!--[if gte mso 9]>\r\n" + 
	 		"</v:textbox>\r\n" + 
	 		"</v:fill>\r\n" + 
	 		"</v:rect>\r\n" + 
	 		"</v:image>\r\n" + 
	 		"<![endif]-->\r\n" + 
	 		"</td>\r\n" + 
	 		"</tr>\r\n" + 
	 		"</table>");
	 Email email=new Email();
	 email.setFrom("fpiceno@urrea.com.mx");
	 email.setTo("fpiceno@urrea.com.mx");
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
