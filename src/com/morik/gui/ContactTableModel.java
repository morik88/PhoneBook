package com.morik.gui;

import com.morik.db.bean.Contact;
import com.morik.db.bean.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Morik on 08.03.2015.
 */
public class ContactTableModel extends AbstractTableModel {
    final private static String[] COLUMNS = {"Id", "holder_id", "owner_id" , "phone"};
    private List<Contact> data;

    public ContactTableModel(List<Contact> data) {
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
        Contact contact = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return contact.getId();
            case 1:
                return contact.getHolderId();
            case 2:
                return contact.getOwnerId();
            case 3:
                return contact.getNumber();
            default:
                return "UNKNOWN";
        }
    }
}
