package in.co.sdslabs.cognizance;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AlarmReceiver extends BroadcastReceiver {

	private static int NOTIFICATION_ID = 1;

	@SuppressWarnings("deprecation")
	@Override
	public void onReceive(Context context, Intent intent) {

		//NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		NotificationManager manger = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);

		Notification notification = new Notification(R.drawable.launcher_icon,
				"Combi Note", System.currentTimeMillis());
		PendingIntent contentIntent = PendingIntent.getActivity(context,
				NOTIFICATION_ID, new Intent(context, AlarmReceiver.class), 0);
		Bundle extras = intent.getExtras();
		String title = extras.getString("title");
		// here we get the title and description of our Notification
		//
		String note = extras.getString("note");
		notification.setLatestEventInfo(context, note, title, contentIntent);
		notification.flags = Notification.FLAG_INSISTENT;
		notification.defaults |= Notification.DEFAULT_SOUND;
		// here we set the default sound for our
		// notification

		// The PendingIntent to launch our activity if the user selects this
		// notification
		manger.notify(NOTIFICATION_ID++, notification);

	}

};
