/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.modelo;

/**
 *
 * @author Anthony
 */
public class DetalleFacturas {
    private int idDetalles;
    private int idFactura;
    private int idProducto;
    private int Cantidad;
    private double PrecioUnitario;
    private double SubTotal;
    
    public DetalleFacturas (int idDetalles, int idFactura, int idProducto, int Cantidad, double PrecioUnitario, double SubTotal){
        this.idDetalles = idDetalles;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.SubTotal = SubTotal;
        
    }
    
    public int getIdDetalles (){
    return idDetalles;
    }
    public void setIdDetalles (int idDetalles){
    this.idDetalles = idDetalles;
    }
    public int getIdFactura (){
    return idFactura;
    }
    public void setIdFactura (int idFactura){
    this.idFactura = idFactura;
    }
    public int getIdProducto (){
    return idProducto;
    }
    public void setIdProducto (int idProducto){
    this.idProducto = idProducto;
    }
    public int getCantidad (){
    return Cantidad;
    }
    public void setCantidad (int Cantidad){
    this.Cantidad = Cantidad;
    }
    public double getPrecioUnitario (){
    return PrecioUnitario;
    }
    public void setPrecioUnitario (double PrecioUnitario){
    this.PrecioUnitario = PrecioUnitario;
    }
    public double getSubTotal (){
    return SubTotal;
    }
    public void setSubTotal (double SubTotal){
    this.SubTotal = SubTotal;
    }
}
