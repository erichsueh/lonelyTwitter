package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the tweet list class
 * It takes all the tweets and put it into a list
 * it has all the setters and getters as well as get size to return the size of it
 */
public class TweetList {
    /**
     * The Tweets.
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Add.
     *
     * @param tweet the tweet
     */
    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    /**
     * Has tweet boolean.
     *
     * @param tweet the tweet
     * @return the boolean
     */
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    /**
     * Gets tweet.
     *
     * @param i the
     * @return the tweet
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Delete.
     *
     * @param a the a
     */
    public void delete(Tweet a) {
        tweets.remove(a);
    }

    /**
     * Gets count.
     *
     * @param i the
     * @return the count
     */
    public boolean getCount(int i) {
        return tweets.size()== i;
    }

    /**
     * Is in list boolean.
     *
     * @param tweet the tweet
     * @return the boolean
     */
    public boolean IsInList(Tweet tweet){
        return tweets.contains(tweet);

    }


    /**
     * Get tweets list.
     *
     * @return the list
     */
    public List<Tweet> getTweets(){
        return tweets;
    }


    /**
     * Greaterdate boolean.
     *
     * @param tweet the tweet
     * @return the boolean
     */
    public boolean greaterdate(Tweet tweet) {
        return tweet.getDate().getTime() > (tweets.get(0).getDate().getTime()) ;
    }

    /**
     * Same message boolean.
     *
     * @param b the b
     * @return the boolean
     */
    public boolean SameMessage(Tweet b) {

        return tweets.get(0).getMessage() == b.getMessage();

    }
}
