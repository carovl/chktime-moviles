package com.example.carolina.chktime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    public MyBroadcastReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("on Receive");
        String status = intent.getStringExtra("alarma");
        switch (status){
            case "on":
                String name = intent.getStringExtra("app");
                Toast.makeText(context, "Felicidades :) has cumplido tu meta con " + name, Toast.LENGTH_SHORT).show();
                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(2000);
                return;
            case "servicio":
                Intent i = new Intent(context, BackgroundService.class);
                i.setAction("app.caro.runningapps.BackgroundService.start");
                context.startService(i);
                break;
            case "com.google.android.youtube":
                Diagnostico.stopAlert("Youtube",6);
                System.out.println("youtube activo en el BROADCAST RECIVER " );
                break;
            case "com.whatsapp":
                Diagnostico.stopAlert("Whatsapp",7);
                System.out.println("whatsapp activo en el BROADCAST RECIVER " );
                break;
            case "com.twitter.android":
                Diagnostico.stopAlert("Twitter",5);
                System.out.println("twitter activo en el BROADCAST RECIVER " );
                break;
            case "com.skype.raider":
                System.out.println("skype activo en el BROADCAST RECIVER ");
                Diagnostico.stopAlert("Skype",4);
            break;
            case "com.snapchat.android":
                Diagnostico.stopAlert("Snapchat",3);
                System.out.println("snapchat activo en el BROADCAST RECIVER " );
                break;
            case "com.instagram.android":
                Diagnostico.stopAlert("Instagram",2);
                System.out.println("instagram activo en el BROADCAST RECIVER " );
                break;
            case "com.facebook.katana":
                Diagnostico.stopAlert("Facebook",1);
                System.out.println("fb activo en el BROADCAST RECIVER " );
                break;
            case "com.facebook.lite":
                Diagnostico.stopAlert("Facebook",1);
                System.out.println("fb activo en el BROADCAST RECIVER " );
                break;
            default:
                Intent j = new Intent(context, BackgroundService.class);
                j.setAction("app.caro.runningapps.BackgroundService.start");
                context.startService(j);
                break;

        }

        /*if (status.equals("on")) {
            String name = intent.getStringExtra("app");
            Toast.makeText(context, "Felicidades :) has cumplido tu meta con " + name, Toast.LENGTH_SHORT).show();
            Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(2000);
            return;
        } else if(status.equals("servicio")){
            Intent i = new Intent(context, BackgroundService.class);
            i.setAction("app.caro.runningapps.BackgroundService.start");
            context.startService(i);
        }else if (status.equals("com.google.android.youtube")) {
            Diagnostico.stopAlert("Youtube",6);
            System.out.println("youtube activo en el BROADCAST RECIVER " );
        } else if (status.equals("com.whatsapp")) {
            Diagnostico.stopAlert("Whatsapp",7);
            System.out.println("whatsapp activo en el BROADCAST RECIVER " );
        } else if (status.equals("com.twitter.android")) {
            Diagnostico.stopAlert("Twitter",5);
            System.out.println("twitter activo en el BROADCAST RECIVER " );
        } else if (status.equals("com.skype.raider")) {
            System.out.println("skype activo en el BROADCAST RECIVER ");
            Diagnostico.stopAlert("Skype",4);
        } else if (status.equals("com.snapchat.android")) {
            Diagnostico.stopAlert("Snapchat",3);
            System.out.println("snapchat activo en el BROADCAST RECIVER " );
        } else if (status.equals("com.instagram.android")) {
            Diagnostico.stopAlert("Instagram",2);
            System.out.println("instagram activo en el BROADCAST RECIVER " );
        } else if (status.equals("com.facebook.katana")) {
           // int procID = intent.getIntExtra("procid", 0);
            Diagnostico.stopAlert("Facebook",1);
            System.out.println("fb activo en el BROADCAST RECIVER " );

        } else if (status.equals("com.facebook.lite")) {
            //int procID = intent.getIntExtra("procid", 0);
            Diagnostico.stopAlert("Facebook",1);
            System.out.println("fb activo en el BROADCAST RECIVER " );

        }*/
    }


}
