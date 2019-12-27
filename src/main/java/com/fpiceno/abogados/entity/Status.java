package com.fpiceno.abogados.entity;

public enum Status {
	
	GENERADO("generacion del caso", 1), APROBADO("aprobacion del caso", 2),RECHAZADO("PAGO RECHAZADO",3),PENDIENTE("PENDIENTE DE PAGO",4);

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

}
