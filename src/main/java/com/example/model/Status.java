package com.example.model;

import java.util.Date;

/**
 * Created by trainer6 on 5/1/17.
 */
public class Status {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String text;
    private Date date;
}
