package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

/*
    @Autowired
    private com.example.personaumg4.repository.UsuarioRepository personaRepository;

    public List<com.example.personaumg4.model.Usuario> findAll() {
        return personaRepository.findByEstadoP("E");
    }

    public List<com.example.personaumg4.model.Usuario> findAll(Sort sort) {
        return personaRepository.findAll(sort);
    }


    public Page<com.example.personaumg4.model.Usuario> findAll(Pageable pageable) {
        return personaRepository.findAll(pageable);
    }

    public <S extends com.example.personaumg4.model.Usuario> S save(S entity) {
        return personaRepository.save(entity);
    }

    public Optional<com.example.personaumg4.model.Usuario> findById(Long id) {
        return personaRepository.findById(id);
    }


    public Boolean deleteById(Long id) {
        com.example.personaumg4.model.Usuario persona =  personaRepository.findById(id).orElse(null);
        if (persona != null){
            persona.setEstadoP("D");
            personaRepository.save(persona);
            return true;
        }
        return false;
    }

    public void delete(com.example.personaumg4.model.Usuario entity) {
        personaRepository.delete(entity);
    }


*/
}

