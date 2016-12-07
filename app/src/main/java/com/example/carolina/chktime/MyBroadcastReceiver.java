package com.example.carolina.chktime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    boolean alarma, diagnostico, intervencion;;

    public MyBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        sp = context.getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor = sp.edit();
        diagnostico= sp.getBoolean("diagnostico",false);
        intervencion= sp.getBoolean("intervencion",false);

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
                System.out.println("yb alarma " + sp.getBoolean("alarma", false));
                if(alarma=sp.getBoolean("activacion", false)){
                    Diagnostico.stopAlert("Youtube",6);
                }
                System.out.println("youtube activo en el BROADCAST RECIVER " );
                break;
            case "com.whatsapp":
                if(alarma=sp.getBoolean("activacion", false)) {
                    Diagnostico.stopAlert("Whatsapp", 7);
                }
                System.out.println("whatsapp activo en el BROADCAST RECIVER " );
                break;
            case "com.twitter.android":
                if(alarma=sp.getBoolean("activacion", false)) {
                    Diagnostico.stopAlert("Twitter", 5);
                }
                System.out.println("twitter activo en el BROADCAST RECIVER " );
                break;
            case "com.skype.raider":
                System.out.println("skype activo en el BROADCAST RECIVER ");
                if(alarma=sp.getBoolean("activacion", false)) {
                    Diagnostico.stopAlert("Skype", 4);
                }
            break;
            case "com.snapchat.android":
                if(alarma=sp.getBoolean("activacion", false)) {
                    Diagnostico.stopAlert("Snapchat", 3);
                }
                System.out.println("snapchat activo en el BROADCAST RECIVER " );
                break;
            case "com.instagram.android":
                if(alarma=sp.getBoolean("activacion", false)) {
                    Diagnostico.stopAlert("Instagram", 2);
                }
                System.out.println("instagram activo en el BROADCAST RECIVER " );
                break;
            case "com.facebook.katana":
                if(alarma=sp.getBoolean("activacion", false)) {
                    Diagnostico.stopAlert("Facebook", 1);
                }
                System.out.println("fb activo en el BROADCAST RECIVER " );
                break;
            case "com.facebook.lite":
                if(alarma=sp.getBoolean("activacion", false)) {
                    Diagnostico.stopAlert("Facebook", 1);
                }
                System.out.println("fb activo en el BROADCAST RECIVER " );
                break;
            default:
                i = new Intent(context, BackgroundService.class);
                i.setAction("app.caro.runningapps.BackgroundService.start");
                context.startService(i);
                break;

        }
    }

}
