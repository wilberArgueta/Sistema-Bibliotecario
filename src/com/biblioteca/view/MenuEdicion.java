package com.biblioteca.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuEdicion extends JPanel {

    public JButton btnAgregar, btnActualizar, btnBorrar;

    public MenuEdicion() {
        iniciarBotones();
        initComponent();
    }


    public void initComponent() {

        FlowLayout fl = new FlowLayout();
        fl.setVgap(30);
        setBackground(new Color(200, 212, 209));
        setLayout(fl);
        fl.setAlignOnBaseline(true);
        setSize(130, 500);
        setBorder(new TitledBorder("Edicion"));
        setLocation(1080, 120);
        setVisible(true);


    }

    public void iniciarBotones() {
        List<JButton> btns = new ArrayList<>();
        btns.add(btnBorrar = new JButton("Borrar"));
        btns.add(btnAgregar = new JButton("Agregar"));
        btns.add(btnActualizar = new JButton("Actualizar"));


        for (JButton btn : btns) {
            //btn.setSize(100,90);
            add(btn);

        }
    }
}


