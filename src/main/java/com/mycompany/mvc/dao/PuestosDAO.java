/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.dao;

import com.mycompany.mvc.config.ConexionDB;
import com.mycompany.mvc.modelo.Puestos;
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
public class PuestosDAO implements CrudDAO<Puestos> {
     @Override
    public boolean insertar (Puestos objeto){
    
        String sql = "INSERT INTO puestos ( nombre, salario_base) VALUES (?,?)";
            try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement (sql);
            
            ps.setString(1, objeto.getNombre());
            ps.setDouble(2, objeto.getSalarioBase());
        
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de ingresar el puesto");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Puestos objeto) {
    String sql = "UPDATE puestos SET nombre = ?, salario_base = ? WHERE id_puestos = ?";
        try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, objeto.getNombre ());
            ps.setDouble(2,objeto.getSalarioBase());
            ps.setInt(3,objeto.getIdPuesto());
            
            ps.executeUpdate();
            
            return true;
        }catch(SQLException e){
            System.err.println("Error al actualizar el puesto");
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
    String sql = "DELETE FROM puestos WHERE id_puestos = ?";
    try{
        Connection conn = ConexionDB.IniciarConexion ();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1,id);
        ps.executeUpdate ();
        
        return true;
        
    } catch (SQLException e){
        System.err.println("Error al eliminar el puesto");
        System.err.println(e.getMessage());
        return false;
        }
    }

    @Override
    public Puestos buscarPorId(int id) {
    String sql = "SELECT nombre, salario_base FROM productos WHERE id_puestos = ?";
    
       try{
         Connection conn = ConexionDB.IniciarConexion();
         PreparedStatement ps = conn.prepareStatement (sql);
         
         ps.setInt(1, id);
         
        ResultSet rs = ps.executeQuery ();
        if (rs.next()){
           return mapearPuestos(rs);
        }
        
       }catch (SQLException e){
           System.err.println("Error al buscar el puesto");
           System.err.println(e.getMessage());
        }
       return null;
    }

    @Override
    public List<Puestos> listarTodos() {
    
        List<Puestos> Puestos = new ArrayList <> ();
        String sql = "SELECT id_puestos, nombre, salario_base FROM puestos";
        try{
            Connection conn = ConexionDB.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement (sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Puestos.add(mapearPuestos(rs));
        }
            
        } catch (SQLException e){
            System.err.println("Error al listar los puestos");
            System.err.println(e.getMessage());
        }
        return Puestos;
    }
    
    private Puestos mapearPuestos(ResultSet rs) throws SQLException {
        return new Puestos (
                rs.getInt("id_puestos"),
                rs.getString("nombre"),
                rs.getDouble("salario_base"));
        }
}