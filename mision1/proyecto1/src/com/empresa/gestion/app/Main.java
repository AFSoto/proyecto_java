package com.empresa.gestion.app;

import com.empresa.gestion.model.*;
import com.empresa.gestion.service.NominaService;

public class Main {
    public static void main(String[] args){
        Empleado empleado1 = new Empleado("Juan", 30,true,'M',5000,3);
        Gerente gerente1 = new Gerente("Ana", 61,true,'F', 8000,160, "Ventas",2000);
        empleado1.presentarse();
        gerente1.presentarse();
        NominaService nomina = new NominaService();


        System.out.println("=======EMPLEADO========");
        empleado1.mostrarInfoBasica();
        System.out.println("puede trabajar?"+empleado1.puedeTrabajar());
        System.out.println("salario mensual:"+empleado1.calcularSalarioMensual());
        System.out.println("Salario anual: $" + nomina.calcularSalarioAnual(empleado1));
        System.out.println("tipo empleado: "+empleado1.obtenerTipoEmpleado());

        System.out.println("=======GERENTE========");
        gerente1.mostrarInfoBasica();
        System.out.println("puede trabajar?"+gerente1.puedeTrabajar());
        System.out.println("salario mensual:"+gerente1.calcularSalarioMensual());
        System.out.println("Salario anual : $" + nomina.calcularSalarioAnual(gerente1));
        System.out.println("tipo empleado: "+ gerente1.obtenerTipoEmpleado());
        


        // Persona persona1 = new Persona('andres',23, true, 'M');
        // persona1.presentarse();
    }
}
