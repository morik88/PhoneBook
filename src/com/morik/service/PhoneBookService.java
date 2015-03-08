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
        personDAO = new PersonDAO();
        contactDAO = new ContactDAO();
    }

    public List<Person> getAllPerson(){
        return personDAO.loadAll();
    }

    public Person getPerson(long id){
        return personDAO.load(id);
    }

    public void deletePerson (long id){
        personDAO.delete(id);
    }

    public void updatePerson (Person person){
        personDAO.update(person);
    }

    public void insertPerson (Person person){
        personDAO.insert(person);
    }



    public List<Contact> getAllContact() {
        return contactDAO.loadAll();
    }

    public List<Contact> getContactsByPerson(long holderId) {
        return contactDAO.loadHolderContacts(holderId);
    }

    public List<Contact> getOwnContacts(long id) {
        return contactDAO.loadOwnContacts(id);
    }

    public Contact getContact(long id){
        return contactDAO.load(id);
    }

    public void deleteContact(long id){
        contactDAO.delete(id);
    }

    public void updateContact(Contact contact){
        contactDAO.update(contact);
    }

    public void insertContact(Contact contact){
        contactDAO.insert(contact);
    }
}
