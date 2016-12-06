package com.example.carolina.chktime;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Diagnostico extends AppCompatActivity {

    ImageView imgFB, imgIG, imgSC, imgSK, imgTW, imgYB, imgWP;
    Button btn_back, s1, s2, s3, s4, s5, s6, s7, btn_listo;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    boolean cbFB, cbIG, cbSC, cbSK, cbTW, cbYB, cbWP, RunFB, RunIG, RunSC, RunSK, RunTW, RunYB, RunWP;
    EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7;
    LinearLayout l1, l2, l3, l4, l5, l6, l7;
    private static Context mContext;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_modo_diagnostico);
        mContext = this.getApplicationContext();
        sp = getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor = sp.edit();

        //******************************************************************************************
        //Identificacion de las apps seleccionadas
        cbFB = sp.getBoolean("Facebook", false);
        cbIG = sp.getBoolean("Instagram", false);
        cbSC = sp.getBoolean("Snapchat", false);
        cbSK = sp.getBoolean("Skype", false);
        cbTW = sp.getBoolean("Twitter", false);
        cbYB = sp.getBoolean("Youtube", false);
        cbWP = sp.getBoolean("Whatsapp", false);

       /* RunFB = sp.getBoolean("Facebook_RUN", false);
        // System.out.println("FB=" + RunFB);
        RunIG = sp.getBoolean("Instagram_RUN", false);
        // System.out.println("IG=" + RunIG);
        RunSC = sp.getBoolean("Snapchat_RUN", false);
        RunSK = sp.getBoolean("Skype_RUN", false);
        RunTW = sp.getBoolean("Twitter_RUN", false);
        RunYB = sp.getBoolean("Youtube_RUN", false);
        RunWP = sp.getBoolean("Whatsapp_RUN", false);
        // System.out.println("WP=" + RunWP);*/

        int width = 80;
        int heigt = 80;
        int i = 0;

        if (cbFB == true) {
            imgFB = (ImageView) findViewById(R.id.img1);
            ed1 = (EditText) findViewById(R.id.ed1);
            s1 = (Button) findViewById(R.id.s1);
          /*  if (RunFB == true) {
                s1.setText("RUN"); // esto es para probar si si reconoce las apps que estan corriendo
            }*/
            l1 = (LinearLayout) findViewById(R.id.l1);
            l1.setVisibility(View.VISIBLE);
            imgFB.setMinimumWidth(width);
            imgFB.setMaxWidth(width);
            imgFB.setMinimumHeight(heigt);
            imgFB.setMaxHeight(heigt);
            imgFB.setImageResource(R.mipmap.fbblanco);
            // Configurar la alarma
            ed1.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        switch (keyCode) {
                            case KeyEvent.KEYCODE_DPAD_CENTER:

                            case KeyEvent.KEYCODE_ENTER:
                                if (ed1.getText().toString().isEmpty()) {
                                } else {
                                    String string_temp = ed1.getText().toString();
                                    startAlert(string_temp, "Facebook", 1);
                                }
                                return true;
                            default:
                                break;
                        }
                    }
                    return false;
                }
            });
            // Poner pausa a la alarma
            s1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopAlert("Facebook", 1);
                }
            });
        }

        if (cbIG == true) {
            imgIG = (ImageView) findViewById(R.id.img2);
            ed2 = (EditText) findViewById(R.id.ed2);
            s2 = (Button) findViewById(R.id.s2);
          /* if(RunIG == true){
                s2.setText("RUN");
            }*/
            l2 = (LinearLayout) findViewById(R.id.l2);
            l2.setVisibility(View.VISIBLE);

            imgIG.setMinimumWidth(width);
            imgIG.setMaxWidth(width);
            imgIG.setMinimumHeight(heigt);
            imgIG.setMaxHeight(heigt);
            imgIG.setImageResource(R.mipmap.insta);
            // Configurar la alarma
            ed2.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        switch (keyCode) {
                            case KeyEvent.KEYCODE_DPAD_CENTER:

                            case KeyEvent.KEYCODE_ENTER:
                                if (ed2.getText().toString().isEmpty()) {
                                } else {
                                    String string_temp = ed2.getText().toString();
                                    startAlert(string_temp, "Instagram", 2);
                                }
                                return true;
                            default:
                                break;
                        }
                    }
                    return false;
                }
            });
            // Poner pausa a la alarma
            s2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopAlert("Instagram", 2);
                }
            });
        }

        if (cbSC == true) {
            imgSC = (ImageView) findViewById(R.id.img3);
            ed3 = (EditText) findViewById(R.id.ed3);
            s3 = (Button) findViewById(R.id.s3);
           /* if(RunSC == true){
                s3.setText("RUN");
            }*/
            l3 = (LinearLayout) findViewById(R.id.l3);
            l3.setVisibility(View.VISIBLE);
            imgSC.setMinimumWidth(width);
            imgSC.setMaxWidth(width);
            imgSC.setMinimumHeight(heigt);
            imgSC.setMaxHeight(heigt);
            imgSC.setImageResource(R.mipmap.sc);
            // Configurar la alarma
            ed3.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        switch (keyCode) {
                            case KeyEvent.KEYCODE_DPAD_CENTER:
                            case KeyEvent.KEYCODE_ENTER:
                                if (ed3.getText().toString().isEmpty()) {
                                } else {
                                    String string_temp = ed3.getText().toString();
                                    startAlert(string_temp, "Snapchat", 3);
                                }
                                return true;
                            default:
                                break;
                        }
                    }
                    return false;
                }
            });
            // Poner pausa a la alarma
            s3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopAlert("Snapchat", 3);
                }
            });
        }

        if (cbSK == true) {
            imgSK = (ImageView) findViewById(R.id.img4);
            ed4 = (EditText) findViewById(R.id.ed4);
            s4 = (Button) findViewById(R.id.s4);
         /*   if(RunSK == true){
                s4.setText("RUN");
            }*/
            l4 = (LinearLayout) findViewById(R.id.l4);
            l4.setVisibility(View.VISIBLE);
            imgSK.setMinimumWidth(width);
            imgSK.setMaxWidth(width);
            imgSK.setMinimumHeight(heigt);
            imgSK.setMaxHeight(heigt);
            imgSK.setImageResource(R.mipmap.skype);
            // Configurar la alarma
            ed4.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        switch (keyCode) {
                            case KeyEvent.KEYCODE_DPAD_CENTER:
                            case KeyEvent.KEYCODE_ENTER:
                                if (ed4.getText().toString().isEmpty()) {
                                } else {
                                    String string_temp = ed4.getText().toString();
                                    startAlert(string_temp, "Skype", 4);
                                }
                                return true;
                            default:
                                break;
                        }
                    }
                    return false;
                }
            });
            // Poner pausa a la alarma
            s4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopAlert("Skype", 4);
                }
            });
        }

        if (cbTW == true) {
            imgTW = (ImageView) findViewById(R.id.img5);
            ed5 = (EditText) findViewById(R.id.ed5);
            s5 = (Button) findViewById(R.id.s5);
          /*  if(RunTW == true){
                s5.setText("RUN");
            }*/
            l5 = (LinearLayout) findViewById(R.id.l5);
            l5.setVisibility(View.VISIBLE);
            imgTW.setMinimumWidth(width);
            imgTW.setMaxWidth(width);
            imgTW.setMinimumHeight(heigt);
            imgTW.setMaxHeight(heigt);
            imgTW.setImageResource(R.mipmap.twblanco);
            // Configurar la alarma
            ed5.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        switch (keyCode) {
                            case KeyEvent.KEYCODE_DPAD_CENTER:
                            case KeyEvent.KEYCODE_ENTER:
                                if (ed5.getText().toString().isEmpty()) {
                                } else {
                                    String string_temp = ed5.getText().toString();
                                    startAlert(string_temp, "Twitter", 5);
                                }
                                return true;
                            default:
                                break;
                        }
                    }
                    return false;
                }
            });
            // Poner pausa a la alarma
            s5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopAlert("Twitter", 5);
                }
            });
        }

        if (cbYB == true) {
            imgYB = (ImageView) findViewById(R.id.img6);
            ed6 = (EditText) findViewById(R.id.ed6);
            s6 = (Button) findViewById(R.id.s6);
           /* if(RunYB == true){
                s6.setText("RUN");
            }*/
            l6 = (LinearLayout) findViewById(R.id.l6);
            l6.setVisibility(View.VISIBLE);
            imgYB.setMinimumWidth(width);
            imgYB.setMaxWidth(width);
            imgYB.setMinimumHeight(heigt);
            imgYB.setMaxHeight(heigt);
            imgYB.setImageResource(R.mipmap.yb);
            // Configurar la alarma
            ed6.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        switch (keyCode) {
                            case KeyEvent.KEYCODE_DPAD_CENTER:
                            case KeyEvent.KEYCODE_ENTER:
                                if (ed6.getText().toString().isEmpty()) {
                                } else {
                                    String string_temp = ed6.getText().toString();
                                    startAlert(string_temp, "Youtube", 6);
                                }
                                return true;
                            default:
                                break;
                        }
                    }
                    return false;
                }
            });
            // Poner pausa a la alarma
            s6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopAlert("Youtube", 6);
                }
            });
        }

        if (cbWP == true) {
            imgWP = (ImageView) findViewById(R.id.img7);
            ed7 = (EditText) findViewById(R.id.ed7);
            s7 = (Button) findViewById(R.id.s7);
           /* if(RunWP == true){
                s7.setText("RUN");
            }*/
            l7 = (LinearLayout) findViewById(R.id.l7);
            l7.setVisibility(View.VISIBLE);
            imgWP.setMinimumWidth(width);
            imgWP.setMaxWidth(width);
            imgWP.setMinimumHeight(heigt);
            imgWP.setMaxHeight(heigt);
            imgWP.setImageResource(R.mipmap.wp);
            // Configurar la alarma
            ed7.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        switch (keyCode) {
                            case KeyEvent.KEYCODE_DPAD_CENTER:
                            case KeyEvent.KEYCODE_ENTER:
                                if (ed7.getText().toString().isEmpty()) {
                                } else {
                                    String string_temp = ed7.getText().toString();
                                    startAlert(string_temp, "Whatsapp", 7);
                                }
                                return true;
                            default:
                                break;
                        }
                    }
                    return false;
                }
            });
            // Poner pausa a la alarma
            s7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopAlert("Whatsapp", 7);
                }
            });

          /*  intent = new Intent(Diagnostico.this, BackgroundService.class);
            intent.setAction("app.caro.runningapps.BackgroundService.startWP");
            startService(intent);*/
        }


        //******************************************************************************************
        //Boton de atras
       /* btn_back = (Button) findViewById(R.id.atras);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Diagnostico.class);
                startActivity(intent);
                finish();
                //finish();
                //onStop();
                //getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Menu()).commit();
            }
        });*/

        btn_listo = (Button) findViewById(R.id.listo);
        btn_listo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, BackgroundService.class);
                intent.setAction("app.caro.runningapps.BackgroundService.start");
                startService(intent);

                /*Intent i = new Intent(getApplicationContext(), Diagnostico.class);
                startActivity(i);
                finish();*/

            }
        });
    }

    //*************************************************************************************************
    //Alarma
    public static void startAlert(String s, String app, int id) {
        int i = 5; //valor por defecto
        i = Integer.valueOf(s); //de aca se sacaria el valor para la alarma
        System.out.println("START ALERT");
        Intent intent = new Intent(mContext, MyBroadcastReceiver.class);
        intent.setAction("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "on").putExtra("app",app);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, id, intent, 0);

        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pendingIntent);

        Toast.makeText(mContext, "Monitoreo de " + i + " segundos para " + app, Toast.LENGTH_SHORT).show();
    }

    public static void stopAlert(String app, int id) {

        System.out.println("STOP ALERT" + id);
        Intent intent = new Intent(mContext, MyBroadcastReceiver.class);
        intent.setAction("com.example.carolina.chktime.broadcat_reciever.custom").putExtra("alarma", "off");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, id, intent, 0);

        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);

        Toast.makeText(mContext, ":( No has cumplido tu meta con " + app, Toast.LENGTH_SHORT).show();
    }

    //*************************************************************************************************
    private BroadcastReceiver MyBroadcastReceiver1 = new BroadcastReceiver() {


        @Override
        public void onReceive(Context context, Intent intent) {
            System.out.println("on Receive");
            String status = intent.getStringExtra("alarma");
            if (status.equals("on")) {
                Toast.makeText(context, "Felicidades :)", Toast.LENGTH_SHORT).show();
                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(2000);
                return;

            } else if (status.equals("com.google.android.youtube")) {
                Diagnostico.stopAlert("Youtube", 6);
                //Toast.makeText(context, "youtube activo en el BROADCAST RECIVER", Toast.LENGTH_SHORT).show();
                //int procID = intent.getIntExtra("procid", 0);
                System.out.println("youtube activo en el BROADCAST RECIVER ");

            } else if (status.equals("com.whatsapp")) {
                Diagnostico.stopAlert("Whatsapp", 7);
                //int procID = intent.getIntExtra("procid", 0);
                System.out.println("whatsapp activo en el BROADCAST RECIVER ");

            } else if (status.equals("com.twitter.android")) {
                //int procID = intent.getIntExtra("procid", 0);
                Diagnostico.stopAlert("Twitter", 5);
                System.out.println("twitter activo en el BROADCAST RECIVER ");


            } else if (status.equals("com.skype.raider")) {
                // int procID = intent.getIntExtra("procid", 0);
                System.out.println("skype activo en el BROADCAST RECIVER ");
                Diagnostico.stopAlert("Skype", 4);

            } else if (status.equals("com.snapchat.android")) {
                Diagnostico.stopAlert("Snapchat", 3);
                //int procID = intent.getIntExtra("procid", 0);
                System.out.println("snapchat activo en el BROADCAST RECIVER ");

            } else if (status.equals("com.instagram.android")) {
                // int procID = intent.getIntExtra("procid", 0);
                Diagnostico.stopAlert("Instagram", 2);
                System.out.println("instagram activo en el BROADCAST RECIVER ");

            } else if (status.equals("com.facebook.katana")) {
                // int procID = intent.getIntExtra("procid", 0);
                Diagnostico.stopAlert("Facebook", 1);
                System.out.println("fb activo en el BROADCAST RECIVER ");

            } else if (status.equals("com.facebook.lite")) {
                //int procID = intent.getIntExtra("procid", 0);
                Diagnostico.stopAlert("Facebook", 1);
                System.out.println("fb activo en el BROADCAST RECIVER ");
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(MyBroadcastReceiver1);
        } catch (IllegalArgumentException e) {
            Toast.makeText(this, "Problemas soltando el broadcast receiver", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.carolina.chktime.broadcat_reciever.custom");
        registerReceiver(MyBroadcastReceiver1, filter);
    }
}

