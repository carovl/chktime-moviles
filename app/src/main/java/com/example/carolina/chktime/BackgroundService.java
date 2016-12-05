package com.example.carolina.chktime;


import android.app.ActivityManager;
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

        mainActivityIntent = new Intent(this, MainActivity.class);
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
        if( intent.getAction().equals("app.caro.runningapps.BackgroundService.startWP") ) {
            Notification notification = new NotificationCompat.Builder(this)
                    .setContentTitle("chkTime")
                    .setTicker("chkTime")
                    .setContentText("chkTime")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setOngoing(false)
                    .addAction(android.R.drawable.ic_menu_close_clear_cancel, ""/*"next"*/, pchaoIntent)
                    .setContentIntent(pmainActivityIntent)
                    .build();
            startForeground(9999, notification);
          // System.out.println("ANTES DEL WHILE");

            while(true) {
               // System.out.println("EN EL WHILE");
                ActivityManager manager =
                        (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                List<ActivityManager.RunningAppProcessInfo> processes = manager.getRunningAppProcesses();
                for (ActivityManager.RunningAppProcessInfo process : processes)
                {
                   // System.out.println("EN EL FOR");

            /*        switch (process.processName){
                        case "com.facebook.lite":
                            System.out.println("FB lite activo");
                            i = new Intent("android.intent.action.actualizarEstado")
                                    .putExtra("newstatus", "com.facebook.lite");
                            sendBroadcast(i);
                            break;
                        case "com.facebook.katana":
                            System.out.println("FB activo");
                            j = new Intent("android.intent.action.actualizarEstado")
                                    .putExtra("newstatus", "com.facebook.katana");
                            sendBroadcast(j);
                            break;
                        case "com.instagram.android":
                            k = new Intent("android.intent.action.actualizarEstado")
                                    .putExtra("newstatus", "com.instagram.android");
                            sendBroadcast(k);
                            break;
                        case "com.snapchat.android":
                            l = new Intent("android.intent.action.actualizarEstado")
                                    .putExtra("newstatus", "com.snapchat.android");
                            sendBroadcast(l);
                            break;
                        case "com.skype.raider":
                            m = new Intent("android.intent.action.actualizarEstado")
                                    .putExtra("newstatus", "com.skype.raider");
                            sendBroadcast(m);
                            break;
                        case "com.twitter.android":
                            n = new Intent("android.intent.action.actualizarEstado")
                                    .putExtra("newstatus", "com.twitter.android");
                            sendBroadcast(n);
                            break;
                        case "com.google.android.youtube":
                            System.out.println("YB activo");
                            o = new Intent("android.intent.action.actualizarEstado")
                                    .putExtra("newstatus", "com.google.android.youtube");
                            sendBroadcast(o);
                            break;
                        case "com.whatsapp":
                         //   System.out.println("WP activo");
                            p = new Intent("android.intent.action.actualizarEstado")
                                    .putExtra("newstatus", "com.whatsapp");
                            sendBroadcast(p);
                            break;
                        default:
                            break;
                    }*/
                    if(process.processName.equals("com.whatsapp")) {
                        Intent i = new Intent("android.intent.action.actualizarEstado")
                                .putExtra("newstatus", "com.whatsapp");
                        sendBroadcast(i);
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
