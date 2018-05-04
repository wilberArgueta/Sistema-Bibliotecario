package com.biblioteca.controller;

import com.biblioteca.model.Libro_Publicacion;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.LinkedList;

public class LibroModelTable implements TableModel {
    private LinkedList datos = new LinkedList();
    private LinkedList suscriptores = new LinkedList();
    private String columnsName[] = {"Libro", "Autor", "Fecha Publicacion", "Editorial"};

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
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Libro_Publicacion libro = (Libro_Publicacion) datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return libro.getTitulo();
            case 1:
                return libro.getNombreAutor();
            case 2:
                return libro.getfPublicacion();
            case 3:
                return libro.getNombreEditorial();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Libro_Publicacion libro = (Libro_Publicacion) datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                libro.setTitulo((String)aValue);
            case 1:
                libro.setNombreAutor((String)aValue);
            case 2:
                libro.setfPublicacion((String)aValue);
            case 3:
                libro.setNombreEditorial((String)aValue);
        }

        addLibro(libro);


    }
    public Libro_Publicacion getValue(int fila){

        return (Libro_Publicacion)datos.get(fila);
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

    public void addLibro(Libro_Publicacion libro_publicacion) {
        datos.add(libro_publicacion);

        TableModelEvent tableModelEvent = new TableModelEvent(this, this.getRowCount() - 1,
                this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);

        for (int i = 0; i < suscriptores.size(); i++) {
            ((TableModelListener) suscriptores.get(i)).tableChanged(tableModelEvent);
        }


    }
}
