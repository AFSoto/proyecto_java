package com.empresa.gestion.model;

public class Empleado extends Persona {
    private double salario;
    private int horasTrabajadas;
    

    


    public Empleado(String nombre,int edad,boolean activo,char genero,double salario,int horasTrabajadas,int id){
        super(nombre,edad, activo, genero,id);
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
        return edad >=18 && activo==true;
    }

    public String clasificarEmpleados(){
        if (edad < 18) {
            return "menor de edad (no puede trabajar)";
        }else if(edad <=60){
            return "empleado activo";
        }else{
            return "empleado en edad de retiro";
        }

    }

    public  String obtenerTipoEmpleado(){
        // switch se usa cuando hay opciones definidas
        switch (genero) {
            case 'M':
                return "Masculino";
            case 'F':
                return "Femenino";
            default:
                return "no especificado";
        }
    }

    public String resumen(){
        return "ID: "+id+
                "nombre: "+nombre+
                "edad: "+edad;
    }


}
