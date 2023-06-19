package com.example.trabajo.models;

import javax.persistence.*;

@Entity
@Table (name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private double sueldoXdia;
    private int diaTrabajados;
    private double sueldoBruto;
    private double sueldoNeto;

    public Empleado(long id, String nombre, double sueldoXdia, int diaTrabajados, double sueldoBruto, double sueldoNeto) {
        this.id = id;
        this.nombre = nombre;
        this.sueldoXdia = sueldoXdia;
        this.diaTrabajados = diaTrabajados;
        this.sueldoBruto = sueldoBruto;
        this.sueldoNeto = sueldoNeto;
    }

    public Empleado() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoXdia() {
        return sueldoXdia;
    }

    public void setSueldoXdia(double sueldoXdia) {
        this.sueldoXdia = sueldoXdia;
    }

    public int getDiaTrabajados() {
        return diaTrabajados;
    }

    public void setDiaTrabajados(int diaTrabajados) {
        this.diaTrabajados = diaTrabajados;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public double getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto(double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", sueldoXdia=" + sueldoXdia +
                ", diaTrabajados=" + diaTrabajados +
                ", sueldoBruto=" + sueldoBruto +
                ", sueldoNeto=" + sueldoNeto +
                '}';
    }
}
