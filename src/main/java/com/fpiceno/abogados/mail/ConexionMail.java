package com.fpiceno.abogados.mail;

public class ConexionMail {
    
    //Properties
    private static final String IP_MAIL = "mailvalur01"; // Utilizar para Lotus "10.108.32.122"  para  mailvalur//192.168.100.151
    private static final String PUERTO_MAIL = "25";
    private static final String PROTOCOL_MAIL = "smtp";
    private static final String SMTP_STARTTLS_MAIL = "false";
    private static final String SMTP_AUTH_MAIL = "false";
    
    //Authenticator
    private static final String PASS_MAIL = "fpiceno";
    private static final String USER_MAIL = "fa7730pr";
	
    
    
    
    
    public static String getIpMail() {
		return IP_MAIL;
	}
	public static String getPuertoMail() {
		return PUERTO_MAIL;
	}
	public static String getProtocolMail() {
		return PROTOCOL_MAIL;
	}
	public static String getSmtpStarttlsMail() {
		return SMTP_STARTTLS_MAIL;
	}
	public static String getSmtpAuthMail() {
		return SMTP_AUTH_MAIL;
	}
	public static String getPassMail() {
		return PASS_MAIL;
	}
	public static String getUserMail() {
		return USER_MAIL;
	}
    
    
    
    
    
}
