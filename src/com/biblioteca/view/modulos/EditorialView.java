package com.biblioteca.view.modulos;

import com.biblioteca.controller.EditorialModelTable;
import com.biblioteca.model.Editorial;
import com.biblioteca.repository.dao.DaoEditorial;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.List;

public class EditorialView extends JScrollPane {
    private JTable tableEditorial;
    private EditorialModelTable editorialModelTable;
    public DaoEditorial daoEditorial;

    public EditorialView() {
        initComponent();
    }

    public void initComponent() {
        daoEditorial = new DaoEditorial();
        editorialModelTable = new EditorialModelTable();

        List<Editorial> listaUser = daoEditorial.select("SELECT * FROM editoriales");
        for (Editorial editorial : listaUser) {
            editorialModelTable.addEditorial(editorial);
        }

        tableEditorial = new JTable(editorialModelTable);
        tableEditorial.setVisible(true);
        tableEditorial.setFillsViewportHeight(true);
        setSize(1000, 500);
        setLocation(70, 120);
        setVisible(true);
        setBorder(new TitledBorder("Editoriales menu"));
        setViewportView(tableEditorial);

    }

    public EditorialModelTable getEditorialModelTable() {

        return this.editorialModelTable;
    }

    public JTable getTableEditorial() {
        return this.tableEditorial;
    }
}
