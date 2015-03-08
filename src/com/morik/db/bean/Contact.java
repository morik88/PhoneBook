package com.morik.db.bean;

/**
 * Created by Morik on 01.03.2015.
 */
public class Contact {
    private long id;
    private long holderId;
    private long ownerId;
    private String number;

    public Contact() {
    }

    public Contact(long holderId, long ownerId, String number) {
        this.holderId = holderId;
        this.ownerId = ownerId;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHolderId() {
        return holderId;
    }

    public void setHolderId(long holderId) {
        this.holderId = holderId;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", holderId=" + holderId +
                ", ownerId=" + ownerId +
                ", number='" + number + '\'' +
                "}\n";
    }
}
