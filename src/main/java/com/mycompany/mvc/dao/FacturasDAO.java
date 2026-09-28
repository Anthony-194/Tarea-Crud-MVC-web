/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.dao;

import com.mycompany.mvc.config.ConexionDB;
import com.mycompany.mvc.modelo.Facturas;
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
public class FacturasDAO implements CrudDAO<Facturas> {
    @Override
    public boolean insertar (Facturas objeto){
    
        String sql = "INSERT INTO facturas ( id_cliente, id_empleado, fecha, total, ?,?,?,?)";
            try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement (sql);
            
            ps.setInt(1, objeto.getIdCliente());
            ps.setInt(2, objeto.getIdEmpleado());
            ps.setTimestamp(3,java.sql.Timestamp.valueOf(objeto.getFecha()));
            ps.setDouble(4, objeto.getTotal());
        
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de ingresar la factura");
            return false;
        }
    }

    @Override
    public boolean actualizar(Facturas objeto) {
    String sql = "UPDATE facturas SET id_cliente = ?, id_empleado = ?, fecha = ?, total = ?, WHERE id_factura = ?";
        try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, objeto.getIdCliente());
            ps.setInt(2,objeto.getIdEmpleado());
            ps.setTimestamp(3,java.sql.Timestamp.valueOf(objeto.getFecha()));
            ps.setDouble(4,objeto.getTotal());
            ps.setInt(6,objeto.getIdFactura());
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al actualizar la factura");
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
    String sql = "DELETE FROM facturas WHERE id_facturas = ?";
    try{
        Connection conn = ConexionDB.IniciarConexion ();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1,id);
        ps.executeUpdate ();
        
        return true;
        
    } catch (SQLException e){
        System.err.println("Error al eliminar la factura");
        System.err.println(e.getMessage());
        return false;
        }
    }

    @Override
    public Facturas buscarPorId(int id) {
    String sql = "SELECT id_cliente, id_empleado, fecha, total FROM facturas WHERE id_factura = ?";
    
       try{
         Connection conn = ConexionDB.IniciarConexion();
         PreparedStatement ps = conn.prepareStatement (sql);
         
         ps.setInt(1, id);
         
        ResultSet rs = ps.executeQuery ();
        if (rs.next()){
           return mapearFacturas(rs);
        }
        
       }catch (SQLException e){
           System.err.println("Error al buscar la factura");
           System.err.println(e.getMessage());
        }
       return null;
    }

    @Override
    public List<Facturas> listarTodos() {
    
        List<Facturas> Facturas = new ArrayList <> ();
        String sql = "SELECT id_factura, id_cliente, id_empleado, fecha, total FROM facturas";
        try{
            Connection conn = ConexionDB.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement (sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Facturas.add(mapearFacturas(rs));
        }
            
        } catch (SQLException e){
            System.err.println("Error al listar las facturas");
            System.err.println(e.getMessage());
        }
        return Facturas;
    }
    
    private Facturas mapearFacturas(ResultSet rs) throws SQLException {
        return new Facturas (
                rs.getInt("id_factura"),
                rs.getInt("id_cliente"),
                rs.getInt("id_empleado"),
                rs.getTimestamp("fecha").toLocalDateTime(),
                rs.getDouble("total"));
        }
        
}
