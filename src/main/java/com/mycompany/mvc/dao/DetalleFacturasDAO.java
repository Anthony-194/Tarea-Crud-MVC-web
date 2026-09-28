/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.dao;

import com.mycompany.mvc.config.ConexionDB;
import com.mycompany.mvc.modelo.DetalleFacturas;
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
public class DetalleFacturasDAO implements CrudDAO<DetalleFacturas> {
    
    @Override
    public boolean insertar (DetalleFacturas objeto){
    
        String sql = "INSERT INTO detalle_facturas ( id_factura, id_producto, cantidad, precio_unitario, subtotal, ?,?,?,?,?)";
            try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement (sql);
            
            ps.setInt(1, objeto.getIdFactura());
            ps.setInt(2, objeto.getIdProducto());
            ps.setInt(3, objeto.getCantidad());
            ps.setDouble(4, objeto.getPrecioUnitario());
            ps.setDouble(5, objeto.getSubTotal());
        
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de insertar detalles de la factura");
            return false;
        }
    }

    @Override
    public boolean actualizar(DetalleFacturas objeto) {
    String sql = "UPDATE detalle_facturas SET id_factura = ?, id_producto = ?, cantidad = ?, precio_unitario = ?, subtotal = ? WHERE id_detalles = ?";
        try{
            Connection conn = ConexionDB.IniciarConexion ();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, objeto.getIdFactura());
            ps.setInt(2,objeto.getIdProducto());
            ps.setInt(3, objeto.getCantidad());
            ps.setDouble(4,objeto.getPrecioUnitario());
            ps.setDouble(5,objeto.getSubTotal());
            ps.setInt(6,objeto.getIdDetalles());
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Error al memento de actualizar detalles de la factura");
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
    String sql = "DELETE FROM detalle_facturas WHERE id_detalles = ?";
    try{
        Connection conn = ConexionDB.IniciarConexion ();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1,id);
        ps.executeUpdate ();
        
        return true;
        
    } catch (SQLException e){
        System.err.println("Error al momento de eliminar detalles");
        System.err.println(e.getMessage());
        return false;
        }
    }

    @Override
    public DetalleFacturas buscarPorId(int id) {
    String sql = "SELECT id_detalles, id_factura, id_producto, cantidad, precio_unitario, subtotal FROM detalle_facturas WHERE id_detalles = ?";
    
       try{
         Connection conn = ConexionDB.IniciarConexion();
         PreparedStatement ps = conn.prepareStatement (sql);
         
         ps.setInt(1, id);
         
        ResultSet rs = ps.executeQuery ();
        if (rs.next()){
           return mapearDetalleFacturas(rs);
        }
        
       }catch (SQLException e){
           System.err.println("Error al buscar los detalles de la factura");
           System.err.println(e.getMessage());
        }
       return null;
    }

    @Override
    public List<DetalleFacturas> listarTodos() {
    
        List<DetalleFacturas> DetalleFacturas = new ArrayList <> ();
        String sql = "SELECT id_detalles, id_factura, id_producto, cantidad, precio_unitario, subtotal FROM detalle_facturas";
        try{
            Connection conn = ConexionDB.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement (sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                DetalleFacturas.add(mapearDetalleFacturas(rs));
        }
            
        } catch (SQLException e){
            System.err.println("Error al listar los detalles de la factura");
            System.err.println(e.getMessage());
        }
        return DetalleFacturas;
    }
    
    private DetalleFacturas mapearDetalleFacturas(ResultSet rs) throws SQLException {
        return new DetalleFacturas (
                rs.getInt("id_detalles"),
                rs.getInt("id_factura"),
                rs.getInt("id_producto"),
                rs.getInt("cantidad"),
                rs.getDouble("precio_unitario"),
                rs.getDouble("subtotal"));
        }
        
    }

/*
get recibir datos
post insertar datos
put actualiza datos
delete eliminar datos
*/