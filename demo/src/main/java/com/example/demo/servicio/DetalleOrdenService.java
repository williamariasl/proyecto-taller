package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.DetalleOrden;
import com.example.demo.model.Orden;

public interface DetalleOrdenService {
    List<DetalleOrden> findAll();
    Optional<DetalleOrden> findById(Integer id);
    DetalleOrden save(DetalleOrden detalleOrden);
    void deleteById(Integer id);
    List<DetalleOrden> findByOrden(Orden orden);
}