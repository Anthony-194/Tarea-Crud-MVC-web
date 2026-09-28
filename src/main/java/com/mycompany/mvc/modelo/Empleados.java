/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.modelo;
import java.time.LocalDate;
/**
 *
 * @author Anthony
 */
public class Empleados extends Persona {
    
    private int idEmpleado;
    private int idPuesto;
    private LocalDate fechaContratacion;
    
    public Empleados(int idEmpleado,int idPuesto, String nombre, String apellidos, LocalDate fechaContratacion){
        super(nombre, apellidos);
        this.idEmpleado = idEmpleado;
        this.idPuesto = idPuesto;
        this.fechaContratacion = fechaContratacion;
    }
    public int getIdEmpleado(){
        return idEmpleado;
    }
    
    public void setIdEmpleado(int idEmpleado){
        this.idEmpleado = idEmpleado;
    }
    
    public int getIdPuesto (){
        return idPuesto;
    }
    
    public void setIdPuesto (int idPuesto){
        this.idPuesto = idPuesto;
    }
    
    public LocalDate getFechaContratacion () {
        return fechaContratacion;
    }
    
    public void setFechaContratacion (LocalDate fehcaContratacion){
        this.fechaContratacion = fechaContratacion;
    }
}
