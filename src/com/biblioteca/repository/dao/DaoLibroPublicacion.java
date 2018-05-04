package com.biblioteca.repository.dao;

import com.biblioteca.model.Libro_Publicacion;
import com.biblioteca.repository.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoLibroPublicacion {

    private Conexion con;
    private List<Libro_Publicacion> libroPublicacion;


    public List<Libro_Publicacion> select(String s) {
        libroPublicacion = new ArrayList<>();
        con = new Conexion();
        ResultSet rs = con.executeQuery(s);
        try {
            while (rs.next()) {
                Libro_Publicacion l = new Libro_Publicacion();
                l.setIdLibroPublicacion(rs.getInt(1));
                l.setCod_libro(rs.getInt(2));
                l.setCod_editorial(rs.getInt(3));
                l.setTitulo(rs.getString(4));
                l.setNombreAutor(rs.getString(5));
                l.setfPublicacion(rs.getString(6));
                l.setNombreEditorial(rs.getString(7));

                libroPublicacion.add(l);

            }
        } catch (SQLException libroPublicacion) {
            System.out.println("Error extrayendo los datos de Libro Publicaion\n");
            libroPublicacion.printStackTrace();

        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException q) {

            }
        }
        return libroPublicacion;

    }


    public String Insert(Libro_Publicacion libroPublicacion) {
        con = new Conexion();
        String sql = "INSERT INTO `tb_libro_publicacion`" +
                " (`id_libro_publicacion`, `f_publicacion`, `cod_libro`, `cod_editorial`)" +
                " VALUES (NULL, '"+libroPublicacion.getfPublicacion()+"', '"+libroPublicacion.getCod_libro()+
                "', '"+libroPublicacion.getCod_editorial()+"')";

        return con.query(sql);
    }


    public String update(Libro_Publicacion libroPublicacion) {
        con = new Conexion();
        String sql = "UPDATE `tb_libro_publicacion` SET " +
                "`f_publicacion` = '"+libroPublicacion.getfPublicacion()+"', `cod_libro` = '"+libroPublicacion.getCod_libro()+
                "', `cod_editorial` = '"+libroPublicacion.getCod_editorial()+"'" +
                " WHERE `tb_libro_publicacion`.`id_libro_publicacion` ="+libroPublicacion.getIdLibroPublicacion();


        return con.query(sql);
    }


    public String delete(Libro_Publicacion libroPublicacion) {
        con = new Conexion();
        String sql = "DELETE FROM `tb_libro_publicacion` WHERE `tb_libro_publicacion`.`id_libro_publicacion` =" +
                libroPublicacion.getIdLibroPublicacion();


        return con.query(sql);
    }
}
