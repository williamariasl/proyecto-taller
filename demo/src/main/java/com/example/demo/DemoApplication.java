// DemoApplication.java
package com.example.demo;

import com.example.demo.model.Usuario;
import com.example.demo.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private UsuarioService usuarioService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            // Verifica si ya existe un usuario "admin"
            if (usuarioService.findByNombreUsuario("admin").isEmpty()) {
                // Crea un usuario predeterminado
                Usuario admin = new Usuario("admin", "12345", "ADMIN");
                usuarioService.save(admin); // La contraseña se encriptará y creadoEn se establecerá automáticamente
                System.out.println("Usuario 'admin' creado con éxito.");
            } else {
                System.out.println("El usuario 'admin' ya existe.");
            }
        };
    }
}