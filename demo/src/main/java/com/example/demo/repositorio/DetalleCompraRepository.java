// DetalleCompraRepository.java
package com.example.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Compra;
import com.example.demo.model.DetalleCompra;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Integer> {
    java.util.List<DetalleCompra> findByCompra(Compra compra);
}