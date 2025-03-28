// DataInitializer.java
package com.example.demo.config;
import com.example.demo.model.Usuario;
import com.example.demo.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(String... args) throws Exception {
        // Verifica si ya existe un usuario "admin"
        if (usuarioService.findByNombreUsuario("admin").isEmpty()) {
            // Crea un usuario predeterminado
            Usuario admin = new Usuario("admin", "12345", "ADMIN");
            usuarioService.save(admin); // La contraseña se encriptará automáticamente
            System.out.println("Usuario 'admin' creado con éxito.");
        } else {
            System.out.println("El usuario 'admin' ya existe.");
        }
    }
}