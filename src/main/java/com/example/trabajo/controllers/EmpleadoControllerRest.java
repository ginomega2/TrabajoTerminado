package com.example.trabajo.controllers;

import com.example.trabajo.models.Empleado;
import com.example.trabajo.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoControllerRest {

    @Autowired
    EmpleadoService empleadoService;
//
    @GetMapping("/all") //********      http://localhost:8067/api/empleado/all
    public ResponseEntity<List<Empleado>> getAllEmpleados(){
        List<Empleado> empleados=empleadoService.findAllEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @PostMapping("/add")            //********      http://localhost:8067/api/empleado/add
    public ResponseEntity<Empleado> addNewEmpleado(@RequestBody Empleado empleado){
        Empleado empleadoInsertado = empleadoService.createEmpleado(empleado);
        if(empleadoInsertado==null){
            //PROBLEMAS EN LA BD
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(empleadoInsertado,HttpStatus.OK);
    }

    @PostMapping("/update")      //********      http://localhost:8067/api/empleado/update
    public ResponseEntity updateEmpleado(@RequestBody Empleado empleado){
        empleadoService.updateEmpleado(empleado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")        //********      http://localhost:8067/api/empleado/delete/{id}
    public ResponseEntity deleteEmpleado(@PathVariable Long id){
        empleadoService.deleteEmpleado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/prueba")       //********      http://localhost:8067/api/empleado/prueba
    public String prueba(){
        return "prueba";
    }

    @GetMapping("/{id}")     //********      http://localhost:8067/api/empleado/4
    public Empleado getLocation(@PathVariable("id") Long id) {
        return empleadoService.findEmpleadoById(id);

    }



}
