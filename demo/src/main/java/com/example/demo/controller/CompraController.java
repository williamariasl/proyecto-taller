package com.example.demo.controller;

import com.example.demo.model.Compra;
import com.example.demo.model.Proveedor;
import com.example.demo.servicio.CompraService;
import com.example.demo.servicio.ProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("compras", compraService.findAll());
        model.addAttribute("proveedores", proveedorService.findAll());
        return "compras/lista"; // templates/compras/lista.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("compra", new Compra());
        model.addAttribute("proveedores", proveedorService.findAll());
        return "compras/formulario"; // templates/compras/formulario.html
    }

    @PostMapping
    public String crear(@ModelAttribute Compra compra, @RequestParam Integer proveedorId) {
        proveedorService.findById(proveedorId).ifPresent(compra::setProveedor);
        compraService.save(compra);
        return "redirect:/compras";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        compraService.findById(id).ifPresent(compra -> model.addAttribute("compra", compra));
        model.addAttribute("proveedores", proveedorService.findAll());
        return "compras/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Compra compra, @RequestParam Integer proveedorId) {
        compra.setId(id);
        proveedorService.findById(proveedorId).ifPresent(compra::setProveedor);
        compraService.save(compra);
        return "redirect:/compras";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        compraService.deleteById(id);
        return "redirect:/compras";
    }
}