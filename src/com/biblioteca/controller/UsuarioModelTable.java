package com.biblioteca.controller;

import com.biblioteca.model.Usuario;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.LinkedList;

public class UsuarioModelTable implements TableModel {

    private LinkedList suscriptores = new LinkedList();
    private LinkedList datos = new LinkedList();


    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        suscriptores.add(l);

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        suscriptores.remove(l);

    }

    public void addUser(Usuario u){
        datos.add(u);
        TableModelEvent tme = new TableModelEvent(this,this.getRowCount()-1,
                this.getRowCount()-1,TableModelEvent.ALL_COLUMNS,TableModelEvent.INSERT);
        for(int i = 0; i<suscriptores.size();i++){
            ((TableModelListener)suscriptores).tableChanged(tme);
        }

    }
}
