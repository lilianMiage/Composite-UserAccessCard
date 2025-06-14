package fr.miage.lroux.compositeuseraccesscard.dto;

import java.io.Serializable;

/**
 * Represents a user with an ID, last name, and first name.
 * This class is used to manage user information in the composite user access card system.
 */
public class User implements Serializable {

    private long userId;

    /**
     *  User last name.
     */
    private String lastName;

    /**
     *  User first name.
     */
    private String firstName;

    public User() {
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getUserId() {
        return userId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public User(long userId, String lastName, String firstName) {
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
