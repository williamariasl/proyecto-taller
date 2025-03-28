// ProductoController.java
package com.example.demo.controller;

import com.example.demo.model.Categoria;
import com.example.demo.model.Producto;
import com.example.demo.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/formulario";
    }

    @PostMapping
    public String crear(@ModelAttribute Producto producto) {
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        productoService.findById(id).ifPresent(producto -> model.addAttribute("producto", producto));
        return "productos/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Producto producto) {
        producto.setId(id);
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        productoService.deleteById(id);
        return "redirect:/productos";
    }

    @GetMapping("/categoria/{categoriaId}")
    public String buscarPorCategoria(@PathVariable Integer categoriaId, Model model) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaId);
        model.addAttribute("productos", productoService.findByCategoria(categoria));
        return "productos/lista";
    }
}