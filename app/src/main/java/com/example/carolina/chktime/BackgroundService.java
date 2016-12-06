package com.example.carolina.chktime;


import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.util.List;

public class BackgroundService extends Service {


    Intent mainActivityIntent;
    PendingIntent pmainActivityIntent;

    Intent chaoIntent;
    PendingIntent pchaoIntent;


    @Override
    public void onCreate() {
        super.onCreate();


        mainActivityIntent = new Intent(this, Diagnostico.class);
        mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        pmainActivityIntent = PendingIntent.getActivity(getApplicationContext(),0,mainActivityIntent,0);


        chaoIntent = new Intent(this, BackgroundService.class);
        chaoIntent.setAction("app.caro.runningapps.BackgroundService.chao");
        pchaoIntent = PendingIntent.getService(this, 0,
                chaoIntent, 0);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if( intent.getAction().equals("app.caro.runningapps.BackgroundService.start") ) {
       //     System.out.println("onStartCommand ");
           /* Notification notification = new NotificationCompat.Builder(this)
                    .setContentTitle("chkTime")
                    .setTicker("chkTime")
                    .setContentText("chkTime")
                    .setSmallIcon(R.mipmap.logoblanco4)
                    .setOngoing(false)
                    .addAction(android.R.drawable.ic_menu_close_clear_cancel, "", pchaoIntent)
                    .setContentIntent(pmainActivityIntent)
                    .build();
            startForeground(9999, notification);*/
//            System.out.println("DESDEPUES DEL FOREGROUND");
          // System.out.println("ANTES DEL WHILE");
               ActivityManager manager =
                        (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                List<ActivityManager.RunningAppProcessInfo> processes = manager.getRunningAppProcesses();
                for (ActivityManager.RunningAppProcessInfo process : processes)
                {
  //                  System.out.println("en el FOR");
                    if(process.processName.equals("com.google.android.youtube")) {
                        System.out.println("YB ACTIVO EN EL SERVICIO " );
                        Notification notification = new NotificationCompat.Builder(this)
                                .setContentTitle("chkTime")
                                .setTicker("chkTime")
                                .setContentText("Youtube ACTIVO")
                                .setSmallIcon(R.mipmap.logoblanco4)
                                .setOngoing(false)
                                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "", pchaoIntent)
                                .setContentIntent(pmainActivityIntent)
                                .build();
                        startForeground(9999, notification);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.google.android.youtube");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.whatsapp")) {
                        System.out.println("WP ACTIVO EN EL SERVICIO " );
                        Notification notification = new NotificationCompat.Builder(this)
                                .setContentTitle("chkTime")
                                .setTicker("chkTime")
                                .setContentText("Whatsapp ACTIVO")
                                .setSmallIcon(R.mipmap.logoblanco4)
                                .setOngoing(false)
                                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "", pchaoIntent)
                                .setContentIntent(pmainActivityIntent)
                                .build();
                        startForeground(9999, notification);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.whatsapp");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.twitter.android")) {
                        System.out.println("TW ACTIVO EN EL SERVICIO ");
                        Notification notification = new NotificationCompat.Builder(this)
                                .setContentTitle("chkTime")
                                .setTicker("chkTime")
                                .setContentText("Twitter ACTIVO")
                                .setSmallIcon(R.mipmap.logoblanco4)
                                .setOngoing(false)
                                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "", pchaoIntent)
                                .setContentIntent(pmainActivityIntent)
                                .build();
                        startForeground(9999, notification);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.twitter.android");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.skype.raider")) {
                        System.out.println("Skype ACTIVO EN EL SERVICIO " );
                        Notification notification = new NotificationCompat.Builder(this)
                                .setContentTitle("chkTime")
                                .setTicker("chkTime")
                                .setContentText("Skype ACTIVO")
                                .setSmallIcon(R.mipmap.logoblanco4)
                                .setOngoing(false)
                                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "", pchaoIntent)
                                .setContentIntent(pmainActivityIntent)
                                .build();
                        startForeground(9999, notification);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.skype.raider");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.snapchat.android")) {
                        System.out.println("SC ACTIVO EN EL SERVICIO " );
                        Notification notification = new NotificationCompat.Builder(this)
                                .setContentTitle("chkTime")
                                .setTicker("chkTime")
                                .setContentText("Snapchat ACTIVO")
                                .setSmallIcon(R.mipmap.logoblanco4)
                                .setOngoing(false)
                                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "", pchaoIntent)
                                .setContentIntent(pmainActivityIntent)
                                .build();
                        startForeground(9999, notification);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.snapchat.android");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.instagram.android")) {
                        System.out.println("IG ACTIVO EN EL SERVICIO");
                        Notification notification = new NotificationCompat.Builder(this)
                                .setContentTitle("chkTime")
                                .setTicker("chkTime")
                                .setContentText("Instagram ACTIVO")
                                .setSmallIcon(R.mipmap.logoblanco4)
                                .setOngoing(false)
                                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "", pchaoIntent)
                                .setContentIntent(pmainActivityIntent)
                                .build();
                        startForeground(9999, notification);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.instagram.android");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.facebook.katana")) {
                        System.out.println("FB ACTIVO EN EL SERVICIO " );
                        Notification notification = new NotificationCompat.Builder(this)
                                .setContentTitle("chkTime")
                                .setTicker("chkTime")
                                .setContentText("Facebook ACTIVO")
                                .setSmallIcon(R.mipmap.logoblanco4)
                                .setOngoing(false)
                                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "", pchaoIntent)
                                .setContentIntent(pmainActivityIntent)
                                .build();
                        startForeground(9999, notification);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.facebook.katana");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.facebook.lite")) {
                        System.out.println("FB ACTIVO EN EL SERVICIO " );
                        Notification notification = new NotificationCompat.Builder(this)
                                .setContentTitle("chkTime")
                                .setTicker("chkTime")
                                .setContentText("Facebook ACTIVO")
                                .setSmallIcon(R.mipmap.logoblanco4)
                                .setOngoing(false)
                                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "", pchaoIntent)
                                .setContentIntent(pmainActivityIntent)
                                .build();
                        startForeground(9999, notification);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.facebook.lite");
                        this.sendBroadcast(i);
                    }
                }
               // Toast.makeText(this.getApplicationContext(), "hola", Toast.LENGTH_SHORT).show();
                //System.out.println("hola prueba");
               /* try {
                    new Thread().sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                   // break;
                }*/

            Intent alarma = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
            alarma.setAction("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "servicio");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, alarma, 0);

            AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (10 * 1000), pendingIntent);



            // Toast.makeText(this.getApplicationContext(), "hola 2", Toast.LENGTH_SHORT).show();
            //System.out.println("hola prueba 2");

        }else if( intent.getAction().equals("app.caro.runningapps.BackgroundService.chao") ){
            stopForeground(false);
            stopSelf();
            ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
            am.killBackgroundProcesses("com.example.carolina.chktime");
        }
        return START_STICKY;
    }
}
