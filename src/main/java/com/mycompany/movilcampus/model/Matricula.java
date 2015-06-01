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
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByIdestudiante", query = "SELECT m FROM Matricula m WHERE m.idestudiante.idestudiante = :idestudiante AND m.estado = false"),
    @NamedQuery(name = "Matricula.findByIdmatricula", query = "SELECT m FROM Matricula m WHERE m.idmatricula = :idmatricula"),
    @NamedQuery(name = "Matricula.findByEstado", query = "SELECT m FROM Matricula m WHERE m.estado = :estado"),
    @NamedQuery(name = "Matricula.findByAno", query = "SELECT m FROM Matricula m WHERE m.ano = :ano"),
    @NamedQuery(name = "Matricula.findByPeriodo", query = "SELECT m FROM Matricula m WHERE m.periodo = :periodo")})
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmatricula")
    private Long idmatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano")
    private String ano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo")
    private int periodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private List<Nota> notaList;
    @JoinColumn(name = "idsemestre", referencedColumnName = "idsemestre")
    @ManyToOne(optional = false)
    private Semestre idsemestre;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante")
    @ManyToOne(optional = false)
    private Estudiante idestudiante;

    public Matricula() {
    }

    public Matricula(Long idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Matricula(Long idmatricula, boolean estado, String ano, int periodo) {
        this.idmatricula = idmatricula;
        this.estado = estado;
        this.ano = ano;
        this.periodo = periodo;
    }

    public Long getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(Long idmatricula) {
        this.idmatricula = idmatricula;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    @XmlTransient
    public List<Nota> getNotaList() {
        return notaList;
    }

    public void setNotaList(List<Nota> notaList) {
        this.notaList = notaList;
    }

    public Semestre getIdsemestre() {
        return idsemestre;
    }

    public void setIdsemestre(Semestre idsemestre) {
        this.idsemestre = idsemestre;
    }

    public Estudiante getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiante idestudiante) {
        this.idestudiante = idestudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatricula != null ? idmatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idmatricula == null && other.idmatricula != null) || (this.idmatricula != null && !this.idmatricula.equals(other.idmatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.movilcampus.Matricula[ idmatricula=" + idmatricula + " ]";
    }
    
}
