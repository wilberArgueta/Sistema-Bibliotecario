package com.biblioteca.view;

import com.biblioteca.controller.UsuarioModelTable;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.dao.DaoUsuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UsuariosView extends JPanel {
    private JTable tableUsuarios;
    private UsuarioModelTable usuarioModelTable;
    private JScrollPane jScrollPane;
    private DaoUsuario daoUsuario;

    public UsuariosView() {
        tabla();
        panel();
        initComponent();
    }

    public void initComponent() {

        setSize(1000, 500);
        setLocation(70, 120);
        setVisible(true);
        //setBackground(new Color(0xD40214));
        System.out.println("Creando el panel");
        setLayout(new FlowLayout());
        add(jScrollPane);
        repaint();
    }

    public void panel() {
        jScrollPane = new JScrollPane();
        //jScrollPane.setLayout(new FlowLayout());
        jScrollPane.setVisible(true);
        jScrollPane.setViewportView(tableUsuarios);
        System.out.println("Creando el scroll pane");


    }

    public void tabla() {
        daoUsuario = new DaoUsuario();
        usuarioModelTable = new UsuarioModelTable();

        List<Usuario> listaUser = daoUsuario.select("SELECT * FROM usuarios");
        for (Usuario usuario : listaUser) {
            usuarioModelTable.addUser(usuario);
        }
        tableUsuarios = new JTable(usuarioModelTable);
        tableUsuarios.setVisible(true);
        tableUsuarios.setFillsViewportHeight(true);


    }
}
