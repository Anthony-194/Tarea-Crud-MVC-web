/**
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
*/
package com.mycompany.mvc.dao;
import java.util.List;

/**
 *
 * @author Anthony
 */

public interface CrudDAO <T> {
    boolean insertar (T objeto);
    boolean actualizar (T objeto);
    boolean eliminar (int id);
    T buscarPorId (int id);
    List<T> listarTodos ();
}
