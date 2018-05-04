package com.biblioteca.view.modulos;

import com.biblioteca.controller.UsuarioModelTable;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.dao.DaoUsuario;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class UsuariosView extends JScrollPane {
    private JTable tableUsuarios;
    private UsuarioModelTable usuarioModelTable;
    private JScrollPane jScrollPane;
    public DaoUsuario daoUsuario;

    public UsuariosView() {
        initComponent();
    }

    public void initComponent() {
        daoUsuario = new DaoUsuario();
        usuarioModelTable = new UsuarioModelTable();

        List<Usuario> listaUser = daoUsuario.select("SELECT * FROM usuarios");
        for (Usuario usuario : listaUser) {
            usuarioModelTable.addUser(usuario);
        }

        tableUsuarios = new JTable(usuarioModelTable);
        tableUsuarios.setVisible(true);
        tableUsuarios.setFillsViewportHeight(true);
        setSize(1000, 500);
        setLocation(70, 120);
        setVisible(true);
        System.out.println("Creando el panel");
        setBorder(new TitledBorder("Usuarios menu"));
        setViewportView(tableUsuarios);

    }
    public UsuarioModelTable getUsuarioModelTable() {

        return this.usuarioModelTable;
    }

    public JTable getTableUsuarios() {
        return this.tableUsuarios;
    }


}
