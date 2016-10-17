package com.example.carolina.chktime;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class Modo_intervencion extends Fragment {

    ImageView imgFB, imgIG, imgSC, imgSK, imgTW,imgYB, imgWP ;
    Button btn_back;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    boolean cbFB, cbIG, cbSC, cbSK, cbTW, cbYB, cbWP;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_modo_intervencion, container, false);
        sp = getActivity().getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor=sp.edit();


        //******************************************************************************************
        //Identificacion de las apps seleccionadas
        cbFB= sp.getBoolean("Facebook",false);
        cbIG= sp.getBoolean("Instagram",false);
        cbSC= sp.getBoolean("Snapchat",false);
        cbSK= sp.getBoolean("Skype",false);
        cbTW= sp.getBoolean("Twitter",false);
        cbYB= sp.getBoolean("Youtube",false);
        cbWP= sp.getBoolean("Whatsapp",false);
        int width = 80;
        int heigt = 80;

        if (cbFB==true){
            imgFB = (ImageView) rootView.findViewById(R.id.img1);
            imgFB.setMinimumWidth(width);
            imgFB.setMaxWidth(width);
            imgFB.setMinimumHeight(heigt);
            imgFB.setMaxHeight(heigt);
            imgFB.setImageResource(R.mipmap.fbblanco);
        }

        if (cbIG==true){
            imgIG = (ImageView) rootView.findViewById(R.id.img2);
            imgIG.setMinimumWidth(width);
            imgIG.setMaxWidth(width);
            imgIG.setMinimumHeight(heigt);
            imgIG.setMaxHeight(heigt);
            imgIG.setImageResource(R.mipmap.insta);
        }

        if (cbSC==true){
            imgSC = (ImageView) rootView.findViewById(R.id.img3);
            imgSC.setMinimumWidth(width);
            imgSC.setMaxWidth(width);
            imgSC.setMinimumHeight(heigt);
            imgSC.setMaxHeight(heigt);
            imgSC.setImageResource(R.mipmap.sc);
        }

        if (cbSK==true){
            imgSK = (ImageView) rootView.findViewById(R.id.img4);
            imgSK.setMinimumWidth(width);
            imgSK.setMaxWidth(width);
            imgSK.setMinimumHeight(heigt);
            imgSK.setMaxHeight(heigt);
            imgSK.setImageResource(R.mipmap.skype);
        }

        if (cbTW==true){
            imgTW = (ImageView) rootView.findViewById(R.id.img5);
            imgTW.setMinimumWidth(width);
            imgTW.setMaxWidth(width);
            imgTW.setMinimumHeight(heigt);
            imgTW.setMaxHeight(heigt);
            imgTW.setImageResource(R.mipmap.twblanco);
        }

        if (cbYB==true){
            imgYB = (ImageView) rootView.findViewById(R.id.img6);
            imgYB.setMinimumWidth(width);
            imgYB.setMaxWidth(width);
            imgYB.setMinimumHeight(heigt);
            imgYB.setMaxHeight(heigt);
            imgYB.setImageResource(R.mipmap.yb);
        }

        if (cbWP==true){
            imgWP = (ImageView) rootView.findViewById(R.id.img7);
            imgWP.setMinimumWidth(width);
            imgWP.setMaxWidth(width);
            imgWP.setMinimumHeight(heigt);
            imgWP.setMaxHeight(heigt);
            imgWP.setImageResource(R.mipmap.wp);
        }


        //******************************************************************************************
        //Boton de atras
        btn_back = (Button) rootView.findViewById(R.id.atras);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Menu()).commit();

            }
        });

        //******************************************************************************************



        return rootView;
    }

}
