package com.example.trabajo.controllers;

import com.example.trabajo.models.Empleado;
import com.example.trabajo.repos.EmpleadoRepository;
import com.example.trabajo.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/mvc")         //**********             http://localhost:8067/mvc
public class EmpleadoController {
    @Autowired
    EmpleadoService service;

    @Autowired
    EmpleadoRepository repository;

    @RequestMapping("showCreate")
    public String showCreate() {
        return "createEmpleado";
    }

    @RequestMapping("/displayEmpleados")          //**********             http://localhost:8067/mvc/displayEmpleados
    public String displayEmpleados(ModelMap modelMap) {
        List<Empleado> empleados = service.findAllEmpleados();
        modelMap.addAttribute("empleados", empleados);
        return "displayEmpleados";
    }

    @RequestMapping("/saveEmp")
    public String saveLocation(@ModelAttribute("empleado") Empleado empleado, ModelMap modelMap) {
        Empleado empleadoSaved = service.createEmpleado(empleado);
        String msg = "Empleado saved with id: " + empleadoSaved.toString();
        modelMap.addAttribute("msg", msg);
        return "createEmpleado";
    }

    @RequestMapping("deleteEmpleado")
    public String deleteLocation(@RequestParam("id") long id, ModelMap modelMap) {
        Empleado empleado = new Empleado();
        empleado.setId(id);
        service.deleteEmpleado(id);
        List<Empleado> empleados = service.findAllEmpleados();
        modelMap.addAttribute("empleados", empleados);
        return "displayEmpleados";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") long id, ModelMap modelMap) {
        Empleado empleado = service.findEmpleadoById(id);
        modelMap.addAttribute("empleado", empleado);
        return "updateEmpleado";
    }

    @RequestMapping("/updateEmp")
    public String updateLocation(@ModelAttribute("empleado") Empleado empleado, ModelMap modelMap) {
        service.updateEmpleado(empleado);
        List<Empleado> empleados = service.findAllEmpleados();
        modelMap.addAttribute("empleados", empleados);
        return "displayEmpleados";
    }

}
