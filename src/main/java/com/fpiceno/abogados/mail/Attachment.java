package com.fpiceno.abogados.mail;


/*
 * FABIAN PICENO ROQUE 
 * 
 * CLASE QUE IMPLEMENTA UN SERVICIO PARA EMAIL CON LA POSIBILIDAD DE ADJUNTAR 
 * UN byte[]
 * 05/03/14
 */

public class Attachment

{

 private byte[] data;

 private String filename;

 private String mimeType;

  

 public Attachment()

 {

 }

  

 public Attachment(byte[] data, String filename, String mimeType)

 {

  super();

  this.data = data;

  this.filename = filename;

  this.mimeType = mimeType;

 }

 

 public byte[] getData()

 {

  return data;

 }

 public void setData(byte[] data)

 {

  this.data = data;

 }

 public String getFilename()

 {

  return filename;

 }

 public void setFilename(String filename)

 {

  this.filename = filename;

 }

 

 public String getMimeType()

 {

  return mimeType;

 }

 

 public void setMimeType(String mimeType)

 {

  this.mimeType = mimeType;

 }

  

}

