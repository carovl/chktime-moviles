package com.example.carolina.chktime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
//public class MainActivity extends AppCompatActivity implements Inicio.CallInstructions{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,new Inicio()).commit();
   }

}
