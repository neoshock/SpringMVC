/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.models;

public class Asiento {
    int idAsiento;
    String referencia;
    String observaciones;
    String estado;
    String fecha;
    String fechaCierre;
    int idDiario;
    String numero;
    double total;

    public Asiento(int idAsiento, String referencia, String observaciones, String estado, String fecha, String fechaCierre, int idDiario, String numero, double total) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
