package com.example.demo.controller;




import com.example.demo.model.Proveedor;
import com.example.demo.servicio.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("proveedores", proveedorService.findAll());
        return "proveedores/lista"; // templates/proveedores/lista.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedores/formulario"; // templates/proveedores/formulario.html
    }

    @PostMapping
    public String crear(@ModelAttribute Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        proveedorService.findById(id).ifPresent(proveedor -> model.addAttribute("proveedor", proveedor));
        return "proveedores/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Proveedor proveedor) {
        proveedor.setId(id);
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        proveedorService.deleteById(id);
        return "redirect:/proveedores";
    }
}