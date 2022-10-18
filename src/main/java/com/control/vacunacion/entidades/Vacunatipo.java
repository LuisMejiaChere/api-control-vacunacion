/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control.vacunacion.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lmeji
 */

@Entity
@Table(name = "vacunatipo")
public class Vacunatipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvacunatipo;
    
    @NotNull
    private String nombrevacuna;
    
    private Boolean estadovacuna;

    public int getIdvacunatipo() {
        return idvacunatipo;
    }

    public void setIdvacunatipo(int idvacunatipo) {
        this.idvacunatipo = idvacunatipo;
    }

    public String getNombrevacuna() {
        return nombrevacuna;
    }

    public void setNombrevacuna(String nombrevacuna) {
        this.nombrevacuna = nombrevacuna;
    }

    public Boolean getEstadovacuna() {
        return estadovacuna;
    }

    public void setEstadovacuna(Boolean estadovacuna) {
        this.estadovacuna = estadovacuna;
    }
    
    
}
