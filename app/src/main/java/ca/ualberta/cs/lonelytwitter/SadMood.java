package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ehsueh on 9/13/16.
 */
public class SadMood extends Mood
{
    public SadMood(Date date)
    {
        super(date);
    }

    @Override
    public String WhatMood()
    {
        return ":(";
    }
}
