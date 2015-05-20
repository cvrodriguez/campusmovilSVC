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
@Table(name = "facultad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f"),
    @NamedQuery(name = "Facultad.findByIdfacultad", query = "SELECT f FROM Facultad f WHERE f.idfacultad = :idfacultad"),
    @NamedQuery(name = "Facultad.findByNombre", query = "SELECT f FROM Facultad f WHERE f.nombre = :nombre")})
public class Facultad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfacultad")
    private Integer idfacultad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultad")
    private List<Programa> programaList;

    public Facultad() {
    }

    public Facultad(Integer idfacultad) {
        this.idfacultad = idfacultad;
    }

    public Facultad(Integer idfacultad, String nombre) {
        this.idfacultad = idfacultad;
        this.nombre = nombre;
    }

    public Integer getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(Integer idfacultad) {
        this.idfacultad = idfacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacultad != null ? idfacultad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) object;
        if ((this.idfacultad == null && other.idfacultad != null) || (this.idfacultad != null && !this.idfacultad.equals(other.idfacultad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.movilcampus.Facultad[ idfacultad=" + idfacultad + " ]";
    }
    
}
