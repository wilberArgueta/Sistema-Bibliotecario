package com.biblioteca.view;

import com.biblioteca.view.Barra.BarraMenu;

import javax.swing.*;
import java.awt.*;


public class PantallaPrincipal extends JFrame {


    public PantallaPrincipal() {
        initComponent();
    }

    private void initComponent() {
        BarraMenu bm = new BarraMenu();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setLayout(null);
        setSize(toolkit.getScreenSize().width - 100, toolkit.getScreenSize().height - 50);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        getContentPane().add(bm);

    }


}
