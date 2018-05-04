package com.biblioteca.view.modulos;

import com.biblioteca.controller.AlquilerModelTable;
import com.biblioteca.model.Alquiler;
import com.biblioteca.repository.dao.DaoAlquiler;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.util.List;

public class AlquilerView extends JScrollPane {
    private JTable tableAlquiler;
    private AlquilerModelTable alquilerModelTable;
    public DaoAlquiler daoAlquiler;

    public AlquilerView() {
        initComponent();
    }

    public void initComponent() {
        daoAlquiler = new DaoAlquiler();
        alquilerModelTable = new AlquilerModelTable();

        List<Alquiler> alquilerList = daoAlquiler.select("SELECT tb_alquiler.id_alquiler,tb_alquiler.cod_libro," +
                "tb_alquiler.cod_usuario,usuarios.nombre, libros.titulo, tb_alquiler.f_adquirido," +
                " tb_alquiler.f_devolucion FROM `tb_alquiler` " +
                "INNER JOIN usuarios on usuarios.cod_usuario = tb_alquiler.cod_usuario" +
                " INNER JOIN libros on libros.cod_libro = libros.cod_libro ");
        for (Alquiler alquiler : alquilerList) {
            alquilerModelTable.addAutor(alquiler);
        }

        tableAlquiler = new JTable(alquilerModelTable);
        tableAlquiler.setVisible(true);
        tableAlquiler.setFillsViewportHeight(true);
        setSize(1000, 500);
        setLocation(70, 120);
        setVisible(true);
        setBorder(new TitledBorder("Alquiler menu"));
        setViewportView(tableAlquiler);

    }


    public AlquilerModelTable getAlquilerModelTable() {

        return this.alquilerModelTable;
    }

    public JTable getTableAlquiler() {
        return this.tableAlquiler;
    }
}
