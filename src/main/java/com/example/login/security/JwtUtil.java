package com.example.login.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

@Component
public class JwtUtil {

    // 1. Leemos la clave del properties
    @Value("${jwt.secret}")
    private String secretKey;

    private final long expirationTime = 60000 * 10;

    /*
    public String generateToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);

        // 2. Convertimos el String en la Key oficial
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key)
                .compact();
    }
    */
    // Cambia la firma para recibir el ID
    public String generateToken(Long id, String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("idUsuario", id); // Aquí en el token lo guardamos como "idUsuario"
        claims.put("role", role);

        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key)
                .compact();
    }

}
