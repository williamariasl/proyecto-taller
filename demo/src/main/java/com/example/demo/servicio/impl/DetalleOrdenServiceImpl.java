// DetalleOrdenServiceImpl.java
package com.example.demo.servicio.impl;


import com.example.demo.model.DetalleOrden;
import com.example.demo.model.Orden;
import com.example.demo.repositorio.DetalleOrdenRepository;
import com.example.demo.servicio.DetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @Override
    public List<DetalleOrden> findAll() {
        return detalleOrdenRepository.findAll();
    }

    @Override
    public Optional<DetalleOrden> findById(Integer id) {
        return detalleOrdenRepository.findById(id);
    }

    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    @Override
    public void deleteById(Integer id) {
        detalleOrdenRepository.deleteById(id);
    }

    @Override
    public List<DetalleOrden> findByOrden(Orden orden) {
        return detalleOrdenRepository.findByOrden(orden);
    }
}