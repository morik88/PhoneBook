package com.morik.gui;

import com.morik.db.bean.Contact;
import com.morik.db.bean.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Morik on 08.03.2015.
 */
public class ContactForm extends JFrame{

    private JTable table;

    public ContactForm(){
        setSize(640, 480);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public void fillData(java.util.List<Contact> list) {
        table.setModel(new ContactTableModel(list));
    }
}
