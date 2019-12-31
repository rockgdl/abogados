package com.fpiceno.abogados.mail;

/*
 * FABIAN PICENO ROQUE 
 * 
 * CLASE QUE IMPLEMENTA UN SERVICIO PARA EMAIL CON LA POSIBILIDAD DE ADJUNTAR 
 * UN byte[]
 * 24/07/15
 */

import java.util.Properties;

public class EmailConfiguration {
    private Properties properties = new Properties();
    public static final String SMTP_HOST = "mail.smtp.host";
    public static final String SMTP_AUTH = "mail.smtp.auth";
    public static final String SMTP_TLS_ENABLE = "mail.smtp.starttls.enable";
//    public static final String SMTP_AUTH_USER = "smtp.auth.user";
//    public static final String SMTP_AUTH_PWD = "smtp.auth.pwd";
        public static final String SMTP_AUTH_USER = "fpiceno87@gmail.com";
        public static final String SMTP_AUTH_PWD = "rock2663";
    public static final String DEBUG = "true";

     EmailConfiguration() {
     
    }

    EmailConfiguration(Properties prop) {
        properties=prop;
    }

    public Properties getProperties() {
        return this.properties;
    }

    public void setProperty(String key, String value) {
        this.properties.put(key, value);
    }

    public void addProperties(Properties props) {
        this.properties.putAll(props);
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    @Override
    public String toString() {
        return "EmailConfiguration [properties=" + properties + "]";
    }

}
