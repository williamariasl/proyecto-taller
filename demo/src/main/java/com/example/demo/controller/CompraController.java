
package com.example.demo.controller;

import com.example.demo.model.Compra;
import com.example.demo.servicio.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("compras", compraService.findAll());
        return "compras/lista"; // templates/compras/lista.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("compra", new Compra());
        return "compras/formulario"; // templates/compras/formulario.html
    }

    @PostMapping
    public String crear(@ModelAttribute Compra compra) {
        compraService.save(compra);
        return "redirect:/compras";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        compraService.findById(id).ifPresent(compra -> model.addAttribute("compra", compra));
        return "compras/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Compra compra) {
        compra.setId(id);
        compraService.save(compra);
        return "redirect:/compras";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        compraService.deleteById(id);
        return "redirect:/compras";
    }
}