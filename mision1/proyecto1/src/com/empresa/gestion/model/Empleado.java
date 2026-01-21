package com.empresa.gestion.model;

public class Empleado extends Persona {
    private double salario;

    public Empleado(String nombre,int edad,double salario){
        super(nombre,edad);
        this.salario = salario;
    }

    public double getSalario(){
        return salario;
    }
    
    public void setSalario(double salario){
        this.salario = salario;
    }

    @Override
    public  void presentarse(){
        System.out.println("hola soy el empleado"+ getNombre()+ " y tengo "+getEdad()+" años");
    }

}
