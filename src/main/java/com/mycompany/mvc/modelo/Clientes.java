/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.modelo;

/**
 *
 * @author Anthony
 */
public class Clientes extends Persona {
    private int idClientes;
    private String email;
    private String nit;

    public Clientes() {
        super();
    }
    
       
    public Clientes(int idClientes, String nit, String nombre, String apellidos, String email){
        super (nombre, apellidos);
        this.nit = nit;
        this.idClientes = idClientes;
        this.email = email;
    }
    
    public String getNit(){
        return nit;
    }
    
    public void setNit (String nit){
        this.nit = nit;
    }
    public int getIdClientes(){
        return idClientes;
    }
    
    public void setIdClientes(int idClientes){
        this.idClientes = idClientes;
    }
    
    public String getEmail (){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }


}
