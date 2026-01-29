package com.empresa.gestion.app;
import com.empresa.gestion.model.Empleado;
import com.empresa.gestion.service.EmpleadoService;
import java.util.Scanner;
public class Main2 {
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        EmpleadoService service = new EmpleadoService();
        int opcion;

        do {
        System.out.println("\n === MENU DE EMPLEADOS ===");
        System.out.println("1. agregar empleado");
        System.out.println("2. listar empleado");
        System.out.println("3. consultar empleado");
        System.out.println("4. eliminar empleado");
        System.out.println("0. salir");
        System.out.println("seleccione una opcion");
        opcion = sc.nextInt();

    //     public Empleado(String nombre,int edad,boolean activo,char genero,double salario,int horasTrabajadas,int id){
    //     super(nombre,edad, activo, genero,id);
    //     this.salario = salario;
    //     this.horasTrabajadas = horasTrabajadas;
        
    // }

        switch (opcion) {
            case 1:
                System.out.println("Id: ");
                int id = sc.nextInt();

                System.out.println("Nombre: ");
                sc.nextLine(); // limipiar
                String nombre = sc.nextLine();

                System.out.println("Edad: ");
                int edad = sc.nextInt();

                System.out.println("Activo: ");
                boolean activo = sc.nextBoolean();

                System.out.println("Genero: ");
                char genero = sc.next().charAt(0);

                System.out.println("Salario: ");
                double salario = sc.nextDouble();

                System.out.println("Horas trabajadas: ");
                int horasTrabajadas = sc.nextInt();

                Empleado empleado = new Empleado(nombre, edad, activo, genero, salario, horasTrabajadas, id);
                service.agregarEmpleado(empleado);
                break;
            case 2:
                service.listarEmpleados();
                break;
            case 3:
                System.out.println("ingresa tu id: ");
                service.consultarEmpleado(sc.nextInt());
                break;
            case 4:
                System.out.println("ingresa id a eliminar: ");
                service.consultarEmpleado(sc.nextInt());
                break;
            case 0:
                System.out.println("saliendo del sistema.......");
                break;
            default:
                System.out.println("opcion invalida 😒");
        }
        
        } while (opcion != 0);
    }
}
