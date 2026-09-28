/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.dao;

import com.mycompany.mvc.config.ConexionDB;
import com.mycompany.mvc.modelo.Empleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Anthony
 */
public class EmpleadosDAO implements CrudDAO <Empleados> {

    @Override
    public boolean insertar(Empleados objeto) {
    String sql = "INSERT INTO empleados (id_puesto, nombre, apellidos, fecha_contratacion) VALUES (?,?,?,?)";
            try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement (sql);
            
            ps.setInt(1,objeto.getIdPuesto());
            ps.setString(2,objeto.getNombre());
            ps.setString(3,objeto.getApellidos());
            ps.setDate(4,java.sql.Date.valueOf(objeto.getFechaContratacion()));
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de insertar un Empleado nuevo");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Empleados objeto) {
    String sql = "UPDATE Empleados SET id_puesto = ?, nombre = ?, apellidos = ?, fecha_contratacion = ?, WHERE id_empleado = ?";
        try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, objeto.getIdPuesto());
            ps.setString(2,objeto.getNombre());
            ps.setString(3, objeto.getApellidos());
            ps.setDate(4,java.sql.Date.valueOf(objeto.getFechaContratacion()));
            ps.setInt(5,objeto.getIdEmpleado());
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de actualizar al Empleado");
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
    String sql = "DELETE FROM empleados WHERE id_empleado = ?";
    try{
        Connection conn = ConexionDB.IniciarConexion ();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1,id);
        ps.executeUpdate ();
        
        return true;
        
    } catch (SQLException e){
        System.err.println("Error al momento de eliminar informacion");
        System.err.println(e.getMessage());
        return false;
        }
    }

    @Override
    public Empleados buscarPorId(int id) {
    String sql = "SELECT id_empleado, id_puesto, nombre, apellidos, fecha_contratacion, FROM empleados WHERE id_empleados = ?";
    
       try{
         Connection conn = ConexionDB.IniciarConexion();
         PreparedStatement ps = conn.prepareStatement (sql);
         
         ps.setInt(1, id);
         
        ResultSet rs = ps.executeQuery ();
        if (rs.next()){
           return mapearEmpleado(rs);
        }
        
       }catch (SQLException e){
           System.err.println("Error al buscar al empleado");
           System.err.println(e.getMessage());
        }
       return null;
    }

    @Override
    public List<Empleados> listarTodos() {
    
        List<Empleados> empleados = new ArrayList <> ();
        String sql = "SELECT id_empleado, id_puesto, nombre, apellidos, fecha_contratacion FROM empleados";
        try{
            Connection conn = ConexionDB.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement (sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                empleados.add(mapearEmpleado(rs));
        }
            
        } catch (SQLException e){
            System.err.println("Error al listar los empleados");
            System.err.println(e.getMessage());
        }
        return empleados;
    }
    
    private Empleados mapearEmpleado(ResultSet rs) throws SQLException {
        return new Empleados (
                rs.getInt("id_empleado"),
                rs.getInt("id_puesto"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getDate("fecha_contratacion").toLocalDate());
        }
    }

    