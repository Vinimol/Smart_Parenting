package com.Parent;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Notificationdisplay extends Activity {

	private NotificationManager mNotificationManager;
	Notification notifyDetails;

	int SIMPLE_NOTFICATION_ID = 1111;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		// status bar notifications
		notifyDetails = new Notification(R.drawable.ic_launcher,
				"New Alert, Click Me!", System.currentTimeMillis());

		// on notification click
		CharSequence contentTitle = "Notification Details.........";

		CharSequence contentText = "Child has changed the sim";
		Intent notificationIntent = new Intent(this,
				ParentHomeActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
				notificationIntent, 0);

		notifyDetails.setLatestEventInfo(this, contentTitle, contentText,
				contentIntent);
	}

	public void addNotification(View view) {
		mNotificationManager.notify(SIMPLE_NOTFICATION_ID, notifyDetails);
	}

	public void deleteNotification(View view) {
		mNotificationManager.cancel(SIMPLE_NOTFICATION_ID);
	}
}