package com.biblioteca.view;

import com.biblioteca.controller.UsuarioModelTable;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.dao.DaoUsuario;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.util.List;

public class AlquilerView extends JScrollPane {
    private JTable tableAlquiler;
    private UsuarioModelTable usuarioModelTable;
    private JScrollPane jScrollPane;
    public DaoUsuario daoUsuario;

    public AlquilerView() {
        initComponent();
    }

    public void initComponent() {
        daoUsuario = new DaoUsuario();
        usuarioModelTable = new UsuarioModelTable();

        List<Usuario> listaUser = daoUsuario.select("SELECT * FROM usuarios");
        for (Usuario usuario : listaUser) {
            usuarioModelTable.addUser(usuario);
        }

        tableAlquiler = new JTable(usuarioModelTable);
        tableAlquiler.setVisible(true);
        tableAlquiler.setFillsViewportHeight(true);
        setSize(1000, 500);
        setLocation(70, 120);
        setVisible(true);
        System.out.println("Creando el panel");
        setBorder(new TitledBorder("Usuarios menu"));
        setViewportView(tableAlquiler);

    }
}
