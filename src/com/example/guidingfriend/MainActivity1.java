package com.example.guidingfriend;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.Facebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity1 extends FacebookActivity implements OnClickListener  {
	Button fb_login_button;
	Facebook fb;
	AsyncFacebookRunner afbr;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String APP_ID = "1314688281880162";
		fb = new Facebook(APP_ID);
		afbr = new AsyncFacebookRunner(fb);
		fb_login_button = (Button)findViewById(R.id.fb_login_button);
		fb_login_button.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		loginToFb();
	}
	private void loginToFb() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, FacebookActivity.class);
	    String msg = "Open next Activity";
	    intent.putExtra("key",msg);
	    startActivity(intent);
	}
}