package com.example.login.repository;

import com.example.login.model.Usuario; // Importas tu modelo nuevo
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional; // Esta es la que te pide para el método de búsqueda

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Este método devuelve un Optional por si el usuario no existe en la DB
    Optional<Usuario> findByUsername(String username);
}