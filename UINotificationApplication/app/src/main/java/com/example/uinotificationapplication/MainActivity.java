package com.example.uinotificationapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;
    private TaskStackBuilder stackBuilder;
    private NotificationCompat.Builder builder;
    private PendingIntent pendingIntent;
    private final int notificationId = 999;
    private final String CHANNEL_ID = "CHANNEL_ID";
    private int numMsg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
    }

    public void onStartClick(View view) {
        builder = startNotification();
        displayNotification(builder);
    }

    public void onCancelClick(View view) {
        manager = getNotificationService();
        manager.cancel(notificationId);
    }

    public void onUpdateClick(View view) {
        builder = updateNotification();
        displayNotification(builder);
    }

    public void onMultipleCLick(View view) {
        builder = startMultiple();
        displayNotification(builder);
    }

    private void displayNotification(NotificationCompat.Builder builder) {

        Intent intent = new Intent(this, NotificationActivity.class);

        stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationActivity.class);
        stackBuilder.addNextIntent(intent);

        pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        manager = getNotificationService();
        manager.notify(notificationId, builder.build());
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private NotificationManager getNotificationService() {
        return (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    }

    private NotificationCompat.Builder startNotification() {
        builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("New Message");
        builder.setContentText("Notification: message received");
        builder.setTicker("Message Started");
        builder.setSmallIcon(R.drawable.ic_message);
        builder.setNumber(++numMsg);
        return builder;
    }

    private NotificationCompat.Builder updateNotification() {
        builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Update Message");
        builder.setContentText("Notification: message updated");
        builder.setTicker("Message Updated");
        builder.setSmallIcon(R.drawable.ic_message);
        builder.setNumber(++numMsg);
        return builder;
    }

    private NotificationCompat.Builder startMultiple() {
        builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Multiple Messages");
        builder.setContentText("Notification: multiple messages received");
        builder.setTicker("Multiple Messages");
        builder.setSmallIcon(R.drawable.ic_message);
        builder.setNumber(++numMsg);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        String[] events = {"Message 1", "Message 2", "Message 3"};
        inboxStyle.setBigContentTitle("Big Title detail: ");
        for (int i = 0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }
        builder.setStyle(inboxStyle);
        return builder;
    }

    public void onListeningClick(View view) {
        startActivity(new Intent(this, UIListeningActivity.class));
    }

    public void onViewDesignClick(View view) {
        startActivity(new Intent(this, ViewDesignActivity.class));
    }
}