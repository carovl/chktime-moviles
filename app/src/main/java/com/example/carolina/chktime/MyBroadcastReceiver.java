package com.example.carolina.chktime;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public  MyBroadcastReceiver(){

    }
    boolean alarma = false;

    @Override
    public void onReceive (Context context, Intent intent){
        System.out.println("on Receive");
        String status=intent.getStringExtra("alarma");
        if(status.equals("on")) {
            alarma = true;
            Toast.makeText(context,"Felicidades :)", Toast.LENGTH_SHORT).show();
            Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(2000);
        }
        if(status.equals("off")) {
            Toast.makeText(context, "No lo lograste intenta de nuevo :(", Toast.LENGTH_SHORT).show();

        }
        if(status.equals("com.google.android.youtube")) {
            Toast.makeText(context, "youtube activo en el BROADCAST RECIVER", Toast.LENGTH_SHORT).show();
        }
        if(status.equals("com.whatsapp")) {
            Toast.makeText(context, "whatsapp activo en el BROADCAST RECIVER", Toast.LENGTH_SHORT).show();
        }
        if(status.equals("com.twitter.android")) {
            Toast.makeText(context, "twitter activo en el BROADCAST RECIVER", Toast.LENGTH_SHORT).show();
        }
        if(status.equals("com.skype.raider")) {
            Toast.makeText(context, "skype activo en el BROADCAST RECIVER", Toast.LENGTH_SHORT).show();
        }
        if(status.equals("com.snapchat.android")) {
            Toast.makeText(context, "snapchat activo en el BROADCAST RECIVER", Toast.LENGTH_SHORT).show();
        }
        if(status.equals("com.instagram.android")) {
            Toast.makeText(context, "instagram activo en el BROADCAST RECIVER", Toast.LENGTH_SHORT).show();
        }
        if(status.equals("com.facebook.katana")) {
            Toast.makeText(context, "fb activo en el BROADCAST RECIVER", Toast.LENGTH_SHORT).show();
        }
        if(status.equals("com.facebook.lite")) {
            Toast.makeText(context, "fb activo en el BROADCAST RECIVER", Toast.LENGTH_SHORT).show();
        }

    }
}
