package com.example.trabajo.services.impl;

import com.example.trabajo.models.Empleado;

import com.example.trabajo.repos.EmpleadoRepository;
import com.example.trabajo.services.CalculadoraImpuestoImpl;
import com.example.trabajo.services.EmpleadoService;
import com.example.trabajo.services.PuedeCalcularImpuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    EmpleadoRepository repository;

    PuedeCalcularImpuesto calcularImpuesto;

    @Override
    public List<Empleado> findAllEmpleados() {
        return repository.findAll();
    }

    @Override
    public Empleado createEmpleado(Empleado empleado) {
        empleado.setSueldoBruto(empleado.getSueldoXdia()*empleado.getDiaTrabajados());
        calcularImpuesto = new CalculadoraImpuestoImpl(empleado.getSueldoBruto());
        empleado.setSueldoNeto(empleado.getSueldoBruto()-calcularImpuesto.calcularImpuesto());
        return repository.save(empleado);
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        empleado.setSueldoBruto(empleado.getSueldoXdia()*empleado.getDiaTrabajados());
        calcularImpuesto = new CalculadoraImpuestoImpl(empleado.getSueldoBruto());
        empleado.setSueldoNeto(empleado.getSueldoBruto()-calcularImpuesto.calcularImpuesto());
        repository.save(empleado);
    }

    @Override
    public void deleteEmpleado(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Empleado findEmpleadoById(Long id) {
        return repository.findById(id).get();
    }
}
