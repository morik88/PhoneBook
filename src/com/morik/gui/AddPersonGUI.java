package com.morik.gui;

import com.morik.service.PhoneBookService;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Morik on 04.03.2015.
 */
public class AddPersonGUI extends JFrame{
    public AddPersonGUI(){
        PhoneBookService phoneBookService = PhoneBookService.getInstance();
        setSize(410, 420);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        JButton btnOk = new JButton("Ok");
        JTextField FName = new JTextField();
        JTextField LName = new JTextField();
    }
}
