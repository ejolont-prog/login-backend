package com.example.login.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
    private String rol; // Este es el que viene del selector de Angular
}