package com.example.yuzelli.android5xspeciality;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private static int NOTIFICATION_ID_BASIC = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                show1();
                break;
            case R.id.btn2:
                show2();
                break;
            case R.id.btn3:
                show3();
                break;
            case R.id.btn4:
                show4();
                break;
            default:
                break;
        }
    }


    private void show1() {
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.timg1));
        builder.setContentTitle("基本的通知");
        builder.setContentText("通知信息ssss");
        builder.setSubText("lalalala");
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID_BASIC, builder.build());
    }

    private void show2() {
        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notrification);
        contentView.setTextViewText(R.id.textview, "show me when collapased");

        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sina.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.timg1));

        Notification notific = builder.build();
        notific.contentView = contentView;
        RemoteViews expandView = new RemoteViews(getPackageName(), R.layout.notrification_expand);

        notific.bigContentView = expandView;
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID_BASIC, notific);
    }

    private void show3() {

        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Headsup Notification")
                .setContentText("I am a Headsup notification.")
                .setSubText("Heads-Up Notification on Android 5.0");

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClass(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        //通过setFullScreenIntent将一个Notification变成悬挂式Notification
        builder.setFullScreenIntent(pendingIntent, true);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(003, builder.build());
    }


    private void show4() {
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.timg1));
        builder.setContentTitle("基本的通知");
        builder.setContentText("通知信息ssss");
        builder.setSubText("lalalala");
//        builder.setVisibility(Notification.VISIBILITY_PRIVATE);  // 没有锁屏时候显示
        builder.setVisibility(Notification.VISIBILITY_PUBLIC);  // 任何时候显示
//        builder.setVisibility(Notification.VISIBILITY_SECRET);  // 在pin、password等安全锁和没有锁屏时候显示

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID_BASIC, builder.build());
    }
}
