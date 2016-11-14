package com.example.carolina.chktime;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static com.example.carolina.chktime.R.id.s1;


public class Modo_diagnostico extends Fragment {

    ImageView imgFB, imgIG, imgSC, imgSK, imgTW,imgYB,imgWP ;
    Button btn_back,s1,s2,s3,s4,s5,s6,s7;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    boolean cbFB, cbIG, cbSC, cbSK, cbTW, cbYB,cbWP;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    LinearLayout l1,l2,l3,l4,l5,l6,l7;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_modo_diagnostico, container, false);

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
            ed1 = (EditText) rootView.findViewById(R.id.ed1);
            s1 = (Button) rootView.findViewById(R.id.s1);
            l1= (LinearLayout) rootView.findViewById(R.id.l1);
            l1.setVisibility(View.VISIBLE);
            imgFB.setMinimumWidth(width);
            imgFB.setMaxWidth(width);
            imgFB.setMinimumHeight(heigt);
            imgFB.setMaxHeight(heigt);
            imgFB.setImageResource(R.mipmap.fbblanco);
        }

        if (cbIG==true){
            imgIG = (ImageView) rootView.findViewById(R.id.img2);
            ed2 = (EditText) rootView.findViewById(R.id.ed2);
            s2 = (Button) rootView.findViewById(R.id.s2);
            l2= (LinearLayout) rootView.findViewById(R.id.l2);
            l2.setVisibility(View.VISIBLE);

            imgIG.setMinimumWidth(width);
            imgIG.setMaxWidth(width);
            imgIG.setMinimumHeight(heigt);
            imgIG.setMaxHeight(heigt);
            imgIG.setImageResource(R.mipmap.insta);
        }

        if (cbSC==true){
            imgSC = (ImageView) rootView.findViewById(R.id.img3);
            ed3 = (EditText) rootView.findViewById(R.id.ed3);
            s3= (Button) rootView.findViewById(R.id.s3);
            l3= (LinearLayout) rootView.findViewById(R.id.l3);
            l3.setVisibility(View.VISIBLE);
            imgSC.setMinimumWidth(width);
            imgSC.setMaxWidth(width);
            imgSC.setMinimumHeight(heigt);
            imgSC.setMaxHeight(heigt);
            imgSC.setImageResource(R.mipmap.sc);
        }

        if (cbSK==true){
            imgSK = (ImageView) rootView.findViewById(R.id.img4);
            ed4 = (EditText) rootView.findViewById(R.id.ed4);
            s4 = (Button) rootView.findViewById(R.id.s4);
            l4= (LinearLayout) rootView.findViewById(R.id.l4);
            l4.setVisibility(View.VISIBLE);
            imgSK.setMinimumWidth(width);
            imgSK.setMaxWidth(width);
            imgSK.setMinimumHeight(heigt);
            imgSK.setMaxHeight(heigt);
            imgSK.setImageResource(R.mipmap.skype);
        }

        if (cbTW==true){
            imgTW = (ImageView) rootView.findViewById(R.id.img5);
            ed5 = (EditText) rootView.findViewById(R.id.ed5);
            s5 = (Button) rootView.findViewById(R.id.s5);
            l5= (LinearLayout) rootView.findViewById(R.id.l5);
            l5.setVisibility(View.VISIBLE);
            imgTW.setMinimumWidth(width);
            imgTW.setMaxWidth(width);
            imgTW.setMinimumHeight(heigt);
            imgTW.setMaxHeight(heigt);
            imgTW.setImageResource(R.mipmap.twblanco);
        }

        if (cbYB==true){
            imgYB = (ImageView) rootView.findViewById(R.id.img6);
            ed6 = (EditText) rootView.findViewById(R.id.ed6);
            s6 = (Button) rootView.findViewById(R.id.s6);
            l6= (LinearLayout) rootView.findViewById(R.id.l6);
            l6.setVisibility(View.VISIBLE);
            imgYB.setMinimumWidth(width);
            imgYB.setMaxWidth(width);
            imgYB.setMinimumHeight(heigt);
            imgYB.setMaxHeight(heigt);
            imgYB.setImageResource(R.mipmap.yb);
        }

        if (cbWP==true){
            imgWP = (ImageView) rootView.findViewById(R.id.img7);
            ed7 = (EditText) rootView.findViewById(R.id.ed7);
            s7 = (Button) rootView.findViewById(R.id.s7);
            l7= (LinearLayout) rootView.findViewById(R.id.l7);
            l7.setVisibility(View.VISIBLE);
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

        return rootView;
    }



}
