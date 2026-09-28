/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.mvc.dao;

import com.mycompany.mvc.modelo.Clientes;
import com.mycompany.mvc.config.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Anthony
 */

public class ClientesDAO implements CrudDAO <Clientes> {

    @Override
    public boolean insertar(Clientes objeto) {
        String sql = "INSERT INTO clientes (nit, nombre, apellidos, email) VALUES (?,?,?,?)";
        try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement (sql);
            ps.setString (1,objeto.getNit());
            ps.setString (2,objeto.getNombre());
            ps.setString (3,objeto.getApellidos());
            ps.setString (4,objeto.getEmail());
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de insertar un cliente nuevo");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Clientes objeto) {
        String sql = "UPDATE clientes SET nit = ?, nombre = ?, apellidos = ?, email = ? WHERE id_cliente = ?";
        try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement (sql);
            ps.setString (1,objeto.getNit());
            ps.setString (2,objeto.getNombre());
            ps.setString (3,objeto.getApellidos());
            ps.setString (4,objeto.getEmail());
            ps.setInt (5,objeto.getIdClientes());
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de actualizar al cliente");
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM CLIENTES WHERE id_cliente = ?";
        try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement (sql);
            ps.setInt (1,id);
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de actualizar al cliente");
            return false;
        }
    }

    @Override
    public Clientes buscarPorId(int id) {
        String sql = "SELECT id_cliente, nit, nombre, apellidos, email FROM clientes WHERE id_cliente = ?";
        try{
            Connection conn = ConexionDB.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement (sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery ();
            if(rs.next ()){
                return mapearCliente(rs);
            }
        }catch (SQLException e){
            System.err.println("Error al buscar cliente");
        }
        return null;
    }

    @Override
    public List<Clientes> listarTodos() {
        List<Clientes> clientes = new ArrayList<>();
        String sql = "SELECT id_cliente, nit, nombre, apellidos, email FROM clientes ";
        try{
            Connection conn = ConexionDB.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement (sql);
            ResultSet rs = ps.executeQuery ();
            while(rs.next ()){
                clientes.add(mapearCliente(rs));
            }
        }catch (SQLException e){
            System.err.println("Error al buscar cliente");
        }
        return clientes;
    }
    
   private Clientes  mapearCliente (ResultSet rs) throws SQLException {
    return new Clientes(
    rs.getInt("id_Cliente"),
    rs.getString ("nit"),
    rs.getString("nombre"),
    rs.getString ("apellidos"),
   rs.getString("email"));
   } 
}