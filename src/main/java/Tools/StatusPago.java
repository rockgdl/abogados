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
public enum StatusPago {
    
    PAGADO("Pagado",1), ABONADO("Abonado", 2), CANCELADO("Cancelado",3);
    
    private final String key;
    private final Integer value;

    StatusPago(String key,Integer value) {
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
