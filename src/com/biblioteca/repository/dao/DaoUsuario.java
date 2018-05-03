package com.biblioteca.repository.dao;

import com.biblioteca.model.Usuario;
import com.biblioteca.repository.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {

    private Conexion con;
    private List<Usuario> usuarios;


    public List<Usuario> select(String s) {
        usuarios = new ArrayList<>();
        con = new Conexion();
        ResultSet rs = con.executeQuery(s);
        try {
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7)));

            }
        } catch (SQLException e) {
            System.out.println("Error extrayendo los datos de Usuarioes\n");
            e.printStackTrace();

        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException q) {

            }
        }
        return usuarios;

    }


    public String Insert(Usuario u) {
        con = new Conexion();
        String sql = "INSERT INTO `usuarios` " +
                "(`cod_usuario`, `nombre`, `apellido`, `f_nacimiento`, `direccion`, `telefono`, `email`) " +
                "VALUES (NULL, '"+u.getNombre()+"', '"+u.getApellido()+"'," +
                " '"+u.getF_nacimiento()+"', '"+u.getDireccion()+"', '"+u.getTelefono()+"'," +
                " '"+u.getEmail()+"');";

        return con.query(sql);
    }


    public String update(Usuario u) {
        con = new Conexion();
        String sql = "UPDATE `usuarios`" +
                " SET `nombre` = '"+u.getNombre()+"', `apellido` = '"+u.getApellido()+"', " +
                "`f_nacimiento` = '"+u.getF_nacimiento()+"', `direccion` = '"+u.getDireccion()+"', " +
                "`telefono` = '"+u.getTelefono()+"', `email` = '"+u.getEmail()+"' " +
                "WHERE `usuarios`.`cod_usuario` = " + u.getCod_usuario();


        return con.query(sql);
    }


    public String delete(Usuario u) {
        con = new Conexion();
        String sql = "DELETE FROM `usuarios` WHERE `usuarios`.`cod_usuario` = " + u.getCod_usuario();


        return con.query(sql);
    }
}
