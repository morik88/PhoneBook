package com.morik.db.connection;

import java.sql.*;

/**
 * Created by Morik on 01.03.2015.
 */
public class DBManager {
    private static DBManager instance;
    private Connection connection;

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public DBManager() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
//            Setup the connection with the DB
//            connection = DriverManager.getConnection("jdbc:mysql://localhost/phone_book?"
//                    + "user=root&password=''");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/phone_book?"
                    + "user=root&password=");

//            Statement statement = connection.createStatement();
//            // Result set get the result of the SQL query
//            ResultSet resultSet = statement.executeQuery("select * from person");
//
//            while (resultSet.next()) {
//                long id = resultSet.getLong(1);
//                String fName = resultSet.getString(2);
//                String lName = resultSet.getString(3);
//                System.out.println("person: " + id + ", " + fName + ", " + lName);
//            }
        } catch (Exception ex) {
            System.out.println("Connection fail" + ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
