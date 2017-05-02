package com.example.model;

import java.util.List;

/**
 * Created by trainer6 on 5/1/17.
 */
public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    private int id;
    private String username;
    private List<Email> emails;
}
