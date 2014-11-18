package com.example.guidingfriend;

import android.support.v7.app.ActionBarActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SearchActivity extends ActionBarActivity implements OnClickListener {
	EditText text_search, text_nearby;
	ImageButton search_button, nearby_button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		text_search = (EditText)findViewById(R.id.text_search);
		text_nearby = (EditText)findViewById(R.id.text_nearby);
		search_button = (ImageButton)findViewById(R.id.search_button);
		nearby_button = (ImageButton)findViewById(R.id.nearby_button);
		search_button.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String text_from_search = text_search.getText().toString();
		Toast.makeText(SearchActivity.this,text_from_search,Toast.LENGTH_SHORT).show();
		
		
		
//		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
//      pref.edit().putString("autoSave", text_search.getText().toString()).commit();
//		text_search=;
	}
}
