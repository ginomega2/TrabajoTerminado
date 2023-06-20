package com.example.trabajo.controllers;

import com.example.trabajo.models.Empleado;
import com.example.trabajo.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/th")   //********      http://localhost:8067/th
public class EmpleadoControllerThymeleaf {

    @Autowired
    EmpleadoService empleadoService;

    @RequestMapping("/")             //********      http://localhost:8067/th/
    public String home(Model model){

        model.addAttribute("empleado",new Empleado());
        return "th/index";

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processFormData(Empleado empleado){
        empleadoService.createEmpleado(empleado);
        return "th/result";
    }

    @RequestMapping("/displayEmpleados")         //********      http://localhost:8067/th/displayEmpleados
    public String displayEmpleados(ModelMap modelMap) {
        List<Empleado> empleados = empleadoService.findAllEmpleados();
        modelMap.addAttribute("empleados", empleados);
        return "th/displayEmpleados";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        Empleado empleado=empleadoService.findEmpleadoById(id);
        model.addAttribute("empleado",empleado);
        return "th/edit";

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String processFormupdate(Empleado empleado){
        empleadoService.updateEmpleado(empleado);
        return "th/result";
    }




}
