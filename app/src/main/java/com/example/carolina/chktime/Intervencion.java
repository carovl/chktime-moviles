package com.example.carolina.chktime;

import android.app.IntentService;
import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Intervencion extends IntentService {

    TextView mtext;
    String v;
    boolean s = false,t,r;
    private CountDownTimer mCountDownTimer;
    long mir;

    public static final String ACTION_PROGRESO = "com.example.carolina.chktime.action.FOO";
    public static final String ACTION_FIN = "com.example.carolina.chktime.action.BAZ";

    @Override
    protected void onHandleIntent(Intent intent) {
        long mir = intent.getLongExtra("min", 0);
        t = intent.getBooleanExtra("stop", false);
        mCountDownTimer = createTimer(mir);
        mCountDownTimer.start();

        if(r==true){
            Intent res = new Intent();
            res.setAction(ACTION_PROGRESO);
            res.putExtra("contador", v);
            sendBroadcast(res);
            tarea();
        }

        if (t == true || s==true) {
            mCountDownTimer.cancel();
            Intent res = new Intent();
            String estado = "done!";
            res.setAction(ACTION_FIN);
            res.putExtra("estado", estado);
            res.putExtra("enabled", s);
            sendBroadcast(res);
        }
    }

    private CountDownTimer createTimer(long mir) {
        return new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long mir) {

                v = "Seconds remain " + mir / 1000 + " minutes " + java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(mir);
                Log.d("TAG",v);
                Log.d("camilo","camilo");
                Intent res = new Intent();
                res.setAction(ACTION_PROGRESO);
                res.putExtra("contador", v);
                sendBroadcast(res);
                tarea();
            }

            @Override
            public void onFinish() {
                s = true;
                Log.d("ard","ard");
            }
        };
    }

    public Intervencion() {
        super("Intervencion");


    }

    public void tarea() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){}
    }

}
