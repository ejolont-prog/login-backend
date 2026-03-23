package com.example.login.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas/")
@CrossOrigin(origins = "*")
public class PersonaREST {

    @Autowired
    private com.example.login.service.AuthService personaService;

    /*
    @GetMapping
    private ResponseEntity<List<com.example.personaumg4.model.Usuario>> getAllPersonas (){
        return ResponseEntity.ok(personaService.findAll());
    }

    @PostMapping
    private ResponseEntity<com.example.personaumg4.model.Usuario> savePersona (@RequestBody com.example.personaumg4.model.Usuario persona){
        try {
            com.example.personaumg4.model.Usuario personaGuardada = personaService.save(persona);
            return ResponseEntity.created(new URI("/personas/"+personaGuardada.getId())).body(personaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping (value = "delete/{id}")
    private ResponseEntity<Boolean> deletePersona (@PathVariable ("id") Long id){

        return ResponseEntity.ok(personaService.deleteById(id));
    }


     */
}

