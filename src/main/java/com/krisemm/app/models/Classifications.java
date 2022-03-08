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
public enum Classifications {
    
    AA("Películas para todo público que tengan además atractivo infantil y sean comprensibles para niños menores de siete años de edad."),
    A("Películas para todo público."),
    B("Películas para adolescentes de 12 años en adelante."),
    B15("Película no recomendable para menores de 15 años de edad."),
    C("Películas para adultos de 18 años en adelante."),
    D("Películas para adultos, con sexo explícito, lenguaje procaz o alto grado de violencia.");
    
    String description;
    
    Classifications(String description){
        this.description = description;
    }
    
    String getDescription(){
        return this.description;
    }
}
