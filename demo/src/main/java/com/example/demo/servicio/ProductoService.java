package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Categoria;
import com.example.demo.model.Producto;

public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Integer id);
    Producto save(Producto producto);
    void deleteById(Integer id);
    List<Producto> findByCategoria(Categoria categoria);
}