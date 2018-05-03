package com.biblioteca.view.Barra;

import javax.swing.*;


public class BarraMenu  extends JMenuBar {
    private JMenu autor,libro, editorial, usuario, alquiler;
    private JMenuItem mostrar;

    public BarraMenu() {
        initComponent();
    }

    private void initComponent(){

        this.setSize(600,50);
        this.add(initMenuItems());
        this.add(libro);
        this.setLocation(0,0);

        this.setVisible(true);


    }

    private JMenu initMenuItems(){
        autor = new JMenu("Autores");
        libro = new JMenu("Libros");
        mostrar = new JMenuItem("Mostar");
        mostrar.addActionListener((e)->JOptionPane.showMessageDialog(null,"Hola"));
        libro.add(mostrar);
        autor.add(mostrar);

        return autor;
    }



}
