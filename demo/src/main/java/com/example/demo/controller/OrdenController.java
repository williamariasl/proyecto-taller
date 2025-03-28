// OrdenController.java
package com.example.demo.controller;

import com.example.demo.model.Orden;
import com.example.demo.servicio.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ordenes", ordenService.findAll());
        return "ordenes/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("orden", new Orden());
        return "ordenes/formulario";
    }

    @PostMapping
    public String crear(@ModelAttribute Orden orden) {
        ordenService.save(orden);
        return "redirect:/ordenes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        ordenService.findById(id).ifPresent(orden -> model.addAttribute("orden", orden));
        return "ordenes/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Orden orden) {
        orden.setId(id);
        ordenService.save(orden);
        return "redirect:/ordenes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        ordenService.deleteById(id);
        return "redirect:/ordenes";
    }
}