package com.example.login.model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Entity
@Data
@Table(name = "usuario") // Sin el schema fijo
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario") // Nombre real de tu PK
    private Long id;

    @Column(name = "usuario", unique = true, nullable = false)
    private String username;

    @Column(name = "contrasena", nullable = false)
    private String password;

    @Column(name = "id_rol", nullable = false)
    private Integer rol; // Cambiado de String a Integer


    private String correo;
    private String estado;
}