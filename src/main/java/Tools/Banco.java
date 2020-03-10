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
public enum Banco {
    SANTANDER("Santander", 1), BANCOMER ("Bancomer",2), BANAMEX("Banamex",3), HSBC("HSBC",3), SCOTIABANK("Scotiabank",4); 
    
        private final String key;
    private final Integer value;

    Banco(String key,Integer value) {
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
