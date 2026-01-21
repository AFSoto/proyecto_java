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

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void presentarse(){
        System.out.println("hola soy"+nombre+"y tengo "+edad+" años");
    }
}
