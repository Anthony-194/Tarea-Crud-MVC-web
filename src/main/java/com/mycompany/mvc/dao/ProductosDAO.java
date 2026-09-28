/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.dao;

import com.mycompany.mvc.config.ConexionDB;
import com.mycompany.mvc.modelo.Productos;
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
public class ProductosDAO implements CrudDAO<Productos>{
    
    @Override
    public boolean insertar (Productos objeto){
    
        String sql = "INSERT INTO productos ( id_marcas, nombre, precio, stock, ?,?,?,?)";
            try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement (sql);
            
            ps.setInt(1, objeto.getIdMarca());
            ps.setString(2, objeto.getNombre());
            ps.setDouble(3,objeto.getPrecio());
            ps.setInt(4, objeto.getStock());
        
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de ingresar productos");
            return false;
        }
    }

    @Override
    public boolean actualizar(Productos objeto) {
    String sql = "UPDATE facturas SET id_marca = ?, nombre = ?, precio = ?, stock = ?, WHERE id_productos = ?";
        try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, objeto.getIdMarca ());
            ps.setString(2,objeto.getNombre());
            ps.setDouble(3,objeto.getPrecio());
            ps.setDouble(4,objeto.getStock());
            ps.setInt(6,objeto.getIdProducto());
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al actualizar el producto");
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
    String sql = "DELETE FROM productos WHERE id_productos = ?";
    try{
        Connection conn = ConexionDB.IniciarConexion ();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1,id);
        ps.executeUpdate ();
        
        return true;
        
    } catch (SQLException e){
        System.err.println("Error al eliminar el prodcuto");
        System.err.println(e.getMessage());
        return false;
        }
    }

    @Override
    public Productos buscarPorId(int id) {
    String sql = "SELECT id_marca, nombre, precio, stock FROM productos WHERE id_productos = ?";
    
       try{
         Connection conn = ConexionDB.IniciarConexion();
         PreparedStatement ps = conn.prepareStatement (sql);
         
         ps.setInt(1, id);
         
        ResultSet rs = ps.executeQuery ();
        if (rs.next()){
           return mapearProductos(rs);
        }
        
       }catch (SQLException e){
           System.err.println("Error al buscar el producto");
           System.err.println(e.getMessage());
        }
       return null;
    }

    @Override
    public List<Productos> listarTodos() {
    
        List<Productos> Productos = new ArrayList <> ();
        String sql = "SELECT id_productos, id_marca, nombre, precio, stock FROM productos";
        try{
            Connection conn = ConexionDB.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement (sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Productos.add(mapearProductos(rs));
        }
            
        } catch (SQLException e){
            System.err.println("Error al listar los prodcutos");
            System.err.println(e.getMessage());
        }
        return Productos;
    }
    
    private Productos mapearProductos(ResultSet rs) throws SQLException {
        return new Productos (
                rs.getInt("id_prudcutos"),
                rs.getInt("id_marca"),
                rs.getString("nombre"),
                rs.getDouble("precio"),
                rs.getInt("stock"));
        }
        
}   

