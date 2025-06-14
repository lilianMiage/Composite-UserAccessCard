package fr.miage.lroux.compositeuseraccesscard.dto;


import java.io.Serializable;

/**
 * Represents an access card with an ID, password, and associated user ID.
 * This class is used to manage access cards in the composite user access card system.
 */
public class AccessCard implements Serializable {
    private long accessCardId;

    private String password;

    private long userId;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setAccessCardId(long accessCardId) {
        this.accessCardId = accessCardId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getAccessCardId() {
        return accessCardId;
    }

    public String getPassword() {
        return password;
    }

    public AccessCard() {
    }

    public AccessCard(long accessCardId, String password, long userId) {
        this.accessCardId = accessCardId;
        this.password = password;
        this.userId = userId;
    }
}
