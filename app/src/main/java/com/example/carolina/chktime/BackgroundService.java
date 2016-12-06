package com.example.carolina.chktime;


import android.app.ActivityManager;
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
            Notification notification = new NotificationCompat.Builder(this)
                    .setContentTitle("chkTime")
                    .setTicker("chkTime")
                    .setContentText("chkTime")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setOngoing(false)
                    .addAction(android.R.drawable.ic_menu_close_clear_cancel, "", pchaoIntent)
                    .setContentIntent(pmainActivityIntent)
                    .build();
            startForeground(9999, notification);
            System.out.println("DESDEPUES DEL FOREGROUND");
          // System.out.println("ANTES DEL WHILE");
               ActivityManager manager =
                        (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                List<ActivityManager.RunningAppProcessInfo> processes = manager.getRunningAppProcesses();
                for (ActivityManager.RunningAppProcessInfo process : processes)
                {
                    System.out.println("en el FOR");
                    if(process.processName.equals("com.google.android.youtube")) {
                        int YBid = process.uid;
                        System.out.println("YB ACTIVO EN EL SERVICIO " + YBid);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.google.android.youtube").putExtra("procid",YBid);
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.whatsapp")) {
                        int WPid = process.uid;
                        System.out.println("WP ACTIVO EN EL SERVICIO " + WPid);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.whatsapp").putExtra("procid",WPid);
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.twitter.android")) {
                        int TWid = process.uid;
                        System.out.println("TW ACTIVO EN EL SERVICIO " + TWid);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.twitter.android").putExtra("procid",TWid);
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.skype.raider")) {
                        int SKid = process.uid;
                        System.out.println("SK ACTIVO EN EL SERVICIO " + SKid);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.skype.raider").putExtra("procid",SKid);
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.snapchat.android")) {
                        int SCid = process.uid;
                        System.out.println("SC ACTIVO EN EL SERVICIO " + SCid);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.snapchat.android").putExtra("procid",SCid);
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.instagram.android")) {
                        int IGid = process.uid;
                        System.out.println("IG ACTIVO EN EL SERVICIO");
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.instagram.android").putExtra("procid",IGid);
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.facebook.katana")) {
                        int FBid = process.uid;
                        System.out.println("FB ACTIVO EN EL SERVICIO " + FBid);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.facebook.katana").putExtra("procid",FBid);
                        this.sendBroadcast(i);
                    }else if (process.processName.equals("com.facebook.lite")) {
                        int FBid = process.uid;
                        System.out.println("FB ACTIVO EN EL SERVICIO " + FBid);
                        Intent i = new Intent("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "com.facebook.lite").putExtra("procid",FBid);
                        this.sendBroadcast(i);
                    }
                }
               // Toast.makeText(this.getApplicationContext(), "hola", Toast.LENGTH_SHORT).show();
                //System.out.println("hola prueba");
                try {
                    new Thread().sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                   // break;
                }
           // Toast.makeText(this.getApplicationContext(), "hola 2", Toast.LENGTH_SHORT).show();
            //System.out.println("hola prueba 2");
            Intent i = new Intent(this, BackgroundService.class);
            i.setAction("app.caro.runningapps.BackgroundService.start");
            startService(i);
        }else if( intent.getAction().equals("app.caro.runningapps.BackgroundService.chao") ){
            stopForeground(false);
            stopSelf();
        }
        return START_REDELIVER_INTENT;
    }
}
