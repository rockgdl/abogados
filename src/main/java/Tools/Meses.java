/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author fpiceno
 */
public enum Meses {
    
    
            ENERO ("ENERO",1), FEBRERO ("FEBRERO",2), MARZO("MARZO",3), ABRIL("ABRIL",4),MAYO("MAYO",5),
            JUNIO("JUNIO",6),JULIO("JULIO",7),AGOSTO("AGOSTO",8),SEPTIEMBRE("SEPTIEMBRE",9),OCTUBRE("OCTUBRE",10),
            NOVIEMBRE("NOVIEMBRE",11),DICIEMBRE("DICIEMBRE",12);
    
    private final String key;
    private final Integer value;

    Meses(String key,Integer value) {
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
