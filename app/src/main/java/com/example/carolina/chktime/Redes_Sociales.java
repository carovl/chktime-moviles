package com.example.carolina.chktime;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.List;


public class Redes_Sociales extends Fragment {

    Button btn_back, btn_Con;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private CheckBox cbFB,cbSK, cbYB, cbTW, cbSC, cbIG;
    private List<Aplicacion> aplicaciones;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
              final View rootView = inflater.inflate(R.layout.fragment_redes__sociales, container, false);

        sp = getActivity().getSharedPreferences("Opciones_Guardadas",Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor=sp.edit();


        //******************************************************************************************
        //Boton atras y adelante
        btn_back = (Button) rootView.findViewById(R.id.atras);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Inicio()).commit();
            }
        });

        btn_Con = (Button) rootView.findViewById(R.id.continuar);
        btn_Con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Menu()).commit();
            }
        });

       //******************************************************************************************
        //Implementacion y guardado de estado de los CheckBoxes
        //Facebook
        cbFB = (CheckBox) rootView.findViewById(R.id.checkBox_FB);
        cbFB.setChecked(sp.getBoolean("Facebook",false)); //cargar aplicaciones
        cbFB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("Facebook", isChecked).commit(); //le asigno a la opcion facebook el estado de
            }
        });

        //Instagram
        cbIG = (CheckBox) rootView.findViewById(R.id.checkBox_IG);
        cbIG.setChecked(sp.getBoolean("Instagram",false)); //cargar aplicaciones
        cbIG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("Instagram", isChecked).commit();
            }
        });

        //Snapchat
        cbSC = (CheckBox) rootView.findViewById(R.id.checkBox_SC);
        cbSC.setChecked(sp.getBoolean("Snapchat",false)); //cargar aplicaciones
        cbSC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("Snapchat", isChecked).commit();
            }
        });

        //Skype
        cbSK = (CheckBox) rootView.findViewById(R.id.checkBox_SK);
        cbSK.setChecked(sp.getBoolean("Skype",false)); //cargar aplicaciones
        cbSK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("Skype", isChecked).commit();
            }
        });

        //Twitter
        cbTW = (CheckBox) rootView.findViewById(R.id.checkBox_TW);
        cbTW.setChecked(sp.getBoolean("Twitter",false)); //cargar aplicaciones
        cbTW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("Twitter", isChecked).commit();
            }
        });

        //Youtube
        cbYB = (CheckBox) rootView.findViewById(R.id.checkBox_YB);
        cbYB.setChecked(sp.getBoolean("Youtube",false)); //cargar aplicaciones
        cbYB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("Youtube", isChecked).commit();
            }
        });

       //******************************************************************************************
    /*    boolean cheked = ((CheckBox) rootView).isChecked();
        Aplicacion aplicacion = new Aplicacion();*/


        return rootView;
    }


}



