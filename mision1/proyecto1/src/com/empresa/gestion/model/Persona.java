package com.empresa.gestion.model;

public class Persona {
    // encapsulacion
    private String nombre;
    private int edad;

    //constructor
    public Persona(String nombre , int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
