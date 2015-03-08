package com.morik.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Morik on 04.03.2015.
 */
public class ShowAreaGUI extends JFrame{


    public JTextArea textArea;

    public ShowAreaGUI(){

        setSize(410, 420);
        setLayout(new FlowLayout());
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        textArea = new JTextArea(20, 35);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JButton btnOk = new JButton("Ok");


        add(scrollPane);
        add(btnOk);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
