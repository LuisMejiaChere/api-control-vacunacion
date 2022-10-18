/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control.vacunacion.controladores;

import com.control.vacunacion.entidades.Persona;
import com.control.vacunacion.repositorios.PersonaRepository;
import com.control.vacunacion.servicios.PersonaServicio;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author lmeji
 */
@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaServicio servicio;

    /*
    public ResponseEntity<Page<Persona>> listarPersonas(Pageable pageable) {
        return ResponseEntity.ok(repositorio.findAll(pageable));
    }*/
    @GetMapping
    public List<Persona> listarPersonas() {
        return servicio.listarPersonas();
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaId(@PathVariable Integer id){
        Optional<Persona> personaOptional = personaRepository.findById(id);
        
        if(!personaOptional.isPresent()){
           return ResponseEntity.unprocessableEntity().build();
       }
        
        return ResponseEntity.ok(personaOptional.get()); 
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaId(@PathVariable Integer id) {
        try {
            Persona persona = servicio.obtenerPersonaPorId(id);

            return new ResponseEntity<Persona>(persona, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    @PostMapping
    public ResponseEntity<Persona> guardarPersona(@Valid @RequestBody Persona persona) {
        Persona personaGuardada = personaRepository.save(persona);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idpersona}")
                .buildAndExpand(personaGuardada.getIdpersona()).toUri();

        return ResponseEntity.created(ubicacion).body(personaGuardada);
    }*/

    @PostMapping
    public Persona guardarPersona(@RequestBody Persona persona) {
        return servicio.guardarPersona(persona);
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @Valid @RequestBody Persona persana) {
        Optional<Persona> personaOptional = personaRepository.findById(id);

        if (!personaOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        persana.setIdpersona(personaOptional.get().getIdpersona());
        personaRepository.save(persana);

        return ResponseEntity.noContent().build();
    }*/
    @PutMapping("/{id}")
    public Persona actualizarPersona(@RequestBody Persona persona, @PathVariable Integer id) {
        try {
            Persona personaActual = servicio.obtenerPersonaPorId(id);

            personaActual.setCedula(persona.getCedula());
            personaActual.setNombres(persona.getNombres());
            personaActual.setApellidos(persona.getApellidos());
            personaActual.setCorreo(persona.getCorreo());
            personaActual.setFechanacimiento(persona.getFechanacimiento());
            personaActual.setDireccion(persona.getDireccion());
            personaActual.setTelefono(persona.getTelefono());
            personaActual.setEstadovacunacion(persona.getEstadovacunacion());
            personaActual.setFechavacunacion(persona.getFechavacunacion());
            personaActual.setNumerodosis(persona.getNumerodosis());

           return servicio.guardarPersona(personaActual);

           // return new ResponseEntity<Persona>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            //return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> eliminarPersona(@PathVariable Integer id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);

        if (!personaOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        personaRepository.delete(personaOptional.get());

        return ResponseEntity.noContent().build();
    }*/
    @DeleteMapping("/{id}")
    public List<Persona> eliminarPersona(@PathVariable Integer id) {
        servicio.eliminarPersona(id);
        return servicio.listarPersonas();
    }
}
