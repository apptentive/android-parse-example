package com.apptentive.parse.example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.apptentive.android.sdk.Apptentive;
import com.apptentive.android.sdk.Log;
import com.parse.ParsePushBroadcastReceiver;

public class ExampleParsePushBroadcastReceiver extends ParsePushBroadcastReceiver {
	@Override
	protected void onPushOpen(Context context, Intent intent) {
		super.onPushOpen(context, intent);

		Bundle extras = intent.getExtras();
		StringBuilder sb = new StringBuilder("Opened Push with the following Extras:\n");
		for (String key : extras.keySet()) {
			sb.append(String.format("  %s = %s\n", key, extras.get(key)));
		}
		Log.w(sb.toString());
		boolean forApptentive = Apptentive.setPendingPushNotification(context, intent);
		Log.e("Opened a push. Was it for Apptentive? %b", forApptentive);
	}
}
