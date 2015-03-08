package com.morik.gui;

import com.morik.service.PhoneBookService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Morik on 02.03.2015.
 */
public class PhoneBookGUI extends JFrame {
    public PhoneBookGUI() {
        final PhoneBookService phoneBookService = new PhoneBookService();
        final ShowAreaGUI showAreaGUI = new ShowAreaGUI();
        final AddPersonGUI addPersonGUI = new AddPersonGUI();



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Phone Book");
        setSize(410, 500);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());


        JButton btnGetPerson = new JButton("Get Person");
        JButton btnGetAllPerson = new JButton("Get All Person");
        JButton btnGetAllContact = new JButton("Get All Contacts");
        JButton btnAddPerson = new JButton("Add Person");



        add(btnGetAllPerson);
        add(btnGetAllContact);
        add(btnGetPerson);
        add(btnAddPerson);


//        btnRefresh.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                textArea.setText(String.valueOf(phoneBookService.getAllContact()));
//            }
//        });

        btnGetPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long id = Long.parseLong(JOptionPane.showInputDialog("Kakoj Id Kurva???"));
                JOptionPane.showMessageDialog(null,"Na Kurva:\n"+phoneBookService.getPerson(id));
            }
        });

        btnGetAllPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAreaGUI.setVisible(true);
                showAreaGUI.textArea.setText(String.valueOf(phoneBookService.getAllPerson()));
            }
        });

        btnGetAllContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAreaGUI.setVisible(true);
                showAreaGUI.textArea.setText(String.valueOf(phoneBookService.getAllContact()));
            }
        });

        btnAddPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPersonGUI.setVisible(true);
            }
        });
    }

}
