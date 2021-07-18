package com.contabilidad.dao;

import com.contabilidad.models.Asiento;
import com.global.config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AsientoDAO {

    private Conexion conexion = new Conexion();
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private List<Asiento> asientos = new ArrayList<>();

    public List<Asiento> getAsientosContables() {
        String sql = String.format("SELECT \"idAsiento\", \"Referencia\", \"Observaciones\", \"Estado\", \"Fecha\", \"FechaCierre\", \"idDiario\", \"Numero\", \"Total\" FROM public.\"Asientos\"");
        asientos = new ArrayList<>();
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                asientos.add(new Asiento(resultSet.getInt("idAsiento"), resultSet.getString("Referencia"), 
                        resultSet.getString("Observaciones"), resultSet.getString("Estado"), resultSet.getString("Fecha"), 
                        resultSet.getString("FechaCierre"), resultSet.getInt("idDiario"), resultSet.getString("Numero"), 536.86));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return asientos;
    }

    public boolean addAsientoContable(Asiento asiento) {
        String sql = String.format("INSERT INTO public.\"Asientos\""
                + "( \"Referencia\", \"Observaciones\", \"Estado\", \"Fecha\", "
                + "\"FechaCierre\", \"idDiario\", \"Numero\", \"Total\")\n"
                + "		VALUES ('%1$s', '%2$s', '%3$s', '18/06/2021', '18/07/2021', '1', '%5$s',539.89)", 
                asiento.getReferencia(), asiento.getObservaciones(), asiento.getEstado(), asiento.getFecha(), asiento.getNumero());
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
