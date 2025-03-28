package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Categoria;

public interface CategoriaService {
    List<Categoria> findAll();
    Optional<Categoria> findById(Integer id);
    Categoria save(Categoria categoria);
    void deleteById(Integer id);
    Optional<Categoria> findByNombre(String nombre);
}