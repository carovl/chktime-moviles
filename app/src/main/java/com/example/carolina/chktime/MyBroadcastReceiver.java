package com.example.carolina.chktime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public  MyBroadcastReceiver(){

    }

    @Override
    public void onReceive (Context context, Intent intent){
        //System.out.println("br ALERT");
        String status=intent.getStringExtra("alarma");
        if(status.equals("on")) {
            Toast.makeText(context, "Your time is up", Toast.LENGTH_SHORT).show();
            Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(2000);
        }
        if(status.equals("off")) {
            Toast.makeText(context, "No lo lograste intenta de nuevo :(", Toast.LENGTH_SHORT).show();

        }

    }
}
