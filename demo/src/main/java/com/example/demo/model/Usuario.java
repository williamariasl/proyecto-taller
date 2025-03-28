// Usuario.java
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    private String contrasena;

    private String rol;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn;

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes = new ArrayList<>(); // Inicializa como lista vacía

    // Constructor para el usuario inicial
    public Usuario(String nombreUsuario, String contrasena, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Constructor completo (opcional, reemplaza el eliminado)
    public Usuario(Integer id, String nombreUsuario, String contrasena, String rol, LocalDateTime creadoEn, List<Orden> ordenes) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.creadoEn = creadoEn;
        this.ordenes = ordenes;
    }

    @PrePersist
    public void prePersist() {
        this.creadoEn = LocalDateTime.now(); // Establece la fecha actual al crear
    }
}