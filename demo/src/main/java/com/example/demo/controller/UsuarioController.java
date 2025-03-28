// UsuarioController.java
package com.example.demo.controller;


import com.example.demo.model.Usuario;
import com.example.demo.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "usuarios/lista"; // templates/usuarios/lista.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/formulario"; // templates/usuarios/formulario.html
    }

    @PostMapping
    public String crear(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        usuarioService.findById(id).ifPresent(usuario -> model.addAttribute("usuario", usuario));
        return "usuarios/formulario"; // Reutiliza el mismo formulario
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Usuario usuario) {
        usuario.setId(id);
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        usuarioService.deleteById(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/buscar")
    public String buscarPorNombreUsuario(@RequestParam String nombreUsuario, Model model) {
        usuarioService.findByNombreUsuario(nombreUsuario)
                .ifPresent(usuario -> model.addAttribute("usuarios", java.util.Collections.singletonList(usuario)));
        return "usuarios/lista";
    }
}