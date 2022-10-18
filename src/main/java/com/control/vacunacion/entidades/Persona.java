/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control.vacunacion.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.security.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lmeji
 */
@Entity
@Table(name = "persona")
public class Persona {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long idpersona;

    @Id
    @Column(name = "idpersona", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idpersona;

    @NotNull
    private String cedula;

    @NotNull
    private String nombres;

    @NotNull
    private String apellidos;

    @NotNull
    private String correo;

    private String fechanacimiento;
    private String direccion;
    private String telefono;

    private Boolean estadovacunacion;

    private String fechavacunacion;
    private Integer numerodosis;

    private Timestamp fecharegistro;
    private Timestamp fechamodificacion;
    private Boolean estadopersona;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "vacunatipoid")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Vacunatipo vacunatipo;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<Usuario> usuarios = new HashSet<>();

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstadovacunacion() {
        return estadovacunacion;
    }

    public void setEstadovacunacion(Boolean estadovacunacion) {
        this.estadovacunacion = estadovacunacion;
    }

    public String getFechavacunacion() {
        return fechavacunacion;
    }

    public void setFechavacunacion(String fechavacunacion) {
        this.fechavacunacion = fechavacunacion;
    }

    public Integer getNumerodosis() {
        return numerodosis;
    }

    public void setNumerodosis(Integer numerodosis) {
        this.numerodosis = numerodosis;
    }

    public Timestamp getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Timestamp fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Timestamp getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Timestamp fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Boolean getEstadopersona() {
        return estadopersona;
    }

    public void setEstadopersona(Boolean estadopersona) {
        this.estadopersona = estadopersona;
    }

    public Vacunatipo getVacunatipo() {
        return vacunatipo;
    }

    public void setVacunatipo(Vacunatipo vacunatipo) {
        this.vacunatipo = vacunatipo;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;

        for (Usuario usuario : usuarios) {
            usuario.setPersona(this);
        }
    }

}
