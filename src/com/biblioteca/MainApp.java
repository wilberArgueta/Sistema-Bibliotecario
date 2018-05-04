package com.biblioteca;



import com.biblioteca.model.Alquiler;
import com.biblioteca.repository.dao.DaoAlquiler;
import com.biblioteca.view.PantallaPrincipal;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        new PantallaPrincipal();
    //new UsuariosView();
        DaoAlquiler daoAlquiler = new DaoAlquiler();
        List<Alquiler> alquilerList = daoAlquiler.select("SELECT\n" +
                "    tb_alquiler.id_alquiler,\n" +
                "    tb_alquiler.cod_libro,\n" +
                "    tb_alquiler.cod_usuario,\n" +
                "    usuarios.nombre,\n" +
                "    libros.titulo,\n" +
                "    tb_alquiler.f_adquirido,\n" +
                "    tb_alquiler.f_devolucion\n" +
                "FROM\n" +
                "    `tb_alquiler`\n" +
                "LEFT JOIN\n" +
                "    libros\n" +
                "ON\n" +
                "    libros.cod_libro = tb_alquiler.cod_libro\n" +
                "LEFT JOIN\n" +
                "    usuarios\n" +
                "ON\n" +
                "    usuarios.cod_usuario = tb_alquiler.cod_usuario");

        for(Alquiler a: alquilerList){
            System.out.printf("Nombre: %s\n Titulo: %s\n ",a.getNombreUsuario(),a.getTitulo());

        }
    }

}
