/*
 * Copyright (c) 2016 Team 20, COMPUT 301, University of Alberta, All Rights Reserved
 * You may use distrubite and copy all parts of this code under terms and conditions
 * of University of Alberta and the code of Student Behavior
 * You can find the copy of licence at htt://www.github.com/Team20/..
 * For further information, contatct me at abc@abc.ca
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * This is the main view class of Lonely Twitter Project. It handles all
 * user interactions as well as file manipulation<br>
 * <p/>
 * all the files are stored in the form of "json" Files stored in Emulator,
 * accessable from android device manager</br>
 * <br>
 * <gode>  psudocode sample><br>
 * open som efiles<br>
 * </code><br>
 *
 * @author Eric
 */
public class LonelyTwitterActivity extends Activity {


    /**
     * This is the file name that is being saved/loaded and contains all the tweets
     * @see #loadFromFile()
     * @see #saveInFile()
     */
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created.
	 * It initializes the two buttons the (Save button and the Clear button)
	 * the clear button deletes all of the
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet newTweet = new NormalTweet(text);

				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();

				saveInFile();

			}
		});

        clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                //code taken from http://stackoverflow.com/questions/17279519/removing-items-from-list-in-java
                Iterator<Tweet> i = tweetList.iterator();
                while (i.hasNext()) {
                    Object o = i.next();
                    i.remove();
                }
                adapter.notifyDataSetChanged();

                saveInFile();

            }
        });
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
//		String[] tweets = loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);

	}

    /**
     * This method loads the tweets from FILE_NAME (file.sav), and  ...
     * @throws FileNotFoundException
     * @exception RuntimeException
     */

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

            tweetList = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * this method saves the tweetlist into file.save
	 * @throws FileNotFoundException
	 * @exception RuntimeException
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList,out);
			out.flush();

			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}