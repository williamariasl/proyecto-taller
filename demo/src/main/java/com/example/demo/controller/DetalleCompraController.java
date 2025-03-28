package com.example.demo.controller;

import com.example.demo.model.DetalleCompra;
import com.example.demo.servicio.CompraService;
import com.example.demo.servicio.DetalleCompraService;
import com.example.demo.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalles-compra")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraService detalleCompraService;

    @Autowired
    private CompraService compraService; // Inyectar el servicio de compras

    @Autowired
    private ProductoService productoService; // Inyectar el servicio de productos

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("detallesCompra", detalleCompraService.findAll());
        return "detalles-compra/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("detalleCompra", new DetalleCompra());
        model.addAttribute("compras", compraService.findAll()); // Lista de compras
        model.addAttribute("productos", productoService.findAll()); // Lista de productos
        return "detalles-compra/formulario";
    }

    @PostMapping
    public String crear(@ModelAttribute DetalleCompra detalleCompra) {
        // Asociar la compra seleccionada
        compraService.findById(detalleCompra.getCompra().getId())
            .ifPresent(detalleCompra::setCompra);
        // Asociar el producto seleccionado
        productoService.findById(detalleCompra.getProducto().getId())
            .ifPresent(detalleCompra::setProducto);
        detalleCompraService.save(detalleCompra);
        return "redirect:/detalles-compra";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        detalleCompraService.findById(id).ifPresent(detalle -> model.addAttribute("detalleCompra", detalle));
        model.addAttribute("compras", compraService.findAll()); // Lista de compras
        model.addAttribute("productos", productoService.findAll()); // Lista de productos
        return "detalles-compra/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute DetalleCompra detalleCompra) {
        detalleCompra.setId(id);
        // Asociar la compra seleccionada
        compraService.findById(detalleCompra.getCompra().getId())
            .ifPresent(detalleCompra::setCompra);
        // Asociar el producto seleccionado
        productoService.findById(detalleCompra.getProducto().getId())
            .ifPresent(detalleCompra::setProducto);
        detalleCompraService.save(detalleCompra);
        return "redirect:/detalles-compra";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        detalleCompraService.deleteById(id);
        return "redirect:/detalles-compra";
    }
}