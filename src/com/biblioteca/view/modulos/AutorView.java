package com.biblioteca.view.modulos;

import com.biblioteca.controller.AutorModelTable;
import com.biblioteca.model.Autor;
import com.biblioteca.repository.dao.DaoAutor;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.List;

public class AutorView extends JScrollPane {
    private JTable tableAutor;
    private AutorModelTable autorModelTable;
    public DaoAutor daoAutor;

    public AutorView() {
        initComponent();
    }

    public void initComponent() {
        daoAutor = new DaoAutor();
        autorModelTable = new AutorModelTable();

        List<Autor> autorList = daoAutor.select("SELECT * FROM autores");

        for (Autor Autor : autorList) {
            autorModelTable.addAutor(Autor);
        }

        tableAutor = new JTable(autorModelTable);
        tableAutor.setVisible(true);
        tableAutor.setFillsViewportHeight(true);
        setSize(1000, 500);
        setLocation(70, 120);
        setVisible(true);
        setBorder(new TitledBorder("Autores menu"));
        setViewportView(tableAutor);

    }

    public AutorModelTable getAutorModelTable() {

        return this.autorModelTable;
    }

    public JTable getTableAutor() {
        return this.tableAutor;
    }
}
