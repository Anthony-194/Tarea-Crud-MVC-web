/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.modelo;

/**
 *
 * @author Anthony
 */
public class Puestos {
    private int idPuesto;
    private String nombre;
    private double salariobase;

    public Puestos (int idPuesto, String nombre, double salariobase){
        this.idPuesto = idPuesto;
        this.nombre = nombre;
        this.salariobase = salariobase;
}
    
    public int getIdPuesto(){
        return idPuesto;
    }
    
    public void setIdPuesto(int idPuesto){
        this.idPuesto = idPuesto;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    
    public double getSalarioBase(){
        return salariobase;
    }
    public void setSalariBase (double slariobase){
        this.salariobase = salariobase;
    }
}
