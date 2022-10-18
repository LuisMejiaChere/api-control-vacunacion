/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control.vacunacion.servicios;

import com.control.vacunacion.entidades.Persona;
import com.control.vacunacion.repositorios.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author lmeji
 */
@Service
public class PersonaServicio {

    @Autowired
    private PersonaRepository repositorio;

 

    public List<Persona> listarPersonas() {
        return repositorio.findAll();
    }

    public Persona guardarPersona(Persona persona) {
         return repositorio.save(persona);
    }
    
   

    public Persona obtenerPersonaPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    public void eliminarPersona(Integer id) {
        repositorio.deleteById(id);
    }
}
