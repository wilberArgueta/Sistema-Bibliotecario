package com.biblioteca.repository.dao;

import com.biblioteca.model.Alquiler;
import com.biblioteca.repository.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoAlquiler {

    private Conexion con;
    private List<Alquiler> alquileres;


    public List<Alquiler> select(String s) {
        alquileres = new ArrayList<>();
        con = new Conexion();
        ResultSet rs = con.executeQuery(s);
        try {
            while (rs.next()) {
                Alquiler a = new Alquiler();
                a.setIdAlquiler(rs.getInt(1));
                a.setCod_libro(rs.getInt(2));
                a.setCod_usuario(rs.getInt(3));
               a.setNombreUsuario(rs.getString(4));
                a.setTitulo(rs.getString(5));
                a.setfAdquirido(rs.getString(6));
                a.setfDevolucion(rs.getString(7));

                alquileres.add(a);

            }
        } catch (SQLException a) {
            System.out.println("Error extrayendo los datos de Alquileres\n");
            a.printStackTrace();

        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException q) {

            }
        }
        return alquileres;

    }


    public String Insert(Alquiler a) {
        con = new Conexion();
        String sql = "INSERT INTO `tb_alquiler` " +
                "(`id_alquiler`, `f_adquirido`, `f_devolucion`, `cod_libro`, `cod_usuario`)" +
                " VALUES (NULL, '"+a.getfAdquirido()+"', '"+a.getfDevolucion()+"', '"+a.getCod_libro()+"',' " +
                a.getCod_usuario()+"')";

        return con.query(sql);
    }


    public String update(Alquiler a) {
        con = new Conexion();
        String sql = "UPDATE `tb_alquiler` SET" +
                " `f_adquirido` = '"+a.getfAdquirido()+"', `f_devolucion` = '"+a.getfDevolucion()+"'," +
                " `cod_libro` = '"+a.getCod_libro()+"', `cod_usuario` = '"+a.getCod_usuario()+"'" +
                " WHERE `tb_alquiler`.`id_alquiler` =" + a.getIdAlquiler();


        return con.query(sql);
    }


    public String delete(Alquiler a) {
        con = new Conexion();
        String sql = "DELETE FROM `tb_alquiler` WHERE `tb_alquiler`.`id_alquiler` =" + a.getIdAlquiler();


        return con.query(sql);
    }
}
