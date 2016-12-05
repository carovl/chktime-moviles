package com.example.carolina.chktime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor=sp.edit();
       // intent = new Intent(MainActivity.this, BackgroundService.class);

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragmentos, new Inicio()).commit(); //Paso 1

    }
   /* private BroadcastReceiver ReceivefromService = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent)
        {
            String status=intent.getStringExtra("newstatus");
            switch (status){
                case "com.facebook.lite":
                    System.out.println("FB lite activo");
                    break;
                case "com.facebook.katana":
                    System.out.println("FB activo");
                    break;
                case "com.instagram.android":
                    System.out.println("Instagram activo");
                    break;
                case "com.snapchat.android":
                    System.out.println("Snapchat activo");
                    break;
                case "com.skype.raider":
                    System.out.println("Skype activo");
                    break;
                case "com.twitter.android":
                    System.out.println("TW activo");
                    break;
                case "com.google.android.youtube":
                    System.out.println("YB activo");
                    break;
                case "com.whatsapp":
                    System.out.println("WP activo");
                    break;
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(ReceivefromService);
        } catch (IllegalArgumentException e) {
            Toast.makeText(this,"Problemas soltando el broadcast receiver", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.actualizarEstado");
        registerReceiver(ReceivefromService, filter);
    }

*/
}
