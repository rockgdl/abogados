/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author gnr_a
 */
public enum tipoPago {
 
    
    	EFECTIVO("generacion del caso", 1), CHEQUE("aprobacion del caso", 2),TRANSFERENCIA("PAGO RECHAZADO",3),DOMICILIADO("PENDIENTE DE PAGO",4),TDC(" Tarjeta de credito",5),
        TRANSFERENCIA_EFECTIVO("Transferencia y efecito",6);

    private final String key;
    private final Integer value;

    tipoPago(String key,Integer value) {
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
