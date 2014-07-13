package com.example.quickpoll;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.parse.ParseObject;
import com.parse.ParseUser;

public class CreatePollActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_poll);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_poll, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_create_poll,
					container, false);
			return rootView;
		}
	}
	
	public void savePoll() {
		ParseUser user = ParseUser.getCurrentUser();
		
		ParseObject poll = new ParseObject("Poll");
		EditText choiceAEditText = (EditText) findViewById(R.id.choice_a);
	    String choiceA = choiceAEditText.getText().toString();
	    EditText choiceBEditText = (EditText) findViewById(R.id.choice_b);
	    String choiceB = choiceBEditText.getText().toString();
	    EditText choiceCEditText = (EditText) findViewById(R.id.choice_c);
	    String choiceC = choiceCEditText.getText().toString();
		
	    // TODO: create choice objects?
	    
	    poll.put("choiceA", choiceA);
		poll.put("choiceB", choiceB);
		poll.put("choiceC", choiceC);
		
		poll.put("creator", user);
		
		
		poll.saveInBackground();
		// intent to go to 'select friends' page
	}

}
