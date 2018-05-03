package com.biblioteca.controller;

import com.biblioteca.model.Usuario;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.LinkedList;

public class UsuarioModelTable implements TableModel {

    private LinkedList suscriptores = new LinkedList();
    private LinkedList datos = new LinkedList();
    private String[] columnsName = {"ID", "Nombre", "Apellido", "Fecha Nacimiento", "Direccion", "Telefono", "Email"};
    private Object[] columsClass = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class};


    @Override
    public int getRowCount() {

        return datos.size();
    }

    @Override
    public int getColumnCount() {

        return columnsName.length;
    }

    @Override
    public String getColumnName(int columnIndex) {

        return columnsName[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        return (Class<?>) columsClass[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = (Usuario) datos.get(rowIndex);

        switch (columnIndex) {

            case 0:
                return usuario.getCod_usuario();
            case 1:
                return usuario.getNombre();
            case 2:
                return usuario.getApellido();
            case 3:
                return usuario.getF_nacimiento();
            case 4:
                return usuario.getDireccion();
            case 5:
                return usuario.getTelefono();
            case 6:
                return usuario.getEmail();


        }


        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Usuario usuario = (Usuario) datos.get(rowIndex);

        switch (columnIndex) {

            case 0:
               usuario.setCod_usuario((int)aValue);
            case 1:
                 usuario.setNombre((String) aValue);
            case 2:
                 usuario.setApellido((String) aValue);
            case 3:
                 usuario.setF_nacimiento((String) aValue);
            case 4:
                 usuario.setDireccion((String) aValue);
            case 5:
                 usuario.setTelefono((String) aValue);
            case 6:
                 usuario.setEmail((String) aValue);
        }

        addUser(usuario);

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        suscriptores.add(l);

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        suscriptores.remove(l);

    }

    public void addUser(Usuario u) {
        System.out.println("Agregando Usuario");
        datos.add(u);
        TableModelEvent tme = new TableModelEvent(this, this.getRowCount() - 1,
                this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (int i = 0; i < suscriptores.size(); i++) {
            ((TableModelListener)suscriptores.get(i)).tableChanged(tme);;
        }

    }
}
