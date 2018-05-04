package com.biblioteca.view.modulos;

import com.biblioteca.controller.LibroModelTable;
import com.biblioteca.model.Libro_Publicacion;
import com.biblioteca.repository.dao.DaoLibroPublicacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.List;

public class LibrosView extends JScrollPane {

    private JTable tableLibros;
    private LibroModelTable libroModelTable;
    public DaoLibroPublicacion daoLibroPublicacion;

    public LibrosView() {
        initComponent();
    }

    public void initComponent() {
        daoLibroPublicacion = new DaoLibroPublicacion();
        libroModelTable = new LibroModelTable();

        List<Libro_Publicacion> libroPublicacionList = daoLibroPublicacion.select("SELECT tb_libro_publicacion.id_libro_publicacion," +
                "tb_libro_publicacion.cod_libro,tb_libro_publicacion.cod_editorial,libros.titulo, autores.nombre," +
                "tb_libro_publicacion.f_publicacion,editoriales.nombre FROM `libros` " +
                "INNER JOIN tb_libro_autores on tb_libro_autores.cod_libro = libros.cod_libro " +
                "INNER JOIN autores on autores.cod_autor = tb_libro_autores.cod_autor" +
                " INNER JOIN tb_libro_publicacion ON tb_libro_publicacion.cod_libro = libros.cod_libro " +
                "INNER JOIN editoriales on editoriales.cod_editorial = tb_libro_publicacion.cod_editorial");
        for (Libro_Publicacion libroPublicacion : libroPublicacionList) {
            libroModelTable.addLibro(libroPublicacion);
        }

        tableLibros = new JTable(libroModelTable);
        tableLibros.setVisible(true);
        tableLibros.setFillsViewportHeight(true);
        setSize(1000, 500);
        setLocation(70, 120);
        setVisible(true);
        System.out.println("Creando el panel");
        setBorder(new TitledBorder("Usuarios menu"));
        setViewportView(tableLibros);

    }
    public LibroModelTable getLibroModelTable() {

        return this.libroModelTable;
    }

    public JTable getTableLibros() {
        return this.tableLibros;
    }
}
