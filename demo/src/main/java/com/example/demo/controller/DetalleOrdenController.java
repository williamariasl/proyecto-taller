package com.example.demo.controller;

import com.example.demo.model.DetalleOrden;
import com.example.demo.servicio.DetalleOrdenService;
import com.example.demo.servicio.OrdenService;
import com.example.demo.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalles-orden")
public class DetalleOrdenController {

    @Autowired
    private DetalleOrdenService detalleOrdenService;

    @Autowired
    private OrdenService ordenService; // Inyectar el servicio de órdenes

    @Autowired
    private ProductoService productoService; // Inyectar el servicio de productos

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("detallesOrden", detalleOrdenService.findAll());
        return "detalles-orden/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("detalleOrden", new DetalleOrden());
        model.addAttribute("ordenes", ordenService.findAll()); // Lista de órdenes
        model.addAttribute("productos", productoService.findAll()); // Lista de productos
        return "detalles-orden/formulario";
    }

    @PostMapping
    public String crear(@ModelAttribute DetalleOrden detalleOrden) {
        // Asociar la orden seleccionada
        ordenService.findById(detalleOrden.getOrden().getId())
            .ifPresent(detalleOrden::setOrden);
        // Asociar el producto seleccionado
        productoService.findById(detalleOrden.getProducto().getId())
            .ifPresent(detalleOrden::setProducto);
        detalleOrdenService.save(detalleOrden);
        return "redirect:/detalles-orden";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        detalleOrdenService.findById(id).ifPresent(detalle -> model.addAttribute("detalleOrden", detalle));
        model.addAttribute("ordenes", ordenService.findAll()); // Lista de órdenes
        model.addAttribute("productos", productoService.findAll()); // Lista de productos
        return "detalles-orden/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute DetalleOrden detalleOrden) {
        detalleOrden.setId(id);
        // Asociar la orden seleccionada
        ordenService.findById(detalleOrden.getOrden().getId())
            .ifPresent(detalleOrden::setOrden);
        // Asociar el producto seleccionado
        productoService.findById(detalleOrden.getProducto().getId())
            .ifPresent(detalleOrden::setProducto);
        detalleOrdenService.save(detalleOrden);
        return "redirect:/detalles-orden";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        detalleOrdenService.deleteById(id);
        return "redirect:/detalles-orden";
    }
}