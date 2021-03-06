/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.movilcampus.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cvrodriguez
 */
@Entity
@Table(name = "nota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n"),
    @NamedQuery(name = "Nota.findNota", query = "SELECT n FROM Nota n WHERE n.materia.idmateria = :idmateria  AND  n.matricula.idestudiante.idestudiante = :idestudiante and n.matricula.estado = true"),
    @NamedQuery(name = "Nota.findByIdnota", query = "SELECT n FROM Nota n WHERE n.idnota = :idnota"),
    @NamedQuery(name = "Nota.findByPimerp", query = "SELECT n FROM Nota n WHERE n.primerp = :primerp"),
    @NamedQuery(name = "Nota.findBySegundop", query = "SELECT n FROM Nota n WHERE n.segundop = :segundop"),
    @NamedQuery(name = "Nota.findByTercerp", query = "SELECT n FROM Nota n WHERE n.tercerp = :tercerp"),
    @NamedQuery(name = "Nota.findByNotasvarias", query = "SELECT n FROM Nota n WHERE n.notasvarias = :notasvarias"),
    @NamedQuery(name = "Nota.findByNotaproyecto", query = "SELECT n FROM Nota n WHERE n.notaproyecto = :notaproyecto")})
public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnota")
    private Integer idnota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "primerp")
    private Double primerp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "segundop")
    private Double segundop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tercerp")
    private Double tercerp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notasvarias")
    private Double notasvarias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notaproyecto")
    private Double notaproyecto;
    @JoinColumn(name = "matricula", referencedColumnName = "idmatricula")
    @ManyToOne(optional = false)
    private Matricula matricula;
    @JoinColumn(name = "materia", referencedColumnName = "idmateria")
    @ManyToOne(optional = false)
    private Materia materia;

    public Nota() {
    }

    public Nota(Integer idnota) {
        this.idnota = idnota;
    }

    public Nota(Integer idnota, Double primerp, Double segundop, Double tercerp, Double notasvarias, Double notaproyecto) {
        this.idnota = idnota;
        this.primerp = primerp;
        this.segundop = segundop;
        this.tercerp = tercerp;
        this.notasvarias = notasvarias;
        this.notaproyecto = notaproyecto;
    }

    public Integer getIdnota() {
        return idnota;
    }

    public void setIdnota(Integer idnota) {
        this.idnota = idnota;
    }

    public Double getPrimerp() {
        return primerp;
    }

    public void setPrimerp(Double primerp) {
        this.primerp = primerp;
    }

    public Double getSegundop() {
        return segundop;
    }

    public void setSegundop(Double segundop) {
        this.segundop = segundop;
    }

    public Double getTercerp() {
        return tercerp;
    }

    public void setTercerp(Double tercerp) {
        this.tercerp = tercerp;
    }

    public Double getNotasvarias() {
        return notasvarias;
    }

    public void setNotasvarias(Double notasvarias) {
        this.notasvarias = notasvarias;
    }

    public Double getNotaproyecto() {
        return notaproyecto;
    }

    public void setNotaproyecto(Double notaproyecto) {
        this.notaproyecto = notaproyecto;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnota != null ? idnota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.idnota == null && other.idnota != null) || (this.idnota != null && !this.idnota.equals(other.idnota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.movilcampus.Nota[ idnota=" + idnota + " ]";
    }
    
}
