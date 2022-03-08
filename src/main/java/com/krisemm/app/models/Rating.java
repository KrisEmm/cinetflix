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
public enum Rating {
    
    RATING_UNO("Muy Mala", "1"),
    RATING_DOS("Mala", "2"),
    RATING_TRES("Regular", "3"),
    RATING_CUATRO("Buena", "4"),
    RATING_CINCO("Muy Buena", "5"),
    RATING_SEIS("Magnifica", "6");
    
    String description;
    String value;

    private Rating(String description, String value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }
    
    
    
}
