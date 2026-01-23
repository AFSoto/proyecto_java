package com.empresa.gestion.model;

public class Gerente extends Empleado {
    private String departamento;
    private double bono;

    

    public Gerente(String nombre,int edad,boolean activo,char genero,double salario,int horasTrabajadas,String departamento,double bono){
        super(nombre,edad, activo, genero,salario,horasTrabajadas);
        this.departamento = departamento;
        this.bono = bono;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
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

    @Override
    public double calcularSalarioMensual(){
        double salario = super.calcularSalarioMensual();
        return salario+bono;
    }

}
