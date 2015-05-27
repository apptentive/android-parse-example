# Apptentive Parse Push Notification Example App

This example app is set up to receive push notifications through the Parse SDK. It is also set up to demonstrate how Apptentive can integrate with an app that is using Parse to receive push notifications.

Please refer to the [Parse push notification documentation](http://www.apptentive.com/docs/android/integration/#setting-the-parse-device-token) for an explanation of the Apptentive API used in this app.

# Setup

This app requires that you copy in your Parse Push Notification credentials, and your Apptentive API Key.

1. In `ParseExampleApplication.java`, provide your **Parse** **_Application ID_** and **_Client Key_**.
2. In `gradle.properties`, provide your **_Apptentive API Key_**. If you do not yet have one, create an account and an Android app at [https://be.apptentive.com](be.apptentive.com), then copy your API Key [here](https://be.apptentive.com/apps/current/settings/api)

# Running

In order to receive push notifications in this app, you will need to verify that push notifications are being sent from **Parse**, and then provide **Apptentive** with your **Parse** credentials.

1. Run the app. Verify that your logcat "SaveCallback.done(): deviceToken = <device_token>" at error log level. If you do not see this, you may need to restart your app, as Parse initialization can sometimes take a few seconds.
2. In your **Parse** dashboard, send a test push notification to your app. If your device does not receive a push notification, check your internet connection, and verify that you set your **Application ID** and **Client Key** in `ParseExampleApplication.java`,
3. Open the app and then click _**Show Message Center**_.
4. Send a message, and wait until it has been sent.
6. In your app's conversation view, respond to the message.
7. You should receive a push notification on your device.
8. Open the push notification by tapping it.
9. Verify that Apptentive's Message Center opens.