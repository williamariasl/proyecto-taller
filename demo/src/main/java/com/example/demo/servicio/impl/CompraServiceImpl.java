package com.example.demo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Compra;
import com.example.demo.model.Proveedor;
import com.example.demo.repositorio.CompraRepository;
import com.example.demo.servicio.CompraService;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {
    
    @Autowired
    private CompraRepository compraRepository;
    
    @Override
    public List<Compra> findAll() {
        return compraRepository.findAll();
    }
    
    @Override
    public Optional<Compra> findById(Integer id) {
        return compraRepository.findById(id);
    }
    
    @Override
    public Compra save(Compra compra) {
        return compraRepository.save(compra);
    }
    
    @Override
    public void deleteById(Integer id) {
        compraRepository.deleteById(id);
    }
    
    @Override
    public List<Compra> findByProveedor(Proveedor proveedor) {
        return compraRepository.findByProveedor(proveedor);
    }
}
