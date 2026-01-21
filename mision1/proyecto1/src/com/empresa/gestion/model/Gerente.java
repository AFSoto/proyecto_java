package com.empresa.gestion.model;

public class Gerente extends Empleado {
    private String departamento;

    public Gerente(String nombre,int edad,double salario,String departamento){
        super(nombre,edad,salario);
        this.departamento = departamento;
    }

    public String getDepartamento(){
        return this.departamento;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    //esto sive para que se pueda sobreescribir el metodo presentarse
    @Override
    public void presentarse(){
        System.out.println("hola gerente"+getNombre());
    }

}
