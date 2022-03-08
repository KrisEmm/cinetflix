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
public enum Notifications {
    
    Estrenos("Estrenos"),
    Promociones("Promociones"),
    Noticias("Noticias"),
    Preventas("Preventas");
    
    String value;
    
    Notifications(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    
}
