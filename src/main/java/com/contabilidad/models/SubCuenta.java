/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.models;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pideu
 */
@Entity
@Table(name = "SubCuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubCuenta.findAll", query = "SELECT s FROM SubCuenta s"),
    @NamedQuery(name = "SubCuenta.findByIdSubcuenta", query = "SELECT s FROM SubCuenta s WHERE s.idSubcuenta = :idSubcuenta"),
    @NamedQuery(name = "SubCuenta.findByNombre", query = "SELECT s FROM SubCuenta s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SubCuenta.findByHabilitado", query = "SELECT s FROM SubCuenta s WHERE s.habilitado = :habilitado"),
    @NamedQuery(name = "SubCuenta.findByCodigo", query = "SELECT s FROM SubCuenta s WHERE s.codigo = :codigo")})
public class SubCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSubcuenta")
    private Short idSubcuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Habilitado")
    private boolean habilitado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Codigo")
    private String codigo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "subCuenta")
    private Movimientos movimientos;

    public SubCuenta() {
    }

    public SubCuenta(Short idSubcuenta) {
        this.idSubcuenta = idSubcuenta;
    }

    public SubCuenta(Short idSubcuenta, String nombre, boolean habilitado, String codigo) {
        this.idSubcuenta = idSubcuenta;
        this.nombre = nombre;
        this.habilitado = habilitado;
        this.codigo = codigo;
    }

    public Short getIdSubcuenta() {
        return idSubcuenta;
    }

    public void setIdSubcuenta(Short idSubcuenta) {
        this.idSubcuenta = idSubcuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Movimientos getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Movimientos movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubcuenta != null ? idSubcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCuenta)) {
            return false;
        }
        SubCuenta other = (SubCuenta) object;
        if ((this.idSubcuenta == null && other.idSubcuenta != null) || (this.idSubcuenta != null && !this.idSubcuenta.equals(other.idSubcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.SubCuenta[ idSubcuenta=" + idSubcuenta + " ]";
    }
    
}
