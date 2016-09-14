package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ehsueh on 9/13/16.
 */
public abstract class Tweet {
    private String message;
    private Date date;
    private ArrayList<Mood> MoodList = new ArrayList<Mood>();


    public Tweet(String message)
    {
        this.message = message;
    }


    public Tweet(String message, Date date)
    {
        this.message = message;
        this.date = date;

    }
    public void addMoods(Date date)
    {
        SadMood newSadMood = new SadMood(date);
        MoodList.add(newSadMood);
        HappyMood newHappyMood = new HappyMood(date);
        MoodList.add(newHappyMood);
    }

    public ArrayList<ca.ualberta.cs.lonelytwitter.Mood> getMoodList() {
        return MoodList;
    }


    public abstract Boolean isImportant();


    public void setMessage(String message) throws TweetTooLongException {
        if (message.length()>140)
        {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }


    public void setDate(Date date)
    {
        this.date = date;
    }



    public String getMessage()
    {
        return message;
    }

    public Date getDate()
    {
        return date;
    }



}
