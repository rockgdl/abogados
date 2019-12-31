package com.fpiceno.abogados.entity;

public enum Status {
	
	GENERADO("generacion del caso", 1), APROBADO("aprobacion del caso", 2),RECHAZADO("PAGO RECHAZADO",3),PENDIENTE("PENDIENTE DE PAGO",4),FINALIZADO("CASO FINALIZADO",5),
        //facturacion
        PAGADA("Pagada en facturacion",6),CANCELADA("FACTURA CANCELADA",7),NOPAGADA("FACTURA NO PAGADA",8);
        

    private final String key;
    private final Integer value;

    Status(String key,Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }
    
    @Override
    public String toString(){
        return this.key;
    }

}
