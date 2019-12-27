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
public class ServidorDeCorreo {
   
   EmailConfiguration configuration;
   EmailService emailService;
   Email email;
   MensajeCorreo mensaje;
   
   public ServidorDeCorreo(){
      configuration = new EmailConfiguration();
      cargarConfiguracionMail();
      emailService = new EmailService(configuration);
      email = new Email();
      mensaje = new MensajeCorreo();
   }

    public MensajeCorreo getMensaje() {
        return mensaje;
    }

    public void setMensaje(MensajeCorreo mensaje) {
        this.mensaje = mensaje;
    }
   
   
   private void cargarConfiguracionMail(){
     
    
     
     configuration.setProperty(EmailConfiguration.SMTP_HOST, ConexionMail.getIpMail());

     configuration.setProperty(EmailConfiguration.SMTP_AUTH, ConexionMail.getSmtpAuthMail());

     configuration.setProperty(EmailConfiguration.SMTP_TLS_ENABLE, ConexionMail.getSmtpStarttlsMail());

     configuration.setProperty(EmailConfiguration.SMTP_AUTH_USER, ConexionMail.getUserMail());

     configuration.setProperty(EmailConfiguration.SMTP_AUTH_PWD, ConexionMail.getPassMail());
     
   }
   
   public void enviarCorreo(String remitente, String destinatario){
   
      
       email.setFrom(remitente); // "TBS@tracsa.com.mx"
       email.setTo(destinatario); //"fpiceno@tracsa.com.mx"
       agregarMensajeCorreo();
  
       /*Attachment attachment1 = new Attachment("ABCDEFGH".getBytes(), "test1.txt","text/plain");
       email.addAttachment(attachment1);
       Attachment attachment2 = new Attachment("XYZZZZZZ".getBytes(), "test2.txt","text/plain");
       email.addAttachment(attachment2);*/
       
       generarEnvio();
  
   }
   
   public void enviarCorreo(Email email)
   {
	   generarEnvio();
   }
   
   private void agregarMensajeCorreo() {
     
      //System.out.println("valor del mensaje titulo ");
      email.setSubject(mensaje.getSubject());
      email.setText(mensaje.getText());
      email.setMimeType(mensaje.getMimeType()); 
      
   }
   
   private void  generarEnvio(){
     emailService.sendEmail(email);
   }

public EmailConfiguration getConfiguration() {
	return configuration;
}

public void setConfiguration(EmailConfiguration configuration) {
	this.configuration = configuration;
}

public EmailService getEmailService() {
	return emailService;
}

public void setEmailService(EmailService emailService) {
	this.emailService = emailService;
}

public Email getEmail() {
	return email;
}

public void setEmail(Email email) {
	this.email = email;
}

    
}
