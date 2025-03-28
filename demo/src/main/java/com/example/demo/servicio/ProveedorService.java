package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Proveedor;

public interface ProveedorService {
    List<Proveedor> findAll();
    Optional<Proveedor> findById(Integer id);
    Proveedor save(Proveedor proveedor);
    void deleteById(Integer id);
    Optional<Proveedor> findByNombre(String nombre);
}