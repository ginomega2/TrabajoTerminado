package com.example.trabajo.repos;

import com.example.trabajo.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
}
