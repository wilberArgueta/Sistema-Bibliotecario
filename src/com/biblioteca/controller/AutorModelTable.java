package com.biblioteca.controller;

import com.biblioteca.model.Autor;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.LinkedList;

public class AutorModelTable implements TableModel {
    private LinkedList datos = new LinkedList();
    private LinkedList suscriptores = new LinkedList();
    private String[] columnsName = {"ID", "Nombre", "Apellido", "Fecha Nacimiento", "Nacionalidad", "E-Mail"};
    private Object[] columnsClass = {Integer.class, String.class, String.class, String.class, String.class, String.class};


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
        return (Class<?>) columnsClass[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor autor = (Autor) datos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return autor.getCod_autor();
            case 1:
                return autor.getNombreAutor();
            case 2:
                return autor.getApellidoAutor();
            case 3:
                return autor.getF_nacimiento();
            case 4:
                return autor.getNacionalidad();
            case 5:
                return autor.getEmail();

        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Autor autor = (Autor) datos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                autor.setCod_autor((int) aValue);
            case 1:
                autor.setNombreAutor((String)aValue);
            case 2:
                autor.setApellidoAutor((String)aValue);
            case 3:
                autor.setF_nacimiento((String)aValue);
            case 4:
                autor.setNacionalidad((String)aValue);
            case 5:
                autor.setEmail((String)aValue);

        }

        addAutor(autor);


    }
    public Autor getValue(int fila){

        return (Autor) datos.get(fila);
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

    public void addAutor(Autor autor){
        datos.add(autor);
        TableModelEvent tableModelEvent = new TableModelEvent(this,this.getRowCount()-1,
                this.getRowCount()-1,TableModelEvent.ALL_COLUMNS,TableModelEvent.INSERT);


        for(int i = 0; i<suscriptores.size();i++) {
            ((TableModelListener) suscriptores.get(i)).tableChanged(tableModelEvent);
        }


    }
}
