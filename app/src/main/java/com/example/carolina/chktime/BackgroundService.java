package com.example.carolina.chktime;


import android.app.ActivityManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

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
        pmainActivityIntent = PendingIntent.getActivity(this,0,mainActivityIntent,0);


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
            System.out.println("onStartCommand ");
          /*  Notification notification = new NotificationCompat.Builder(this)
                    .setContentTitle("chkTime")
                    .setTicker("chkTime")
                    .setContentText("chkTime")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setOngoing(false)
                    .addAction(android.R.drawable.ic_menu_close_clear_cancel, ""*//*"next"*//*, pchaoIntent)
                    .setContentIntent(pmainActivityIntent)
                    .build();
            startForeground(9999, notification);*/
          // System.out.println("ANTES DEL WHILE");

           while(true) {
               // System.out.println("EN EL WHILE");
                ActivityManager manager =
                        (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                List<ActivityManager.RunningAppProcessInfo> processes = manager.getRunningAppProcesses();
                for (ActivityManager.RunningAppProcessInfo process : processes)
                {
                    if(process.processName.equals("com.google.android.youtube")) {
                        System.out.println("YB ACTIVO EN EL SERVICIO");
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.google.android.youtube");
                        this.sendBroadcast(i);
                   }else if (process.processName.equals("com.whatsapp")) {
                        System.out.println("WP ACTIVO EN EL SERVICIO");
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.whatsapp");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.twitter.android")) {
                        System.out.println("TW ACTIVO EN EL SERVICIO");
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.twitter.android");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.skype.raider")) {
                        System.out.println("SK ACTIVO EN EL SERVICIO");
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.skype.raider");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.snapchat.android")) {
                        System.out.println("SC ACTIVO EN EL SERVICIO");
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.snapchat.android");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.instagram.android")) {
                        System.out.println("IG ACTIVO EN EL SERVICIO");
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.instagram.android");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.facebook.katana")) {
                        System.out.println("FB ACTIVO EN EL SERVICIO");
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.facebook.katana");
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.facebook.lite")) {
                        System.out.println("FB ACTIVO EN EL SERVICIO");
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.facebook.lite");
                        this.sendBroadcast(i);
                    }


                }

                try {
                    System.out.println("en el try");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("en el catch");
                    e.printStackTrace();
                }
            }
        }else if( intent.getAction().equals("app.caro.runningapps.BackgroundService.chao") ){
            stopForeground(false);
            stopSelf();
        }
        return START_STICKY;
    }

  /*  boolean isNamedProcessRunning(String processName){
        if (processName == null)
            return false;

        ActivityManager manager =
                (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processes = manager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo process : processes)
        {
            if (processName.equals(process.processName))
            {
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }*/




}
