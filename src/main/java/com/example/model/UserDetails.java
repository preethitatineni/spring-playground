package com.example.model;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

/**
 * Created by trainer6 on 5/1/17.
 */
public class UserDetails {

    @JsonView(Views.DetailView.class)
    private int userId;

    @JsonView(Views.BaseView.class)
    private String user;

    @JsonView(Views.DetailView.class)
    private String email;

    @JsonView(Views.BaseView.class)
    private Date date;

    @JsonView(Views.BaseView.class)
    private String statusText;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
}
