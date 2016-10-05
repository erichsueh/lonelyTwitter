package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This constuctor makses a normalTweet witha something parameter
 *
 * message is a paramter that is the given string for th tweet. if it is set to empty string  then it will be replaced by ...
 */
public class NormalTweet extends Tweet implements Tweetable {

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     */
    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public NormalTweet(String message, Date date) {
        super(message, date);
    }
}