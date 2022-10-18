/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.control.vacunacion.repositorios;

import com.control.vacunacion.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lmeji
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    
}
