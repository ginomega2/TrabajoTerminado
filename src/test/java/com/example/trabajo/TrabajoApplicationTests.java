package com.example.trabajo;

import com.example.trabajo.models.Empleado;
import com.example.trabajo.repos.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrabajoApplicationTests {
    @Autowired
    EmpleadoRepository repository;
    @Test
    void crear(){
        Empleado empleado=new Empleado(2,"paco",489,5,877,1999);
        repository.save(empleado);
        empleado=new Empleado(12,"tere",4321,9,891,9574);
        repository.save(empleado);
        empleado=new Empleado(12,"sara",7711,99,231,874);
        repository.save(empleado);
        empleado=new Empleado(12,"juan",431,44,635,7636);
        repository.save(empleado);
        empleado=new Empleado(12,"tere",888,88,888,8888);
        repository.save(empleado);
    }
@Test
void read(){
        Empleado empleado=new Empleado();
        empleado=repository.findById(5L).get();
    System.out.println("********************************   "+empleado.getNombre()+empleado.getId());
}
@Test
    void update(){
        Empleado  empleado=new Empleado();
        empleado=repository.findById(5L).get();
    System.out.println(empleado);
    empleado.setNombre("jajajaja");
    repository.save(empleado);
}
@Test
    void delete(){
        Empleado empleado=new Empleado();
        empleado=repository.findById(5L).get();
        repository.delete(empleado);
}

}
