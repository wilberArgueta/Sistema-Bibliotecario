package com.biblioteca.controller;

import com.biblioteca.model.Editorial;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.LinkedList;

public class EditorialModelTable implements TableModel {
    private LinkedList datos = new LinkedList();
    private LinkedList suscriptores = new LinkedList();
    private String [] columnsName = {"ID","Nombre","Direccion","Telefono","E-Mail"};
    private Object [] columsClass ={Integer.class,String.class,String.class,String.class,String.class};

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
        Editorial editorial = (Editorial)datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return editorial.getCod_editorial();
            case 1:
                return editorial.getNombreEditorial();
            case 2:
                return editorial.getDireccion();
            case 3:
                return editorial.getTelefono();
            case 4:
                return editorial.getEmail();

        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Editorial editorial = (Editorial)datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                 editorial.setCod_editorial((int) aValue);
            case 1:
                 editorial.setNombreEditorial((String)aValue);
            case 2:
                 editorial.setDireccion((String)aValue);
            case 3:
                 editorial.setTelefono((String)aValue);
            case 4:
                 editorial.setEmail((String)aValue);

        }
        addEditorial(editorial);

    }
    public Editorial getValue(int fila){

        return (Editorial) datos.get(fila);
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
    public void addTableModelListener(TableModelListener l) {
        suscriptores.add(l);

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        suscriptores.remove(l);

    }

    public void addEditorial(Editorial editorial) {
        System.out.println("Agregando Usuario");
        datos.add(editorial);
        TableModelEvent tme = new TableModelEvent(this, this.getRowCount() - 1,
                this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (int i = 0; i < suscriptores.size(); i++) {
            ((TableModelListener)suscriptores.get(i)).tableChanged(tme);;
        }

    }
}
