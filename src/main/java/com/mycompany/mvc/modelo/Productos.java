/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.modelo;

/**
 *
 * @author Anthony
 */
public class Productos {
    
    private int idProducto;
    private int idMarca;
    private String nombre;
    private double precio;
    private int stock;
    
    public Productos (int idProducto, int idMarca, String nombre, double precio, int stock){
        this.idProducto = idProducto;
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    public int getIdProducto (){
        return idProducto;
    }
    
    public void setIdProducto (int idProducto){
        this.idProducto = idProducto;
    }
    public int getIdMarca (){
        return idMarca;
    }
    public void setIdMarca (int idMarca){
        this.idMarca = idMarca;
    }
    
    public String getNombre (){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public double getPrecio (){
        return precio;
    }
    
    public void setPrecio (double precio){
        this.precio = precio;
    }
    
    public int getStock (){
        return stock;
    }
    
    public void setStock (int stock){
        this.stock = stock;
    }
}
