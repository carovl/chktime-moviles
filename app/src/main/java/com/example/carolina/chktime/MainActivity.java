package com.example.carolina.chktime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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


        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragmentos, new Inicio()).commit(); //Paso 1

    }


}
