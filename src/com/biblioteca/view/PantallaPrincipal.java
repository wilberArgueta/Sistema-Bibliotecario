package com.biblioteca.view;

import com.biblioteca.controller.*;
import com.biblioteca.model.*;
import com.biblioteca.repository.Conexion;
import com.biblioteca.repository.dao.*;
import com.biblioteca.view.modulos.*;

import javax.swing.*;
import java.awt.*;

public class PantallaPrincipal extends JFrame {

    private int flagView = 0;
    private Menu m;
    private MenuEdicion menuEdicion;

    private LibrosView librosView;
    private UsuariosView usuariosView;
    private AlquilerView alquilerView;
    private AutorView autorView;
    private EditorialView editorialView;

    private JScrollPane[] paneles = new JScrollPane[6];

    public PantallaPrincipal() {

        initComponent();
    }

    private void initComponent() {
        m = new Menu();
        menuEdicion = new MenuEdicion();
        menuEdicion.setVisible(false);
        paneles[0] = null;
        paneles[1] = librosView = new LibrosView();
        paneles[2] = usuariosView = new UsuariosView();
        paneles[3] = alquilerView = new AlquilerView();
        paneles[4] = autorView = new AutorView();
        paneles[5] = editorialView = new EditorialView();

        initActionButtons();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setLayout(null);
        setSize(toolkit.getScreenSize().width - 100, toolkit.getScreenSize().height - 50);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        add(m);
        add(menuEdicion);

        repaint();

    }

    private void initActionButtons() {
        m.btnLibros.addActionListener((e) -> {
            if (flagView != 0)
                remove(paneles[flagView]);
            this.add(librosView);
            menuEdicion.setVisible(true);
            repaint();
            flagView = 1;

        });
        m.btnUsuario.addActionListener((e) -> {
            if (flagView != 0)
                remove(paneles[flagView]);
            this.add(usuariosView);

            menuEdicion.setVisible(true);
            repaint();
            flagView = 2;
        });
        m.btnAlquiler.addActionListener((e) -> {
            if (flagView != 0)
                remove(paneles[flagView]);
            this.add(alquilerView);
            menuEdicion.setVisible(true);
            repaint();
            flagView = 3;

        });
        m.btnAutor.addActionListener((e) -> {
            if (flagView != 0) {
                remove(paneles[flagView]);
            }
            this.add(autorView);
            menuEdicion.setVisible(true);
            repaint();
            flagView = 4;

        });
        m.btnEditorial.addActionListener((e) -> {
            if (flagView != 0) {
                remove(paneles[flagView]);
            }
            this.add(editorialView);
            menuEdicion.setVisible(true);
            repaint();
            flagView = 5;
        });

        menuEdicion.btnBorrar.addActionListener((e) -> {
            JTable table;
            int fila;
            switch (flagView) {
                case 1:
                    table = librosView.getTableLibros();
                    LibroModelTable libroModelTable = librosView.getLibroModelTable();
                    fila = table.getSelectedRow();
                    Libro_Publicacion libroPublicacion = libroModelTable.getValue(fila);
                    DaoLibroPublicacion daoLibroPublicacion = new DaoLibroPublicacion();
                    daoLibroPublicacion.delete(libroPublicacion);
                    libroModelTable.borrar(fila);
                    repaint();
                    break;
                case 2:

                    table = usuariosView.getTableUsuarios();
                    UsuarioModelTable usuarioModelTable = usuariosView.getUsuarioModelTable();
                    fila = table.getSelectedRow();
                    Usuario usuario = usuarioModelTable.getValue(fila);
                    DaoUsuario daoUsuario = new DaoUsuario();
                    daoUsuario.delete(usuario);
                    usuarioModelTable.borrar(fila);
                    repaint();
                    break;

                case 3:
                    table = alquilerView.getTableAlquiler();
                    AlquilerModelTable alqu = alquilerView.getAlquilerModelTable();
                    fila = table.getSelectedRow();
                    Alquiler alquiler = alqu.getValue(fila);
                    DaoAlquiler da = new DaoAlquiler();
                    da.delete(alquiler);
                    alqu.borrar(fila);
                    repaint();
                    break;
                case 4:
                    table = autorView.getTableAutor();
                    AutorModelTable autorModelTable = autorView.getAutorModelTable();
                    fila = table.getSelectedRow();
                    Autor autor = autorModelTable.getValue(fila);
                    DaoAutor daoAutor = new DaoAutor();
                    daoAutor.delete(autor);
                    autorModelTable.borrar(fila);
                    repaint();
                    break;
                case 5:
                    table = editorialView.getTableEditorial();
                    EditorialModelTable editorialModelTable = editorialView.getEditorialModelTable();
                    fila = table.getSelectedRow();
                    Editorial editorial = editorialModelTable.getValue(fila);
                   DaoEditorial daoEditorial = new DaoEditorial();
                    daoEditorial.delete(editorial);
                    editorialModelTable.borrar(fila);
                    repaint();
                    break;


            }


        });

    }

}
