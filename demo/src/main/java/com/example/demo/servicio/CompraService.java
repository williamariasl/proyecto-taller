package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Compra;
import com.example.demo.model.Proveedor;

public interface CompraService {
    List<Compra> findAll();
    Optional<Compra> findById(Integer id);
    Compra save(Compra compra);
    void deleteById(Integer id);
    List<Compra> findByProveedor(Proveedor proveedor);
}