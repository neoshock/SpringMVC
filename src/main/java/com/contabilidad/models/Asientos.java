/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pideu
 */
@Entity
@Table(name = "Asientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asientos.findAll", query = "SELECT a FROM Asientos a"),
    @NamedQuery(name = "Asientos.findByIdAsiento", query = "SELECT a FROM Asientos a WHERE a.idAsiento = :idAsiento"),
    @NamedQuery(name = "Asientos.findByReferencia", query = "SELECT a FROM Asientos a WHERE a.referencia = :referencia"),
    @NamedQuery(name = "Asientos.findByObservaciones", query = "SELECT a FROM Asientos a WHERE a.observaciones = :observaciones"),
    @NamedQuery(name = "Asientos.findByEstado", query = "SELECT a FROM Asientos a WHERE a.estado = :estado"),
    @NamedQuery(name = "Asientos.findByFecha", query = "SELECT a FROM Asientos a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Asientos.findByFechaCierre", query = "SELECT a FROM Asientos a WHERE a.fechaCierre = :fechaCierre"),
    @NamedQuery(name = "Asientos.findByIdDiario", query = "SELECT a FROM Asientos a WHERE a.idDiario = :idDiario"),
    @NamedQuery(name = "Asientos.findByNumero", query = "SELECT a FROM Asientos a WHERE a.numero = :numero"),
    @NamedQuery(name = "Asientos.findByTotal", query = "SELECT a FROM Asientos a WHERE a.total = :total")})
public class Asientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAsiento")
    private Short idAsiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Referencia")
    private String referencia;
    @Size(max = 60)
    @Column(name = "Observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaCierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDiario")
    private short idDiario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Total")
    private double total;
    @JoinColumn(name = "idAsiento", referencedColumnName = "idDiario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Diario diario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsiento")
    private Collection<Movimientos> movimientosCollection;

    public Asientos(Short idAsiento, String referencia, String observaciones, String estado, Date fecha, Date fechaCierre, String numero, double total) {
        this.idAsiento = idAsiento;
        this.referencia = referencia;
        this.observaciones = observaciones;
        this.estado = estado;
        this.fecha = fecha;
        this.fechaCierre = fechaCierre;
        this.numero = numero;
        this.total = total;
    }

    public Asientos() {
    }

    public Asientos(Short idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Asientos(Short idAsiento, String referencia, String estado, Date fecha, Date fechaCierre, short idDiario, String numero, double total) {
        this.idAsiento = idAsiento;
        this.referencia = referencia;
        this.estado = estado;
        this.fecha = fecha;
        this.fechaCierre = fechaCierre;
        this.idDiario = idDiario;
        this.numero = numero;
        this.total = total;
    }

    public Short getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Short idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public short getIdDiario() {
        return idDiario;
    }

    public void setIdDiario(short idDiario) {
        this.idDiario = idDiario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Diario getDiario() {
        return diario;
    }

    public void setDiario(Diario diario) {
        this.diario = diario;
    }

    @XmlTransient
    public Collection<Movimientos> getMovimientosCollection() {
        return movimientosCollection;
    }

    public void setMovimientosCollection(Collection<Movimientos> movimientosCollection) {
        this.movimientosCollection = movimientosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsiento != null ? idAsiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asientos)) {
            return false;
        }
        Asientos other = (Asientos) object;
        if ((this.idAsiento == null && other.idAsiento != null) || (this.idAsiento != null && !this.idAsiento.equals(other.idAsiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Asientos[ idAsiento=" + idAsiento + " ]";
    }
    
}
