package com.biblioteca.repository.dao;

import com.biblioteca.model.Autor;
import com.biblioteca.repository.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoAutor {

    private Conexion con;
    private List<Autor> autores;


    public List<Autor> select(String s) {
        autores = new ArrayList<>();
        con = new Conexion();
        ResultSet rs = con.executeQuery(s);
        try {
            while (rs.next()) {
                autores.add(new Autor(rs.getInt(1), rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6)));

            }
        } catch (SQLException e) {
            System.out.println("Error extrayendo los datos de Autores\n");
            e.printStackTrace();

        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException q) {

            }
        }
        return autores;

    }


    public String Insert(Autor a) {
        con = new Conexion();
        String sql = "INSERT INTO `autores` " +
                "(`cod_autor`, `nombre`, `apellido`, `f_nacimiento`, `nacionalidad`, `email`) " +
                "VALUES (NULL, '" + a.getNombreEditorial() + "','" + a.getApellidoAutor() + "" +
                "','"+a.getF_nacimiento()+"','"+a.getNacionalidad()+"','"+a.getEmail()+"')";

        return con.query(sql);
    }


    public String update(Autor a) {
        con = new Conexion();
        String sql = "UPDATE `autores`" +
                " SET `nombre` = '"+a.getNombreAutor()+"', `apellido` = '"+a.getApellidoAutor()+"'," +
                " `f_nacimiento` = '"+a.getF_nacimiento()+"', `nacionalidad` = '"+a.getNacionalidad()+"'," +
                " `email` = '"+a.getEmail()+"' WHERE `autores`.`cod_autor` ="+a.getCod_autor();


        return con.query(sql);
    }


    public String delete(Autor a) {
        con = new Conexion();
        String sql =  "DELETE FROM `autores` WHERE `autores`.`cod_autor` =" + a.getCod_autor();


        return con.query(sql);
    }
}
