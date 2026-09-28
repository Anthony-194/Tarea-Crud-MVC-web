/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.modelo;
import java.time.LocalDateTime;
/**
 *
 * @author Anthony
 */
public class Facturas {
    private int idFactura;
    private int idCliente;
    private int idEmpleado;
    private LocalDateTime fecha;
    private double total;
    
    public Facturas (int idFactura, int idCliente, int idEmpleado, LocalDateTime fecha, double total){
    this.idFactura = idFactura;
    this.idCliente = idCliente;
    this.idEmpleado = idEmpleado;
    this.fecha = fecha;
    this.total = total;
}
    public int getIdFactura (){
        return idFactura;
    }
    public void setIdFactura (int idFactura){
        this.idFactura = idFactura;
    }
    public int getIdCliente (){
        return idCliente;
    }
    public void setIdCliente (int idCliente){
        this.idCliente = idCliente;
    }
    public int getIdEmpleado (){
        return idEmpleado;
    }
    public void setIdEmpleado (int idEmpleado){
        this.idEmpleado = idEmpleado;
    }
    public LocalDateTime getFecha (){
        return fecha;
    }
    public void setFecha (LocalDateTime fecha){
        this.fecha = fecha;
    }
    public double getTotal (){
        return total;
    }
    public void setTotal (double total){
        this.total = total;
    }
}
