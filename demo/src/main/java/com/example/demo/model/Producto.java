package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    
    private String descripcion;
    
    private Integer stock;
    
    private BigDecimal precio;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    @Column(name = "creado_en")
    private LocalDateTime creadoEn;
    
    @OneToMany(mappedBy = "producto")
    private List<DetalleOrden> detallesOrden;
    
    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detallesCompra;
}