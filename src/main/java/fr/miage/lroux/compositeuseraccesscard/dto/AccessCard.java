package fr.miage.lroux.compositeuseraccesscard.dto;


import java.io.Serializable;

public class AccessCard implements Serializable {
    private long accessCardid;

    private String password;

    public void setAccessCardid(long accessCardid) {
        this.accessCardid = accessCardid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getAccessCardid() {
        return accessCardid;
    }

    public String getPassword() {
        return password;
    }

    public AccessCard() {
    }

    public AccessCard(long accessCardid, String password) {
        this.accessCardid = accessCardid;
        this.password = password;
    }
}
