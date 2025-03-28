// DetalleCompraController.java
package com.example.demo.controller;

import com.example.demo.model.DetalleCompra;
import com.example.demo.servicio.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalles-compra")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("detallesCompra", detalleCompraService.findAll());
        return "detalles-compra/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("detalleCompra", new DetalleCompra());
        return "detalles-compra/formulario";
    }

    @PostMapping
    public String crear(@ModelAttribute DetalleCompra detalleCompra) {
        detalleCompraService.save(detalleCompra);
        return "redirect:/detalles-compra";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        detalleCompraService.findById(id).ifPresent(detalle -> model.addAttribute("detalleCompra", detalle));
        return "detalles-compra/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute DetalleCompra detalleCompra) {
        detalleCompra.setId(id);
        detalleCompraService.save(detalleCompra);
        return "redirect:/detalles-compra";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        detalleCompraService.deleteById(id);
        return "redirect:/detalles-compra";
    }
}