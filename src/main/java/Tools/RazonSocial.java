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
public enum RazonSocial {
    
        FML ("FML",1), FMLSE ("FMLSE",2), MLCONSULTORES("MS Consultores",3), MDPABOGADOS("MDP Abogados",4),FMLMARTINEZ("FML Martinez",5);
    
    private final String key;
    private final Integer value;

    RazonSocial(String key,Integer value) {
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
