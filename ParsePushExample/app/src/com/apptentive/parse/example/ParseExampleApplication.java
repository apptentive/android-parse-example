package com.apptentive.parse.example;

import android.app.Application;
import com.apptentive.android.sdk.Apptentive;
import com.apptentive.android.sdk.Log;
import com.parse.*;

/**
 * @author Sky Kelsey
 */
public class ParseExampleApplication extends Application {

	// Enter your Parse applicationId and clientKey here.
	private static final String PARSE_APPLICATION_ID = "";
	private static final String PARSE_CLIENT_KEY = "";

	@Override
	public void onCreate() {
		super.onCreate();
		Parse.initialize(this, PARSE_APPLICATION_ID, PARSE_CLIENT_KEY);

		ParsePush.subscribeInBackground("apptentive", new SaveCallback() {
			@Override
			public void done(ParseException e) {
				if (e == null) {
					String deviceToken = (String) ParseInstallation.getCurrentInstallation().get("deviceToken");
					Apptentive.addParsePushIntegration(getApplicationContext(), deviceToken);
					Log.e("SaveCallback.done(): deviceToken = %s", deviceToken);
				} else {
					Log.e("SaveCallback.done(): FAILED", e);
				}
			}
		});
	}
}
