// UsuarioService.java
package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Usuario;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Integer id);
    Usuario save(Usuario usuario);
    void deleteById(Integer id);
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}