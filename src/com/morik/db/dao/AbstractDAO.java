package com.morik.db.dao;

import com.morik.db.connection.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Morik on 01.03.2015.
 */
public class AbstractDAO {
    protected Connection connection;
    protected PreparedStatement load;
    protected PreparedStatement loadAll;
    protected PreparedStatement insert;
    protected PreparedStatement update;
    protected PreparedStatement delete;


    public AbstractDAO(){
        connection= DBManager.getInstance().getConnection();
    }
}
