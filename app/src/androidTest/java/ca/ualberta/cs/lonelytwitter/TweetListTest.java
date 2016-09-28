package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;
import java.util.List;

/**
 * Created by ehsueh on 9/27/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    public TweetListTest(){
        super(LonelyTwitterActivity.class);

    }

    public void testAddTweet()
    {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");

        assertFalse(list.IsInList(tweet));
        list.add(tweet);
        assertTrue(list.IsInList(tweet));
    }

    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet b = new NormalTweet("Hello");
        Tweet a = new NormalTweet("Hello");

        list.add(a);
        assertTrue(list.SameMessage(b));


    }

    public void testGetTweet(){
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello");
        Tweet b = new NormalTweet("Hi!");
        Tweet c = new NormalTweet("Pie");

        list.add(a);
        list.add(b);
        list.add(c);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
        assertEquals(c, list.getTweet(2));
    }

    public void testRemoveTweet(){
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello");
        list.add(a);
        assertTrue(list.hasTweet(a));

        list.delete(a);
        assertFalse(list.hasTweet(a));
    }

    public void testGetCount(){
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hi");
        Tweet b = new NormalTweet("Hello");
        Tweet c = new NormalTweet("Hey");

        list.add(a);
        list.add(b);
        list.add(c);

        assertTrue(list.getCount(3));

    }

    public void testGetTweets(){
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hi");
        Tweet b = new NormalTweet("Hello");
        Tweet c = new NormalTweet("seioth",new Date(0));
        list.add(c);
        list.add(a);
        list.add(b);
        List<Tweet> TimedList = list.getTweets();
        assertTrue(TimedList != null);
        assertTrue(TimedList.get(0)==c);


    }
}
