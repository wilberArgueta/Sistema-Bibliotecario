package com.biblioteca.view;

import javax.swing.*;
import java.awt.*;

public class PantallaPrincipal extends JFrame {

    private int flagView = 0;
    private Menu m;

    private LibrosView librosView;
    private UsuariosView usuariosView;
    private AlquilerView alquilerView;
    private AutorView autorView;
    private EditorialView editorialView;

    private JPanel[] paneles = new JPanel[6];

    public PantallaPrincipal() {

        initComponent();
    }

    private void initComponent() {
        m = new Menu();
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

        repaint();

    }

    private void initActionButtons() {
        m.btnLibros.addActionListener((e) -> {
            if (flagView != 0) {
                remove(paneles[flagView]);
            }
            this.add(librosView);

            repaint();
            flagView = 1;

        });
        m.btnUsuario.addActionListener((e) -> {
            if (flagView != 0) {
                remove(paneles[flagView]);
            }
            getContentPane().add(usuariosView);
            repaint();
            flagView = 2;
        });
        m.btnAlquiler.addActionListener((e) -> {
            if (flagView != 0) {
                remove(paneles[flagView]);
            }
            this.add(alquilerView);
            repaint();
            flagView = 3;

        });
        m.btnAutor.addActionListener((e) -> {
            if (flagView != 0) {
                remove(paneles[flagView]);
            }
            this.add(autorView);
            repaint();
            flagView = 4;

        });
        m.btnEditorial.addActionListener((e) -> {
            if (flagView != 0) {
                remove(paneles[flagView]);
            }
            this.add(editorialView);
            repaint();
            flagView = 5;
        });

    }

}
