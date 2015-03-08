package com.morik.db.dao;

import com.morik.db.bean.Entity;
import com.morik.db.bean.Person;
import com.morik.db.connection.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Created by Morik on 01.03.2015.
 */
public abstract class AbstractDAO<T extends Entity> {
    protected String tableName;
    protected Connection connection;
    protected PreparedStatement load;
    protected PreparedStatement loadAll;
    protected PreparedStatement insert;
    protected PreparedStatement update;
    protected PreparedStatement delete;

    protected PreparedStatement nextId;


    public AbstractDAO(String tableName) {
        this.tableName = tableName;
        connection = DBManager.getInstance().getConnection();

        try {
            nextId = connection.prepareStatement("select max(id) from " + tableName);
        } catch (SQLException ex) {
            System.out.println("AbstractDAO init statement error: " + ex);
        }
    }

    private long generateId() {
        ResultSet resultSet = null;
        long nextID = 0;
        try {
            resultSet = nextId.executeQuery();
            if (resultSet.next()) {
                nextID = resultSet.getLong(1);
            }
            resultSet.close();
        } catch (SQLException ex) {
            System.out.println("AbstractDAO generateId error: " + ex);
        }
        return nextID + 1;
    }

    protected abstract void prepareInsert(PreparedStatement insert, T object) throws SQLException;

    protected abstract void prepareUpdate(PreparedStatement update, T object) throws SQLException;

    public void save(T object) {
        try {
            prepareUpdate(update, object);
            int row = update.executeUpdate();

            if (row == 0) {
                prepareInsert(insert, object);
                long nextID = generateId();
                insert.executeUpdate();
                object.setId(nextID);
            }
        } catch (SQLException e) {
            System.out.println("AbstractDAO save error: " + e);
        }
    }
}
