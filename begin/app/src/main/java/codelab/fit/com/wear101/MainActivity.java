package codelab.fit.com.wear101;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    public void showSimpleNotification(final View button) {
        createSimpleNotification("Test", "Hi I'm a simple notification, you should be able to se mee on your watch!");
    }

    public void showSimpleNotificationWithAction(final View button) {
        // implement me :)
    }



    private void createSimpleNotification(final String title, final String content) {
        // An id for the notification to be showed, it should be unique.
        final int notificationId = 001;

        // Build intent for notification content
        final Intent viewIntent = new Intent(this, MainActivity.class);
        final PendingIntent viewPendingIntent = PendingIntent.getActivity(this, 0, viewIntent, 0);

        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(title)
                .setContentText(content)
                .setContentIntent(viewPendingIntent);

        // Get an instance of the NotificationManager service
        final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // Builds the notification and issues it with notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }


    private final String EXTRA_VOICE_REPLY = "extra_voice_reply";
}
