package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehsueh on 9/27/16.
 */
public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();
    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public void delete(Tweet a) {
        tweets.remove(a);
    }

    public boolean getCount(int i) {
        return tweets.size()== i;
    }

    public boolean IsInList(Tweet tweet){
        return tweets.contains(tweet);

    }



    public List<Tweet> getTweets(){
        return tweets;
    }


    public boolean greaterdate(Tweet tweet) {
        return tweet.getDate().getTime() > (tweets.get(0).getDate().getTime()) ;
    }

    public boolean SameMessage(Tweet b) {

        return tweets.get(0).getMessage() == b.getMessage();

    }
}
