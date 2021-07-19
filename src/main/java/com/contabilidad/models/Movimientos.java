
package com.contabilidad.models;

public class Movimientos {
    int idMovimiento;
    String tipoMovimiento;
    double debe;
    double haber;
    int idAsiento;
    int idSubcuenta;

    public Movimientos(int idMovimiento, String tipoMovimiento, double debe, double haber, int idAsiento, int idSubcuenta) {
        this.idMovimiento = idMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.debe = debe;
        this.haber = haber;
        this.idAsiento = idAsiento;
        this.idSubcuenta = idSubcuenta;
    }

    public Movimientos() {
    }
    
    

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
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

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public int getIdSubcuenta() {
        return idSubcuenta;
    }

    public void setIdSubcuenta(int idSubcuenta) {
        this.idSubcuenta = idSubcuenta;
    }
    
    
}
