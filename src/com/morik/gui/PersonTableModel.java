package com.morik.gui;

import com.morik.db.bean.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Morik on 08.03.2015.
 */
public class PersonTableModel extends AbstractTableModel {
    final private static String[] COLUMNS = {"Id", "FName", "LName"};
    private List<Person> data;

    public PersonTableModel(List<Person> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNS[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return person.getId();
            case 1:
                return person.getfName();
            case 2:
                return person.getlName();
            default:
                return "UNKNOWN";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex > 0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Person person = data.get(rowIndex);
        switch (columnIndex) {
            case 1:
                person.setfName(aValue.toString());
            case 2:
                person.setlName(aValue.toString());
        }
    }
}
