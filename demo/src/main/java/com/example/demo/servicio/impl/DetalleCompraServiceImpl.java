// DetalleCompraServiceImpl.java
package com.example.demo.servicio.impl;


import com.example.demo.model.Compra;
import com.example.demo.model.DetalleCompra;
import com.example.demo.repositorio.DetalleCompraRepository;
import com.example.demo.servicio.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Override
    public List<DetalleCompra> findAll() {
        return detalleCompraRepository.findAll();
    }

    @Override
    public Optional<DetalleCompra> findById(Integer id) {
        return detalleCompraRepository.findById(id);
    }

    @Override
    public DetalleCompra save(DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public void deleteById(Integer id) {
        detalleCompraRepository.deleteById(id);
    }

    @Override
    public List<DetalleCompra> findByCompra(Compra compra) {
        return detalleCompraRepository.findByCompra(compra);
    }
}