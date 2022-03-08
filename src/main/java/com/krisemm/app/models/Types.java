/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.models;

/**
 *
 * @author kristian
 */
public enum Types {
    
    Action("Action"),
    Aventura("Aventura"), 
    Clasicas("Clasicas"),                  
    Comedia_Romantica("Comedia Romantica"),                  
    Drama("Drama"),                  
    Terror("Terror"),                  
    Infantil("Infantil"),                 
    Accion_y_Aventura("Accion y Aventura"),
    Romantica("Romantica"),
    Erotica("Erotica");
                
    String value;
    
    Types(String value){
        this.value = value;
    }
    
    String getValue(){
        return value;
    }
}
