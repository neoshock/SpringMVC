package com.contabilidad.dao;

import com.contabilidad.models.Asiento;
import com.contabilidad.models.SubCuenta;
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

    public Asiento getAsientoById(int id) {
        Asiento asientoAux = new Asiento();
        String sql = String.format("SELECT \"idAsiento\", \"Referencia\", \"Observaciones\", \"Estado\", \"Fecha\", \"FechaCierre\", \"idDiario\", \"Numero\", \"Total\"\n"
                + "	FROM public.\"Asientos\" where \"idAsiento\" = '%1$d'", id);
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                asientoAux = new Asiento(resultSet.getInt("idAsiento"), resultSet.getString("Referencia"), resultSet.getString("Observaciones"), resultSet.getString("Estado"), resultSet.getString("Fecha"), resultSet.getString("FechaCierre"), resultSet.getInt("idDiario"), resultSet.getString("Numero"), resultSet.getDouble("Total"));
            }
            return asientoAux;
        } catch (Exception e) {
            asientoAux = new Asiento();
            asientoAux.setNumero("ERROR");
            asientoAux.setObservaciones(e.getMessage());
            return asientoAux;
        }
    }

    public List<SubCuenta> getCuentasContables() {
        String sql = "SELECT \"idSubcuenta\", \"Nombre\", \"Habilitado\", \"Codigo\"\n FROM public.\"SubCuenta\"";
        List<SubCuenta> subCuentas = new ArrayList<>();
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                subCuentas.add(new SubCuenta(resultSet.getInt("idSubcuenta"), resultSet.getString("Nombre"), resultSet.getBoolean("Habilitado"), resultSet.getString("Codigo")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return subCuentas;
    }

    public boolean addAsientoContable(Asiento asiento) {
        String sql = String.format("INSERT INTO public.\"Asientos\""
                + "( \"Referencia\", \"Observaciones\", \"Estado\", \"Fecha\", "
                + "\"FechaCierre\", \"idDiario\", \"Numero\", \"Total\")\n"
                + "		VALUES ('%1$s', '%2$s', '%3$s', '%4$s', '%5$s', '1', '%6$s',539.89)",
                asiento.getReferencia(), asiento.getObservaciones(), asiento.getEstado(), asiento.getFecha(), asiento.getFechaCierre(), asiento.getNumero());
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editAsientoContable(Asiento asiento, int id) {
        String sql = String.format("UPDATE public.\"Asientos\"\n" +
"	SET \"Referencia\"='%1$s', \"Observaciones\"='%2$s', \"Estado\"='%3$s', \"Fecha\"='%4$s', \"FechaCierre\"='%5$s', \"idDiario\"='1', \"Numero\"='%6$s', \"Total\"= 689.36\n" +
"	WHERE \"idAsiento\" = '%7$d'",asiento.getReferencia(),asiento.getObservaciones(),asiento.getEstado(),asiento.getFecha(),asiento.getFechaCierre(),asiento.getNumero(),id);
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
