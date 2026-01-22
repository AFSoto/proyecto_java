package com.empresa.gestion.model;

public class Persona {
    // encapsulacion
    private String nombre;
    private int edad;
    private boolean activo;// tru - false
    private char genero; // 'M' - 'F'

    //constructor
    public Persona(String nombre , int edad,boolean activo,char genero){
        this.nombre = nombre;
        this.edad = edad;
        this.activo = activo;
        this.genero = genero;
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

    public char getGenero() {
        return genero;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }

    

    public void presentarse(){
        System.out.println("hola soy"+nombre+"y tengo "+edad+" años");
    }

    public void mostrarInfoBasica(){
        System.out.println("nombre: "+nombre);
        System.out.println("edad: "+edad);
        System.out.println("activo: "+activo);
    }
}
