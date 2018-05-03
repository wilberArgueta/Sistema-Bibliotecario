package com.biblioteca.repository.dao;

import com.biblioteca.model.Libro_Autor;
import com.biblioteca.repository.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoLibroAutor {

    private Conexion con;
    private List<Libro_Autor> libroAutor;


    public List<Libro_Autor> select(String s) {
        libroAutor = new ArrayList<>();
        con = new Conexion();
        ResultSet rs = con.executeQuery(s);
        try {
            while (rs.next()) {
                libroAutor.add(new Libro_Autor(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3)));

            }
        } catch (SQLException libroAutor) {
            System.out.println("Error extrayendo los datos de Libro Autors\n");
            libroAutor.printStackTrace();

        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException q) {

            }
        }
        return libroAutor;

    }


    public String Insert(Libro_Autor libroAutor) {
        con = new Conexion();
        String sql = "INSERT INTO `tb_libro_autores` " +
                "(`id_libro_autor`, `cod_libro`, `cod_autor`)" +
                " VALUES (NULL, '" + libroAutor.getCod_libro() + "', '" + libroAutor.getCod_autor() + "')";

        return con.query(sql);
    }


    public String update(Libro_Autor libroAutor) {
        con = new Conexion();
        String sql = "UPDATE `tb_libro_autores` SET " +
                "`cod_libro` = '" + libroAutor.getCod_libro() + "', `cod_autor` = '" + libroAutor.getCod_autor() + "'" +
                " WHERE `tb_libro_autores`.`id_libro_autor` =" + libroAutor.getIdLibroAutor();


        return con.query(sql);
    }


    public String delete(Libro_Autor libroAutor) {
        con = new Conexion();
        String sql =  "DELETE FROM `tb_libro_autores` WHERE `tb_libro_autores`.`id_libro_autor` ="+libroAutor.getIdLibroAutor();


        return con.query(sql);
    }
}
