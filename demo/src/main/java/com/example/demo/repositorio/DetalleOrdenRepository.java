// DetalleOrdenRepository.java
package com.example.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DetalleOrden;
import com.example.demo.model.Orden;

import java.util.List;

public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer> {
    List<DetalleOrden> findByOrden(Orden orden);
}