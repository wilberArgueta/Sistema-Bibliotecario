package com.biblioteca.repository;


import java.sql.*;

public class Conexion {

    private final String user = "admin";
    private final String pass = "admin";
    private final String url = "jdbc:mysql://localhost/";
    private final String db = "Biblioteca";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public Conexion() {

        try {
            connection = DriverManager.getConnection(url + db, user, pass);
            System.out.printf("!!Conexion a la base de datos Exitosa \n");
        } catch (SQLException e) {
            System.out.printf("" +
                    "Se ha registrado un error en la conexion con la base " +
                    "de datos %s \n" +
                    "Por favor verifique los parametros para realizar la conexion", db);

            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.printf("Error realizando la consulta SELECT\n");
            e.printStackTrace();

        }
        return resultSet;
    }

    public String query(String sql) {
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            return "Sentencia Ejecutada con exito";


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();

            }catch (SQLException e){

            }
        }

        return "\n";

    }

    public void close() {

        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            System.out.printf("Error cerrando la conexion..\n");
            e.printStackTrace();
        }
    }


}
