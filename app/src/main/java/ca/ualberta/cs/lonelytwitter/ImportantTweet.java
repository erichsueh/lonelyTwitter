package ca.ualberta.cs.lonelytwitter;

/**
 * Created by watts1 on 9/13/16.
 *
 */
public class ImportantTweet extends Tweet {

    /**
     * Instantiates a new Important tweet.
     * this retruns a true expression when asked if "isImportant"
     * @param message the message
     */
    public ImportantTweet(String message){
        super(message);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}
