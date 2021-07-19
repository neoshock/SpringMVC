package com.contabilidad.models;


public class SubCuenta {
    int idSubcuenta;
    String Nombre;
    boolean Habilitado;
    String Codigo;

    public SubCuenta(int idSubcuenta, String Nombre, boolean Habilitado, String Codigo) {
        this.idSubcuenta = idSubcuenta;
        this.Nombre = Nombre;
        this.Habilitado = Habilitado;
        this.Codigo = Codigo;
    }

    public SubCuenta() {
        
    }

    public int getIdSubcuenta() {
        return idSubcuenta;
    }

    public void setIdSubcuenta(int idSubcuenta) {
        this.idSubcuenta = idSubcuenta;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public boolean isHabilitado() {
        return Habilitado;
    }

    public void setHabilitado(boolean Habilitado) {
        this.Habilitado = Habilitado;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
}
