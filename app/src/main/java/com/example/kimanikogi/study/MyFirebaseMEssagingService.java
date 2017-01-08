package com.example.kimanikogi.study;

/**
 * Created by kimani kogi on 11/27/2016.
 */

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMEssagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        sendNotification(remoteMessage.getData().get("title"),remoteMessage.getData().get("body"));

       // Toast.makeText(this,  remoteMessage.getNotification().getBody(), Toast.LENGTH_SHORT).show();
        // TODO: Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());

    }
    private void sendNotification(String messageTitle,String messageBody) {
     //   String intentt=null;
        // Intent intent=new Intent(this, Extras.class);
     //  if(messageTitle.equals("software")) {
           Intent intent= new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

           PendingIntent pendingIntent = PendingIntent.getActivity(this,0 /* request code */, intent,PendingIntent.FLAG_UPDATE_CURRENT);

           long[] pattern = {500,500,500,500,500};

           Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

           NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                   .setSmallIcon(R.drawable.study)
                   .setContentTitle(messageTitle)
                   .setContentText(messageBody)
                   .setAutoCancel(true)
                   .setVibrate(pattern)
                   .setLights(Color.BLUE,1,1)
                   .setSound(defaultSoundUri)
                   .setContentIntent(pendingIntent);

           NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
           notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    //    }

    /*    switch(messageTitle) {
            case "software":
                intent= new Intent(this, Software.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case "oop":
                intent= new Intent(this, Oop.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case "web":
                intent= new Intent(this, webdevper.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case "data":
                intent= new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case "mis":
                intent= new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case "preservation":
                intent= new Intent(this, preservation.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case "media":
                intent= new Intent(this, Radio.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case "research":
                intent= new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case "timetable":
                intent= new Intent(this, Others.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case "quizes":
                intent= new Intent(this, Others.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                default:

                intent= new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        }*/

    }
}