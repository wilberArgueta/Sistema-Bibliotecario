/*
 * Created by JFormDesigner on Fri May 04 15:37:09 CST 2018
 */

package com.biblioteca.view.form;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class AlquilerForm extends JPanel {
    public AlquilerForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Wilber Argueta
        label1 = new JLabel();
        textFieldNombre = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        comboBoxLibros = new JComboBox();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(null);

        //---- label1 ----
        label1.setText("Nombre :");
        add(label1);
        label1.setBounds(new Rectangle(new Point(50, 50), label1.getPreferredSize()));
        add(textFieldNombre);
        textFieldNombre.setBounds(130, 45, 190, textFieldNombre.getPreferredSize().height);

        //---- label2 ----
        label2.setText(".Seleccione un Libro:");
        add(label2);
        label2.setBounds(new Rectangle(new Point(25, 110), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Alquiler de Libros");
        add(label3);
        label3.setBounds(new Rectangle(new Point(175, 10), label3.getPreferredSize()));
        add(comboBoxLibros);
        comboBoxLibros.setBounds(175, 105, 150, comboBoxLibros.getPreferredSize().height);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Wilber Argueta
    private JLabel label1;
    private JTextField textFieldNombre;
    private JLabel label2;
    private JLabel label3;
    private JComboBox comboBoxLibros;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
