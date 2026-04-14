package com.example.login.rest;

import com.example.login.dto.LoginRequest;
import com.example.login.dto.AuthResponse;
import com.example.login.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(
        origins = {
                "https://loginsingenio.netlify.app", // Producción
                "http://localhost:4200",
                "http://localhost:4300"// Local
        },
        allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.OPTIONS}
)
public class AuthController {

    @Autowired
    private AuthService authService;

    /*
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.authenticate(loginRequest);

        if (token != null) {
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas o rol no autorizado");
        }
    }
    */

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse response = authService.authenticate(loginRequest);

        if (response != null) {
            // Esto enviará al frontend: {"token": "...", "rol": "agricultor"}
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }

}