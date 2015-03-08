package com.morik.db.dao;

import com.morik.db.bean.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Morik on 01.03.2015.
 */
public class ContactDAO extends AbstractDAO{
    protected PreparedStatement loadHolderContacts;
    protected PreparedStatement loadOwnContacts;


    public ContactDAO() {
        super();

        try {
            loadAll = connection.prepareStatement("select * from contacts");
            loadHolderContacts = connection.prepareStatement("SELECT * FROM contacts WHERE holder_id=?");
            loadOwnContacts = connection.prepareStatement("SELECT  * FROM contacts WHERE holder_id=? AND owner_id=?");
            load = connection.prepareStatement("SELECT * FROM contacts WHERE id=?");
            delete = connection.prepareStatement("DELETE FROM contacts WHERE id=?");
            insert = connection.prepareStatement("INSERT INTO contacts (holder_id,owner_id, phone) VALUES (?,?,?)");
            update = connection.prepareStatement("UPDATE contacts SET holder_id=? , owner_id=? , phone=? WHERE id=?");
        } catch (SQLException ex) {
            System.out.println("ContactDAO init statement error: " + ex);
        }
    }

    private Contact read(ResultSet resultSet) {
        Contact contact = null;
        try {
            contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setHolderId(resultSet.getLong("holder_id"));
            contact.setOwnerId(resultSet.getLong("owner_id"));
            contact.setNumber(resultSet.getString("phone"));
        } catch (SQLException ex) {
            System.out.println("ContactDAO read result set error: " + ex);
        }
        return contact;
    }

    public List<Contact> loadAll() {
        List<Contact> contactList = new ArrayList<Contact>();
        try {
            ResultSet resultSet = loadAll.executeQuery();
            while (resultSet.next()) {
                Contact contact = read(resultSet);
                contactList.add(contact);
            }
            resultSet.close();
        } catch (SQLException ex) {
            System.out.println("ContactDAO loadAll error: " + ex);
        }
        return contactList;
    }

    public List<Contact> loadHolderContacts(long holderId) {
        List<Contact> contactList = new ArrayList<Contact>();
        try {
            loadHolderContacts.setLong(1, holderId);
            ResultSet resultSet = loadHolderContacts.executeQuery();
            while (resultSet.next()) {
                Contact contact = read(resultSet);
                contactList.add(contact);
            }
            resultSet.close();
        } catch (SQLException ex) {
            System.out.println("ContactDAO loadHolderContacts error: " + ex);
        }
        return contactList;
    }

    public List<Contact> loadOwnContacts(long id) {
        List<Contact> contactList = new ArrayList<Contact>();
        try {
            loadOwnContacts.setLong(1, id);
            loadOwnContacts.setLong(2, id);
            ResultSet resultSet = loadOwnContacts.executeQuery();
            while (resultSet.next()) {
                Contact contact = read(resultSet);
                contactList.add(contact);
            }
            resultSet.close();
        } catch (SQLException ex) {
            System.out.println("ContactDAO loadOwnContacts error: " + ex);
        }
        return contactList;
    }

    public Contact load(long id) {
        Contact contact = null;
        ResultSet resultSet = null;
        try {
            load.setLong(1, id);
            resultSet = load.executeQuery();
            if (resultSet.next()){
                contact = read(resultSet);
            }
            resultSet.close();
        } catch (SQLException ex) {
            System.out.println("ContactDAO load error: " + ex);
        }
        return contact;
    }

    public void delete(long id) {
        try {
            delete.setLong(1, id);
            delete.execute();
        } catch (SQLException ex) {
            System.out.println("ContactDAO delete error: " + ex);
        }
    }

    public void insert(Contact contact) {
        try {
            insert.setLong(1, contact.getHolderId());
            insert.setLong(2, contact.getOwnerId());
            insert.setString(3, contact.getNumber());
            insert.execute();
        } catch (SQLException ex) {
            System.out.println("PersonDAO insert error: " + ex);
        }
    }

    public void update(Contact contact) {
        try {
            update.setLong(1, contact.getHolderId());
            update.setLong(2, contact.getOwnerId());
            update.setString(3, contact.getNumber());
            update.setLong(4, contact.getId());
            update.execute();
        } catch (SQLException ex) {
            System.out.println("PersonDAO update error: " + ex);
        }
    }
}
