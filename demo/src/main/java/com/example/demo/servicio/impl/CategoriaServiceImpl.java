package com.example.demo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categoria;
import com.example.demo.repositorio.CategoriaRepository;
import com.example.demo.servicio.CategoriaService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
    
    @Override
    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }
    
    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    @Override
    public void deleteById(Integer id) {
        categoriaRepository.deleteById(id);
    }
    
    @Override
    public Optional<Categoria> findByNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }
}