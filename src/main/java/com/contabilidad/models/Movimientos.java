/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.models;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "Movimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT m FROM Movimientos m"),
    @NamedQuery(name = "Movimientos.findByIdMovimiento", query = "SELECT m FROM Movimientos m WHERE m.idMovimiento = :idMovimiento"),
    @NamedQuery(name = "Movimientos.findByTipoMovimiento", query = "SELECT m FROM Movimientos m WHERE m.tipoMovimiento = :tipoMovimiento"),
    @NamedQuery(name = "Movimientos.findByDebe", query = "SELECT m FROM Movimientos m WHERE m.debe = :debe"),
    @NamedQuery(name = "Movimientos.findByHaber", query = "SELECT m FROM Movimientos m WHERE m.haber = :haber"),
    @NamedQuery(name = "Movimientos.findByFecha", query = "SELECT m FROM Movimientos m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "Movimientos.findByDetalle", query = "SELECT m FROM Movimientos m WHERE m.detalle = :detalle"),
    @NamedQuery(name = "Movimientos.findByIdSubCuenta", query = "SELECT m FROM Movimientos m WHERE m.idSubCuenta = :idSubCuenta")})
public class Movimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimiento")
    private Short idMovimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "Tipo Movimiento")
    private String tipoMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Debe")
    private double debe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Haber")
    private double haber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSubCuenta")
    private short idSubCuenta;
    @JoinColumn(name = "idAsiento", referencedColumnName = "idAsiento")
    @ManyToOne(optional = false)
    private Asiento idAsiento;
    @JoinColumn(name = "idMovimiento", referencedColumnName = "idSubcuenta", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SubCuenta subCuenta;

    public Movimientos() {
    }

    public Movimientos(Short idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Movimientos(Short idMovimiento, String tipoMovimiento, double debe, double haber, Date fecha, String detalle, short idSubCuenta) {
        this.idMovimiento = idMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.debe = debe;
        this.haber = haber;
        this.fecha = fecha;
        this.detalle = detalle;
        this.idSubCuenta = idSubCuenta;
    }

    public Short getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Short idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public short getIdSubCuenta() {
        return idSubCuenta;
    }

    public void setIdSubCuenta(short idSubCuenta) {
        this.idSubCuenta = idSubCuenta;
    }

    public Asiento getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Asiento idAsiento) {
        this.idAsiento = idAsiento;
    }

    public SubCuenta getSubCuenta() {
        return subCuenta;
    }

    public void setSubCuenta(SubCuenta subCuenta) {
        this.subCuenta = subCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimiento != null ? idMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientos)) {
            return false;
        }
        Movimientos other = (Movimientos) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Movimientos[ idMovimiento=" + idMovimiento + " ]";
    }
    
}
