package com.example.notification;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.notification.R.drawable.ic_launcher_foreground;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
   //public int notificationID=001;
    public static final String channelid="channelid1";
 //   public static final String channelname="channel 1";
    //NotificationCompat.Builder mBuilder;
   // NotificationManager mNotificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @SuppressLint("ServiceCast")
    public void text(View v)
    {

         createchannel();
         NotificationCompat.Builder notification =
                new NotificationCompat.Builder(this,channelid)
                        .setSmallIcon(ic_launcher_foreground)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(101, notification.build());
    }
  public void picnotification(View v)
  {
      createchannel();
      NotificationCompat.BigPictureStyle bigPictureStyle=new NotificationCompat.BigPictureStyle();
      bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.burger));
      NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
      NotificationCompat.Builder notification =
              new NotificationCompat.Builder(this,channelid)
                      .setSmallIcon(ic_launcher_foreground)
                      .setContentTitle("My notification")
                      .setContentText("Hello World!")
              .setStyle(bigPictureStyle);
      notificationManager.notify(102, notification.build());

  }
    public void notification(View v)
    {
        createchannel();
      //  Bitmap icon1= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        NotificationCompat.BigTextStyle bigtext=new NotificationCompat.BigTextStyle();
        bigtext.bigText("hello world");
        bigtext.setBigContentTitle("TEXT NOTIFICATION");
        bigtext.setSummaryText("by:-ANDROID");
        NotificationCompat.Builder notification =
                new NotificationCompat.Builder(this,channelid)
                        .setSmallIcon(ic_launcher_foreground)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_foreground))
         .setStyle(bigtext);
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(102, notification.build());


    }
    @SuppressLint("ServiceCast")
    public void createchannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "personal notification";
            String description = "INCLUDE ALL THE PERSONAL NOTIFICATIONS";

            NotificationChannel channel1 = new NotificationChannel(channelid, name, NotificationManager.IMPORTANCE_DEFAULT);
            channel1.setDescription(description);
            channel1.enableLights(true);

            channel1.enableVibration(true);
            channel1.setLightColor(R.color.colorPrimary);
            channel1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel1);
        }

    }

  }
