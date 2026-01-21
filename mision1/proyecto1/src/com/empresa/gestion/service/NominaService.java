package com.empresa.gestion.service;

import com.empresa.gestion.model.Empleado;

public class NominaService {
    public double calcularSalarioAnual(Empleado empleado) {
        return empleado.getSalario() * 12;
    }

}
