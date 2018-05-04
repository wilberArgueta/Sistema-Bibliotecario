package com.biblioteca.repository.dao;

import com.biblioteca.model.Editorial;
import com.biblioteca.repository.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoEditorial {

    private Conexion con;
    private List<Editorial> editoriales;


    public List<Editorial> select(String s) {
        editoriales = new ArrayList<>();
        con = new Conexion();
        ResultSet rs = con.executeQuery(s);
        try {
            while (rs.next()) {
                editoriales.add(new Editorial(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5)));

            }
        } catch (SQLException e) {
            System.out.println("Error extrayendo los datos de Editoriales\n");
            e.printStackTrace();

        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException q) {

            }
        }
        return editoriales;

    }


    public String Insert(Editorial e) {
        con = new Conexion();
        String sql = "INSERT INTO `editoriales` " +
                "(`cod_editorial`, `nombre`, `direccion`, `telefono`, `email`) " +
                "VALUES (NULL, '" + e.getNombreEditorial() + "', '" + e.getDireccion() + "', '" + e.getTelefono() + "', '" + e.getEmail() + "')";

        return con.query(sql);
    }


    public String update(Editorial e) {
        con = new Conexion();
        String sql = "UPDATE `editoriales` SET" +
                " `nombre` = '" + e.getNombreEditorial() + "', `direccion` = '" + e.getDireccion() + "', " +
                "`telefono` = '" + e.getTelefono() + "', `email` = '" + e.getEmail() + "' " +
                "WHERE `editoriales`.`cod_editorial` =" + e.getCod_editorial();


        return con.query(sql);
    }


    public String delete(Editorial e) {
        con = new Conexion();
        String sql = "DELETE FROM `editoriales` WHERE `editoriales`.`cod_editorial` =" + e.getCod_editorial();


        return con.query(sql);
    }
}
