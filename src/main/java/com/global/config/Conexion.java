
package com.global.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    //Variables para la conexion
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    //Funcion encargada de la conexion a la base de datos
    //Se conecta a la base de datos postgre y nos devuelve un hilo de conexion
    public Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Global", 
                    "postgres", "123456");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    //Metodo encargado de devolver el hilo de conexion
    public Connection getConnection() {
        return connection;
    }

    
    //Metodo encargado de devolver el cierre de la conexion
    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
