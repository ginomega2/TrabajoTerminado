package com.example.trabajo.controllers;

import com.example.trabajo.models.Empleado;
import com.example.trabajo.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoControllerRest {

//    @Autowired
//    EmpleadoService empleadoService;
//
//    @GetMapping("/all") //********      http://localhost:8067/api/empleado/all
//    public ResponseEntity<List<Empleado>> getAllEmpleados(){
//        List<Empleado> empleados=empleadoService.findAllEmpleados();
//        return new ResponseEntity<>(empleados, HttpStatus.OK);
//    }
//
//


}
