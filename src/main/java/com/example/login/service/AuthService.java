package com.example.login.service;

import com.example.login.model.Usuario;
import com.example.login.dto.LoginRequest;
import com.example.login.dto.AuthResponse;
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

    public AuthResponse authenticate(LoginRequest loginRequest) {
        String schema = loginRequest.getRol().toLowerCase().trim();
        try {
            jdbcTemplate.execute("SET search_path TO " + schema);
            Optional<Usuario> userOpt = usuarioRepository.findByUsername(loginRequest.getUsername());

            if (userOpt.isPresent() && userOpt.get().getPassword().equals(loginRequest.getPassword())) {
                // Generamos el token
                String token = jwtUtil.generateToken(userOpt.get().getUsername(), loginRequest.getRol());
                // DEVOLVEMOS AMBOS: Token para entrar y Rol para saber a qué web ir
                return new AuthResponse(token, loginRequest.getRol());
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            jdbcTemplate.execute("SET search_path TO public");
        }
        return null;
    }


}