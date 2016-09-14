package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ehsueh on 9/13/16.
 */
public abstract class Mood
{
    public abstract String WhatMood();

    private Date date;

    public Mood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
