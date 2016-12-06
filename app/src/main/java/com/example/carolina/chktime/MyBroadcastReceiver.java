package com.example.carolina.chktime;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    boolean diagnostico, intervencion, choque;

    public MyBroadcastReceiver() {
        diagnostico = sp.getBoolean("diagnostico", false);
        intervencion = sp.getBoolean("intervencion", false);

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("on Receive");
        String status = intent.getStringExtra("alarma");
        if (status.equals("on")) {
            Toast.makeText(context, "Felicidades :)", Toast.LENGTH_SHORT).show();
            Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(2000);
            return;
        } else if (status.equals("off")) {
            Toast.makeText(context, "No lo lograste intenta de nuevo :(", Toast.LENGTH_SHORT).show();

        } else if (status.equals("com.google.android.youtube")) {
            //Toast.makeText(context, "youtube activo en el BROADCAST RECIVER", Toast.LENGTH_SHORT).show();
            int procID = intent.getIntExtra("procid", 0);
            System.out.println("youtube activo en el BROADCAST RECIVER " + procID);
            if (diagnostico == true) {
                Diagnostico.stopAlert("Youtube", 6);
            } else if (intervencion== true){
                Intervencion2.killProc(status, procID);
            }
        } else if (status.equals("com.whatsapp")) {
            int procID = intent.getIntExtra("procid", 0);
            System.out.println("whatsapp activo en el BROADCAST RECIVER " + procID);
            if (diagnostico = true) {
                Diagnostico.stopAlert("Whatsapp", 7);
            }else if (intervencion== true){
                Intervencion2.killProc(status, procID);
            }
        } else if (status.equals("com.twitter.android")) {
            int procID = intent.getIntExtra("procid", 0);
            System.out.println("twitter activo en el BROADCAST RECIVER " + procID);
            if (diagnostico = true) {
                Diagnostico.stopAlert("Twitter", 5);
            }else if (intervencion== true){
                Intervencion2.killProc(status, procID);
            }
        } else if (status.equals("com.skype.raider")) {
            int procID = intent.getIntExtra("procid", 0);
            System.out.println("skype activo en el BROADCAST RECIVER " + procID);
            if (diagnostico = true) {
                Diagnostico.stopAlert("Skype", 4);
            }else if (intervencion== true){
                Intervencion2.killProc(status, procID);
            }
        } else if (status.equals("com.snapchat.android")) {
            int procID = intent.getIntExtra("procid", 0);
            System.out.println("snapchat activo en el BROADCAST RECIVER " + procID);
            if (diagnostico = true) {
                Diagnostico.stopAlert("Snapchat", 3);
            }else if (intervencion== true){
                Intervencion2.killProc(status, procID);
            }
        } else if (status.equals("com.instagram.android")) {
            int procID = intent.getIntExtra("procid", 0);
            System.out.println("instagram activo en el BROADCAST RECIVER " + procID);
            if (diagnostico = true) {
                Diagnostico.stopAlert("Instagram", 2);
            }else if (intervencion== true){
                Intervencion2.killProc(status, procID);
            }
        } else if (status.equals("com.facebook.katana")) {
            int procID = intent.getIntExtra("procid", 0);
            System.out.println("fb activo en el BROADCAST RECIVER " + procID);
            if (diagnostico = true) {
                Diagnostico.stopAlert("Facebook", 1);
            }else if (intervencion== true){
                Intervencion2.killProc(status, procID);
            }
        } else if (status.equals("com.facebook.lite")) {
            int procID = intent.getIntExtra("procid", 0);
            System.out.println("fb activo en el BROADCAST RECIVER " + procID);
            if (diagnostico = true) {
                Diagnostico.stopAlert("Facebook", 1);
            }else if (intervencion== true){
                Intervencion2.killProc(status, procID);
            }
        }
    }
}
