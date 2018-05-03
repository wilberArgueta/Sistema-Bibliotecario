package com.biblioteca.repository.dao;

import com.biblioteca.model.Libro;
import com.biblioteca.repository.Conexion;
import com.sun.javafx.binding.StringFormatter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoLibro {

    private Conexion con;
    private List<Libro> libros;


    public List<Libro> select(String s) {
        libros = new ArrayList<>();
        con = new Conexion();
        ResultSet rs = con.executeQuery(s);
        try {
            while (rs.next()) {
                libros.add(new Libro(rs.getInt(1), rs.getString(2),
                        rs.getString(3)));

            }
        } catch (SQLException e) {
            System.out.println("Error extrayendo los datos de Libros\n");
            e.printStackTrace();

        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException q) {

            }
        }
        return libros;

    }


    public String Insert(Libro l) {
        con = new Conexion();
        String sql = "INSERT INTO `libros` " +
                "(`cod_libro`, `titulo`, `l_isbm`) " +
                "VALUES (NULL, '" + l.getTitulo() + "','" + l.getISBM() + "')";

        return con.query(sql);
    }


    public String update(Libro l) {
        con = new Conexion();
        String sql = "UPDATE `libros`" +
                " SET `titulo` = '" + l.getTitulo() + "', `l_isbm` = '" + l.getISBM() + "' " +
                "WHERE `libros`.`cod_libro` = " + l.getCod_libro();


        return con.query(sql);
    }


    public String delete(Libro l) {
        con = new Conexion();
        String sql = "DELETE FROM `libros` WHERE `libros`.`cod_libro` = " + l.getCod_libro();


        return con.query(sql);
    }
}
