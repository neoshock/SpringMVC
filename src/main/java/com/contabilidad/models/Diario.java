/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pideu
 */
@Entity
@Table(name = "Diario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diario.findAll", query = "SELECT d FROM Diario d"),
    @NamedQuery(name = "Diario.findByIdDiario", query = "SELECT d FROM Diario d WHERE d.idDiario = :idDiario"),
    @NamedQuery(name = "Diario.findByNombre", query = "SELECT d FROM Diario d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Diario.findByFechaApertura", query = "SELECT d FROM Diario d WHERE d.fechaApertura = :fechaApertura"),
    @NamedQuery(name = "Diario.findByFechaCierre", query = "SELECT d FROM Diario d WHERE d.fechaCierre = :fechaCierre"),
    @NamedQuery(name = "Diario.findByDescripcion", query = "SELECT d FROM Diario d WHERE d.descripcion = :descripcion")})
public class Diario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDiario")
    private Short idDiario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Nombre ")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaApertura")
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaCierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @Size(max = 30)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "diario")
    private Asiento asientos;

    public Diario() {
    }

    public Diario(Short idDiario) {
        this.idDiario = idDiario;
    }

    public Diario(Short idDiario, String nombre, Date fechaApertura, Date fechaCierre) {
        this.idDiario = idDiario;
        this.nombre = nombre;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
    }

    public Short getIdDiario() {
        return idDiario;
    }

    public void setIdDiario(Short idDiario) {
        this.idDiario = idDiario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Asiento getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento asientos) {
        this.asientos = asientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiario != null ? idDiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diario)) {
            return false;
        }
        Diario other = (Diario) object;
        if ((this.idDiario == null && other.idDiario != null) || (this.idDiario != null && !this.idDiario.equals(other.idDiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Diario[ idDiario=" + idDiario + " ]";
    }
    
}
