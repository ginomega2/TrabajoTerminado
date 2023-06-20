package com.example.trabajo.services;

import com.example.trabajo.models.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Servic

public interface EmpleadoService {
    List<Empleado> findAllEmpleados();
    Empleado createEmpleado(Empleado empleado);
    void updateEmpleado(Empleado empleado);
    void deleteEmpleado(Long id);
Empleado findEmpleadoById(Long id);
//    Optional<Empleado> findEmpleadoById(Long id);
}
