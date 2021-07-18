package com.contabilidad.dao;

import com.contabilidad.models.Asientos;
import com.global.config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AsientoDAO {

    private Conexion conexion = new Conexion();
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private List<Asientos> asientos = new ArrayList<>();

    public List<Asientos> getAsientosContables() {
        String sql = String.format("SELECT \"idAsiento\", \"Referencia\", \"Observaciones\", \"Estado\", \"Fecha\", \"FechaCierre\", \"idDiario\", \"Numero\", \"Total\" FROM public.\"Asientos\"");
        asientos = new ArrayList<>();
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                asientos.add(new Asientos(resultSet.getShort("idAsiento"),resultSet.getString("Referencia"), 
                        resultSet.getString("Observaciones"),resultSet.getString("Estado"),
                        resultSet.getDate("Fecha"),resultSet.getDate("FechaCierre"),resultSet.getString("Numero"),536.86));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return asientos;
    }

}
