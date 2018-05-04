package com.biblioteca.controller;

import com.biblioteca.model.Alquiler;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.LinkedList;

public class AlquilerModelTable implements TableModel {
    private LinkedList datos = new LinkedList();
    private LinkedList suscriptores = new LinkedList();
    private String[] columnName = {"Nombre", "Libro", "Fecha de Alquiler", "Fecha de Devolucion"};

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnName[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alquiler alquiler = (Alquiler) datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return alquiler.getNombreUsuario();
            case 1:
                return alquiler.getTitulo();
            case 2:
                return alquiler.getfAdquirido();
            case 3:
                return alquiler.getfDevolucion();
        }

        return null;
    }
    public Alquiler getValue(int fila){

        return (Alquiler)datos.get(fila);
    }
    public void borrar(int fila){
        datos.remove(fila);

        TableModelEvent tableModelEvent = new TableModelEvent(this,fila,fila,
                TableModelEvent.ALL_COLUMNS,TableModelEvent.DELETE);

        for(int i = 0; i>suscriptores.size();i++){
            ((TableModelListener)suscriptores.get(i)).tableChanged(tableModelEvent);
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Alquiler alquiler = (Alquiler) datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                alquiler.setNombreUsuario((String) aValue);
            case 1:
                alquiler.setTitulo((String) aValue);
            case 2:
                alquiler.setfAdquirido((String) aValue);
            case 3:
                alquiler.setfDevolucion((String) aValue);
        }




    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        suscriptores.add(l);

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        suscriptores.remove(l);

    }

    public void addAutor(Alquiler alquiler) {
        datos.add(alquiler);
        TableModelEvent tableModelEvent = new TableModelEvent(this, this.getRowCount() - 1,
                this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);


        for (int i = 0; i < suscriptores.size(); i++) {
            ((TableModelListener) suscriptores.get(i)).tableChanged(tableModelEvent);
        }


    }

}
