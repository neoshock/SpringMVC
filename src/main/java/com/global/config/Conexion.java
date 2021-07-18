
package com.global.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


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
                    "postgres", "123456789");
            statement = connection.createStatement();
        } catch (Exception e) {
            
        }
    }
    
    //Metodo encargado de devolver el hilo de conexion
    public Connection getConnection() {
        return connection;
    }
}
