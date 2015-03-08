package com.morik.main;

import com.morik.db.bean.Person;
import com.morik.gui.PhoneBookGUI;
import com.morik.service.PhoneBookService;

/**
 * Created by Morik on 01.03.2015.
 */
public class Main {
    public static void main(String[] args) {
        PhoneBookService phoneBookService=PhoneBookService.getInstance();

        PhoneBookGUI phoneBookGUI = new PhoneBookGUI();
        phoneBookGUI.setVisible(true);
//        List<Person> personList = phoneBookService.getAllPerson();
//        System.out.println(personList);

//        System.out.println(phoneBookService.getPerson(1L));

        Person person = new Person("Jesica","Alba");
        person.setId(8);

//        phoneBookService.insertPerson(person);
//        System.out.println(phoneBookService.getAllPerson());

//        phoneBookService.updatePerson(person);
//        System.out.println(phoneBookService.getAllPerson());

//        phoneBookService.deletePerson(8);
//        System.out.println(phoneBookService.getAllPerson());



//        Contact contact = new Contact(6,1,"0976560809");
//        contact.setId(10);
//
//        System.out.println(phoneBookService.getContact(1));
//
//        System.out.println(phoneBookService.getAllContact());
//
//        phoneBookService.insertContact(contact);
//        System.out.println(phoneBookService.getAllContact());
//
//        contact = new Contact(6,2,"0637456593");
//        contact.setId(11);
//        phoneBookService.updateContact(contact);
//        System.out.println(phoneBookService.getAllContact());

//        phoneBookService.deleteContact(10);
//        System.out.println(phoneBookService.getAllContact());



//        System.out.println(phoneBookService.getContactsByPerson(1));
//        System.out.println(phoneBookService.getOwnContacts(1));

    }
}
