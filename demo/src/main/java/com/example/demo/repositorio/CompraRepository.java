package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Compra;
import com.example.demo.model.Proveedor;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
    List<Compra> findByProveedor(Proveedor proveedor);
    List<Compra> findByEstado(String estado);
}