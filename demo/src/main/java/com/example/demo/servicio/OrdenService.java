package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Orden;
import com.example.demo.model.Usuario;

public interface OrdenService {
    List<Orden> findAll();
    Optional<Orden> findById(Integer id);
    Orden save(Orden orden);
    void deleteById(Integer id);
    List<Orden> findByUsuario(Usuario usuario);
}