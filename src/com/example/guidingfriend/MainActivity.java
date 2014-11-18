package com.example.guidingfriend;

import java.io.IOException;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AppEventsLogger;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity implements OnClickListener{
	private static final String PERMISSION = "publish_actions";
	Button fb_login_button;
	Facebook fb;
	AsyncFacebookRunner afbr;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String APP_ID = "1314688281880162";
		fb = new Facebook(APP_ID);
		afbr = new AsyncFacebookRunner(fb);
		fb_login_button = (Button)findViewById(R.id.fb_login_button);
		fb_login_button.setOnClickListener(this);
		

	}

//	@SuppressWarnings("deprecation")
//	private void updateButtonStatus() {
//		// TODO Auto-generated method stub
//		if(fb.isSessionValid()){
//			fb_login_button.set
//		}else{
//			
//		}
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
//	public void loginFacebook(View view) {
//	    Intent intent = new Intent(this, FacebookActivity.class);
//	    String msg = "Open next Activity";
//	    intent.putExtra("key",msg);
//	    startActivity(intent);
//	    
//	}
	
	@Override
	protected void onResume() {
	  super.onResume();

	  // Logs 'install' and 'app activate' App Events.
	  AppEventsLogger.activateApp(this);
	}

	@Override
	protected void onPause() {
	  super.onPause();

	  // Logs 'app deactivate' App Event.
	  AppEventsLogger.deactivateApp(this);
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

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v){
		final SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
		// TODO Auto-generated method stub
		
		if(fb.isSessionValid()){
			try {
				fb.logout(getBaseContext());
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			fb.authorize(MainActivity.this, new String[] {"email"}, new DialogListener(){

				@Override
				public void onComplete(Bundle values) {
					// TODO Auto-generated method stub
					SharedPreferences.Editor editor = mPrefs.edit();
                    editor.putString("access_token", fb.getAccessToken());
                    editor.putLong("access_expires", fb.getAccessExpires());
                    editor.commit();
				}

				@Override
				public void onFacebookError(FacebookError e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onError(DialogError e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCancel() {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this,"onCancel",Toast.LENGTH_SHORT).show();
				}
				
			});
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	 public void onActivityResult(int requestCode, int resultCode,Intent data) {
	 super.onActivityResult(requestCode, resultCode, data);
	 fb.authorizeCallback(requestCode, resultCode, data);
	 Intent intent = new Intent(this, SearchActivity.class);
	 String msg = "Open search Activity";
	 intent.putExtra("search",msg);
	 startActivity(intent);
	 }
}
