package com.apptentive.parse.example;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import com.apptentive.android.sdk.Apptentive;
import com.apptentive.android.sdk.Log;

public class ParseExampleActivity extends Activity {
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Apptentive.onStart(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		Apptentive.onStop(this);
	}

	public void showMessageCenter(View view) {
		Apptentive.showMessageCenter(this);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			boolean ranApptentive = Apptentive.handleOpenedPushNotification(this);
			if (ranApptentive) {
				Log.e("Handled Apptentive push notification.");
			}
		}
	}
}
