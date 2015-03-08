package com.morik.db.dao;

import com.morik.db.bean.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Morik on 01.03.2015.
 */
public class PersonDAO extends AbstractDAO {
    public PersonDAO() {
        super();

        try {
            loadAll = connection.prepareStatement("select * from person");
            load = connection.prepareStatement("SELECT * FROM person WHERE id=?");
            delete = connection.prepareStatement("DELETE FROM person WHERE id=?");
            insert = connection.prepareStatement("INSERT INTO person (f_name,l_name) VALUES (?,?)");
            update = connection.prepareStatement("UPDATE person SET f_name=? , l_name=? WHERE id=?");
        } catch (SQLException ex) {
            System.out.println("PersonDAO init statement error: " + ex);
        }
    }

    private Person read(ResultSet resultSet) {
        Person person = null;
        try {
            person = new Person();
            person.setId(resultSet.getLong("id"));
            person.setfName(resultSet.getString("f_name"));
            person.setlName(resultSet.getString("l_name"));
        } catch (SQLException ex) {
            System.out.println("PersonDAO read result set error: " + ex);
        }
        return person;
    }

    public Person load(long id) {
        Person person = null;
        ResultSet resultSet = null;
        try {
            load.setLong(1, id);
            resultSet = load.executeQuery();
            if (resultSet.next()){
                person = read(resultSet);
            }
            resultSet.close();
        } catch (SQLException ex) {
            System.out.println("PersonDAO load error: " + ex);
        }
        return person;
    }

    public List<Person> loadAll() {
        List<Person> personList = new ArrayList<Person>();
        try {
            ResultSet resultSet = loadAll.executeQuery();
            while (resultSet.next()) {
                Person person = read(resultSet);
                personList.add(person);
            }
            resultSet.close();
        } catch (SQLException ex) {
            System.out.println("PersonDAO loadAll error: " + ex);
        }
        return personList;
    }

    public void delete(long id) {
        try {
            delete.setLong(1, id);
            delete.execute();
        } catch (SQLException ex) {
            System.out.println("PersonDAO delete error: " + ex);
        }
    }

    public void insert(Person person) {
        try {
            insert.setString(1, person.getfName());
            insert.setString(2, person.getlName());
            insert.execute();
        } catch (SQLException ex) {
            System.out.println("PersonDAO insert error: " + ex);
        }
    }

    public void update(Person person) {
        try {
            update.setString(1, person.getfName());
            update.setString(2, person.getlName());
            update.setLong(3, person.getId());
            update.execute();
        } catch (SQLException ex) {
            System.out.println("PersonDAO update error: " + ex);
        }
    }
}
