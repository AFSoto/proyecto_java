package com.empresa.gestion.model;

public class Empleado extends Persona {
    private double salario;
    private int horasTrabajadas;

    public Empleado(String nombre,int edad,boolean activo,char genero,double salario,int horasTrabajadas){
        super(nombre,edad, activo, genero);
        this.salario = salario;
        this.horasTrabajadas = horasTrabajadas;
    }

    
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
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


    public double calcularSalarioMensual(){
        double valorHora =salario/160;
        double salarioFinal= valorHora * horasTrabajadas;
        return salarioFinal;
    }
    // Agregamos reglas de negocio
    public boolean esMayorDeEdad(){
        return getEdad()>=18;
    }
    public boolean puedeTrabajar(){
        return getEdad() >=18 && activo==true;
    }


}
