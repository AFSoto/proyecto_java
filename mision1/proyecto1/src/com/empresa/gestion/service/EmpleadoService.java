package com.empresa.gestion.service;
import com.empresa.gestion.model.Empleado;
import java.util.ArrayList;
public class EmpleadoService {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    //agregar
    public void agregarEmpleado(Empleado emp){
        empleados.add(emp);
        System.out.println("empleado agregado correctamente");
    }

    //listar
    public void listarEmpleados(){
        if (empleados.isEmpty()) {
            System.out.println("⚠️ no hay empleados");
            return;
        }
        for(Empleado e : empleados){
            System.out.println(e.resumen());
        }
    }

    //eliminar
    public void eliminarEmpleado(int id){
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId() == id) {
                empleados.remove(i);
                System.out.println("empleado: "+empleados.get(i).getNombre()+" elimando correctamente");
                break;
            }
        }
        System.out.println("empleado no encontrado");
    }
}
