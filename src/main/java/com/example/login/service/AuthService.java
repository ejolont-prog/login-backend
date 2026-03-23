package com.example.login.service;

import com.example.login.dto.LoginRequest;
import com.example.login.model.Usuario;
import com.example.login.repository.UsuarioRepository;
import com.example.login.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    public String authenticate(LoginRequest loginRequest) {
        System.out.println("DEBUG BACKEND: Recibiendo login para: " + loginRequest.getUsername());
        System.out.println("DEBUG BACKEND: Rol/Esquema recibido: " + loginRequest.getRol());

        String schema = loginRequest.getRol().toLowerCase().trim();

        try {
            // 1. Cambiamos el esquema.
            jdbcTemplate.execute("SET search_path TO " + schema);

            // 2. Buscamos al usuario.
            Optional<Usuario> userOpt = usuarioRepository.findByUsername(loginRequest.getUsername());

            if (userOpt.isPresent()) {
                Usuario usuario = userOpt.get();

                // 3. COMPARAMOS SOLO CONTRASEÑA.
                // AQUÍ NO HAY COMPARACIÓN DE ROL. El rol de Postman es solo para el esquema.
                if (usuario.getPassword().equals(loginRequest.getPassword())) {

                    // Generamos el token usando el nombre del usuario y el rol que quieras enviar al front
                    return jwtUtil.generateToken(usuario.getUsername(), loginRequest.getRol());
                } else {
                    System.out.println("DEBUG: Contraseña incorrecta");
                }
            } else {
                System.out.println("DEBUG: Usuario no encontrado en el esquema: " + schema);
            }
        } catch (Exception e) {
            System.err.println("DEBUG: Error de DB o Esquema: " + e.getMessage());
        } finally {
            jdbcTemplate.execute("SET search_path TO public");
        }

        return null; // Si llega aquí, es "Credenciales incorrectas"
    }
}