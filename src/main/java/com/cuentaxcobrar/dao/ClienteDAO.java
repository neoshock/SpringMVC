/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuentaxcobrar.dao;

import com.cuentaxcobrar.models.Cliente;
import com.global.config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Conexion conex = new Conexion();
    private Connection conn;
    private Statement st;
    private ResultSet result;
    private List<Cliente> listaclientes;

    public List<Cliente> obtenerCliente() {
        listaclientes = new ArrayList<>();
        try {
            String sentencia = "SELECT idcliente, identificacion, nombres, "
                    + "apellidos, direccion, telefono, email, habilitado\n"
                    + "FROM public.clientes order by habilitado desc";
            conn = conex.getConnection();
            st = conn.createStatement();
            result = st.executeQuery(sentencia);
            //LLenar mi lista con los datos del cliente
            while (result.next()) {
                listaclientes.add(new Cliente(result.getInt("idcliente"),
                        result.getInt("identificacion"),
                        result.getString("nombres"), 
                        result.getString("apellidos"),
                        result.getString("direccion"), 
                        result.getString("telefono"),
                        result.getString("email"), 
                        result.getBoolean("habilitado")));
            }
        } catch (SQLException e) {
            listaclientes.add(new Cliente(-1, -1, "-", "-", "-", "-", "-", 
                                         false));
            System.out.println("Error: " + e.getMessage());
        }
        return listaclientes;
    }

    public boolean insertarCliente(Cliente cliente) {
        try {
            String sentencia = "INSERT INTO public.clientes(identificacion, "
                    + "nombres, apellidos, direccion, telefono, email, "
                    + "habilitado) "
                    + "VALUES "
                    + "(" + cliente.getIdentificacion() + ","
                    + "'" + cliente.getNombres() + "',"
                    + "'" + cliente.getApellidos() + "',"
                    + "'" + cliente.getDireccion() + "',"
                    + "'" + cliente.getTelefono() + "',"
                    + "'" + cliente.getEmail() + "'," + true + ")";
            conn = conex.getConnection();
            st = conn.createStatement();
            st.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    

    public boolean modificarCliente(Cliente cliente, int id) {
        try {
            String sentencia = "Update clientes set "
                    + "identificacion = '" + cliente.getIdentificacion() + "',"
                    + "nombres = '" + cliente.getNombres() + "',"
                    + "apellidos = '" + cliente.getApellidos() + "',"
                    + "direccion = '" + cliente.getDireccion() + "',"
                    + "telefono = '" + cliente.getTelefono() + "',"
                    + "email = '" + cliente.getEmail() + "' "
                    + "where idcliente = " + id + "";
            conn = conex.getConnection();
            st = conn.createStatement();
            st.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public Cliente getIdCliente(int id){
        Cliente clienteaux = new Cliente();
        try {
            String sentencia = "Select * FROM public.clientes "
                    + "where idcliente = "+id;
            conn = conex.getConnection();
            st = conn.createStatement();
            result = st.executeQuery(sentencia);
            while(result.next()){
                clienteaux = new Cliente(result.getInt("idcliente"),
                        result.getInt("identificacion"),
                        result.getString("nombres"), 
                        result.getString("apellidos"),
                        result.getString("direccion"), 
                        result.getString("telefono"),
                        result.getString("email"), 
                        result.getBoolean("habilitado"));
            }
            return clienteaux;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return new Cliente();
        }
    }
    
    public boolean anularCliente(int id){
        try {
            String sentencia = "Update clientes set habilitado = false "
                    + "where idcliente = " + id;
            conn = conex.getConnection();
            st = conn.createStatement();
            st.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean desanularCliente(int id){
        try {
            String sentencia = "Update clientes set habilitado = true "
                    + "where idcliente = " + id;
            conn = conex.getConnection();
            st = conn.createStatement();
            st.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
