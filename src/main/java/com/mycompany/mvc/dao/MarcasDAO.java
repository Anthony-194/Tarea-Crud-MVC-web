/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.dao;

import com.mycompany.mvc.config.ConexionDB;
import com.mycompany.mvc.modelo.Marcas;
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
public class MarcasDAO implements CrudDAO <Marcas> {

    @Override
    public boolean insertar(Marcas objeto) {
    String sql = "INSERT INTO marcas ( nombre, ?)";
            try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement (sql);
            
            ps.setString(1,objeto.getNombre());
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de insertar una marca nueva");
            return false;
        }
    }

    @Override
    public boolean actualizar(Marcas objeto) {
    String sql = "UPDATE Marcas SET  nombre = ?,  WHERE id_marca = ?";
        try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, objeto.getNombre());
            ps.setInt(2,objeto.getIdMarca());
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de actualizar la marca");
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
    String sql = "DELETE FROM marcas WHERE id_marca = ?";
    try{
        Connection conn = ConexionDB.IniciarConexion ();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1,id);
        ps.executeUpdate ();
        
        return true;
        
    } catch (SQLException e){
        System.err.println("Error al momento de eliminar la marca");
        System.err.println(e.getMessage());
        return false;
        }
    }

    @Override
    public Marcas buscarPorId(int id) {
    String sql = "SELECT id_marca, nombre FROM marcas WHERE id_marca = ?";
    
       try{
         Connection conn = ConexionDB.IniciarConexion();
         PreparedStatement ps = conn.prepareStatement (sql);
         
         ps.setInt(1, id);
         
        ResultSet rs = ps.executeQuery ();
        if (rs.next()){
           return mapearMarcas(rs);
        }
        
       }catch (SQLException e){
           System.err.println("Error al buscar la marca");
           System.err.println(e.getMessage());
        }
       return null;
    }

    @Override
    public List<Marcas> listarTodos() {
    
        List<Marcas> Marcas = new ArrayList <> ();
        String sql = "SELECT id_marca, nombre FROM marcas";
        try{
            Connection conn = ConexionDB.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement (sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Marcas.add(mapearMarcas(rs));
        }
            
        } catch (SQLException e){
            System.err.println("Error al listar los empleados");
            System.err.println(e.getMessage());
        }
        return Marcas;
    }
    
    private Marcas mapearMarcas(ResultSet rs) throws SQLException {
        return new Marcas (
                rs.getInt("id_marca"),
                rs.getString("nombre"));
        }
    }

