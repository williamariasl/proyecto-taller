package com.example.demo.servicio;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Compra;
import com.example.demo.model.DetalleCompra;

public interface DetalleCompraService {
    List<DetalleCompra> findAll();
    Optional<DetalleCompra> findById(Integer id);
    DetalleCompra save(DetalleCompra detalleCompra);
    void deleteById(Integer id);
    List<DetalleCompra> findByCompra(Compra compra);
}