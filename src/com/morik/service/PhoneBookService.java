package com.morik.service;

import com.morik.db.bean.Contact;
import com.morik.db.bean.Person;
import com.morik.db.dao.ContactDAO;
import com.morik.db.dao.PersonDAO;

import java.util.List;

/**
 * Created by Morik on 01.03.2015.
 */
public class PhoneBookService {
    private static PhoneBookService instance;
    private PersonDAO personDAO;
    private ContactDAO contactDAO;

    public static PhoneBookService getInstance() {
        if (instance == null) {
            instance = new PhoneBookService();
        }
        return instance;
    }

    public PhoneBookService() {
        personDAO = new PersonDAO("person");
        contactDAO = new ContactDAO("contact");
    }

    public List<Person> getAllPerson() {
        return personDAO.loadAll();
    }

    public Person getPerson(long id) {
        return personDAO.load(id);
    }

    public void savePerson(Person person) {
        personDAO.save(person);
    }

    public void savePersonList(List<Person> personList) {
        for (Person person : personList) {
            System.out.printf("BIZON savePersonList person: " + personList);
            savePerson(person);
        }
    }

    public void deletePerson(long id) {
        personDAO.delete(id);
    }

//    public void updatePerson(Person person) {
//        personDAO.update(person);
//    }
//
//    public void insertPerson(Person person) {
//        personDAO.insert(person);
//    }


    public List<Contact> getAllContact() {
        return contactDAO.loadAll();
    }

    public List<Contact> getContactsByPerson(long holderId) {
        return contactDAO.loadHolderContacts(holderId);
    }

    public List<Contact> getOwnContacts(long id) {
        return contactDAO.loadOwnContacts(id);
    }

    public Contact getContact(long id) {
        return contactDAO.load(id);
    }

    public void deleteContact(long id) {
        contactDAO.delete(id);
    }

    public void saveContact(Contact contact) {
        contactDAO.save(contact);
    }

//    public void updateContact(Contact contact) {
//        contactDAO.update(contact);
//    }
//
//    public void insertContact(Contact contact) {
//        contactDAO.insert(contact);
//    }
}
