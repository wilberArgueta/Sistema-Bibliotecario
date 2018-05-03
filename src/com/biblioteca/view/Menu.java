package com.biblioteca.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Menu extends JPanel {
   public JButton btnLibros, btnAutor, btnAlquiler,
            btnEditorial, btnUsuario;

    public Menu() {

        initComponent();
        iniciarBotones();
        repaint();

    }

    public void initComponent() {

        FlowLayout fl = new FlowLayout();
        fl.setVgap(30);
        setBackground(new Color(167, 164, 164));
        setLayout(fl);
        fl.setAlignOnBaseline(true);
        setSize(500, 80);
        setBorder(new TitledBorder("Opciones de Menu"));
        setLocation(100, 30);
        setVisible(true);


    }

    public void iniciarBotones() {
        List<JButton> btns = new ArrayList<>();
        btns.add(btnLibros = new JButton("Libros"));
        btns.add(btnAutor = new JButton("Autor"));
        btns.add(btnAlquiler = new JButton("Alquiler"));
        btns.add(btnEditorial = new JButton("Editorial"));
        btns.add( btnUsuario = new JButton("Usuario"));

        for (JButton btn: btns){
            //btn.setSize(100,90);
            add(btn);

        }
    }
}
