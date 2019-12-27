package com.fpiceno.abogados.mail;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * Fabian Piceno Roque
 * 
 * Clase para validar Email Validos
 */
public class ValidaCorreo {
	
	
	
	   private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 
	    /**
	     * Validar un Email con una  regular expression.
	     * 
	     * @param email
	     *            email for validation
	     * @return verdadero  email valido, en otro caso false
	     */
	    public static boolean validateEmail(String email) {
	        // Compiles the given regular expression into a pattern.
	        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
	 
	        // Match the given input against this pattern
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	 
	    }

}
