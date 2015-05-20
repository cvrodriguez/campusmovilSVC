/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.movilcampus.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cvrodriguez
 */
@Entity
@Table(name = "programa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p"),
    @NamedQuery(name = "Programa.findByIdprograma", query = "SELECT p FROM Programa p WHERE p.idprograma = :idprograma"),
    @NamedQuery(name = "Programa.findByNombre", query = "SELECT p FROM Programa p WHERE p.nombre = :nombre")})
public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprograma")
    private Integer idprograma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "facultad", referencedColumnName = "idfacultad")
    @ManyToOne(optional = false)
    private Facultad facultad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programa")
    private List<Materia> materiaList;

    public Programa() {
    }

    public Programa(Integer idprograma) {
        this.idprograma = idprograma;
    }

    public Programa(Integer idprograma, String nombre) {
        this.idprograma = idprograma;
        this.nombre = nombre;
    }

    public Integer getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(Integer idprograma) {
        this.idprograma = idprograma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    @XmlTransient
    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprograma != null ? idprograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.idprograma == null && other.idprograma != null) || (this.idprograma != null && !this.idprograma.equals(other.idprograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.movilcampus.Programa[ idprograma=" + idprograma + " ]";
    }
    
}
