/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.control.vacunacion.repositorios;

import com.control.vacunacion.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lmeji
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
