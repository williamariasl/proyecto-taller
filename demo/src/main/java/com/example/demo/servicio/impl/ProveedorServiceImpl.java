package com.example.demo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Proveedor;
import com.example.demo.repositorio.ProveedorRepository;
import com.example.demo.servicio.ProveedorService;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;
    
    @Override
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }
    
    @Override
    public Optional<Proveedor> findById(Integer id) {
        return proveedorRepository.findById(id);
    }
    
    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }
    
    @Override
    public void deleteById(Integer id) {
        proveedorRepository.deleteById(id);
    }
    
    @Override
    public Optional<Proveedor> findByNombre(String nombre) {
        return proveedorRepository.findByNombre(nombre);
    }
}