package com.morik.gui;

import com.morik.db.bean.Person;
import com.morik.service.PhoneBookService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Morik on 04.03.2015.
 */
public class PersonsForm extends JFrame {
    private java.util.List<Person> persons;
    private JTable table;

    public PersonsForm() {
        setSize(640, 480);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        table = new JTable();
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        JScrollPane scrollPane = new JScrollPane(table);

//        scrollPane.setPreferredSize(new Dimension(100, 100)); // задаем принудительно размер компоненты

        JButton btnSaveData = new JButton("SAVE");

        btnSaveData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PhoneBookService.getInstance().savePersonList(persons);
            }
        });

        add(btnSaveData);
        add(scrollPane);
    }

    public void fillData(java.util.List<Person> persons) {
        this.persons = persons;
        table.setModel(new PersonTableModel(persons));
    }
}
