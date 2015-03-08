package com.morik.db.bean;

/**
 * Created by Morik on 01.03.2015.
 */
public class Person {
    private long id;
    private String fName;
    private String lName;

    public Person() {
    }

    public Person(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                "}\n";
    }
}
