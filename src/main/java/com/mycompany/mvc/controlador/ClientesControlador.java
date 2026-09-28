/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvc.controlador;

import com.mycompany.mvc.dao.ClientesDAO;
import com.mycompany.mvc.modelo.Clientes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Anthony
 */
@Controller
@RequestMapping ("/clientes")
public class ClientesControlador {
    private ClientesDAO clientesDAO = new ClientesDAO ();
    
@GetMapping
public String listar(Model model) {
    model.addAttribute("clientes", clientesDAO.listarTodos());
    model.addAttribute("cliente", new Clientes());
    return "clientes";
}

@GetMapping("/editar/{id}")
public String editar (@PathVariable int id, Model model){
    model.addAttribute("clientes", clientesDAO.listarTodos());
    model.addAttribute("cliente", clientesDAO.buscarPorId(id));
    
    return "clientes";
}


@PostMapping("/guardar")
public String guardar(@ModelAttribute Clientes cliente, RedirectAttributes ra){
    try{
        boolean ok = cliente.getIdClientes() == 0
            ? clientesDAO.insertar(cliente)
            : clientesDAO.actualizar(cliente);
        if (!ok){
        ra.addFlashAttribute("error", "Error al momento de almacenar");
    }
    }catch (Exception e){
        ra.addFlashAttribute("error", e.getMessage());
    }
    return "redirect:/clientes";
}
 
@PostMapping("/eliminar/{id}")
public String eliminar (@PathVariable int id){
    clientesDAO.eliminar(id);
    return "redirect:/clientes";
}

}