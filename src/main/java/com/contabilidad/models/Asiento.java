/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.models;

import java.util.List;

public class Asiento {
    int idAsiento;
    String referencia;
    String observaciones;
    String estado;
    String fecha;
    String fechaCierre;
    int idDiario;
    String numero;
    String total;
    List<Movimientos> movimientos;

    public Asiento(int idAsiento, String referencia, String observaciones, String estado, String fecha, String fechaCierre, int idDiario, String numero, String total) {
        this.idAsiento = idAsiento;
        this.referencia = referencia;
        this.observaciones = observaciones;
        this.estado = estado;
        this.fecha = fecha;
        this.fechaCierre = fechaCierre;
        this.idDiario = idDiario;
        this.numero = numero;
        this.total = total;
    }

    public Asiento() {
    }

    public List<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }
    
    

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public int getIdDiario() {
        return idDiario;
    }

    public void setIdDiario(int idDiario) {
        this.idDiario = idDiario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
