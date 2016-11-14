package com.example.carolina.chktime;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class Modo_intervencion extends Fragment{

    ImageView imgFB, imgIG, imgSC, imgSK, imgTW, imgYB, imgWP;
    Button btn_back, stop1;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    boolean cbFB, cbIG, cbSC, cbSK, cbTW, cbYB, cbWP;
    TextView shower1;
    EditText edi;
    int ard = 0;
    long min = 0;
    BroadcastReceiver mb;
    Intent fbintent;

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intervencion.ACTION_PROGRESO);
        filter.addAction(Intervencion.ACTION_FIN);

        fbintent = new Intent(getActivity(), Intervencion.class);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_modo_intervencion, container, false);
        sp = getActivity().getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor = sp.edit();

        stop1 = (Button) rootView.findViewById(R.id.stop1);
        stop1.setEnabled(false);
        shower1 = (TextView) rootView.findViewById(R.id.shower1);
        edi = (EditText) rootView.findViewById(R.id.editor1);





        mb = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Intervencion.ACTION_PROGRESO)) {
                    String solver = intent.getStringExtra("contador");
                    shower1.setText("" + solver);

                }else if(intent.getAction().equals(Intervencion.ACTION_FIN)){
                    boolean f;
                    f=intent.getBooleanExtra("enabled",false );
                    edi.setEnabled(f);
                    stop1.setBackgroundColor(Color.parseColor("#3F51B5"));
                }
            }
        };

        //******************************************************************************************
        //Identificacion de las apps seleccionadas
        cbFB = sp.getBoolean("Facebook", false);
        cbIG = sp.getBoolean("Instagram", false);
        cbSC = sp.getBoolean("Snapchat", false);
        cbSK = sp.getBoolean("Skype", false);
        cbTW = sp.getBoolean("Twitter", false);
        cbYB = sp.getBoolean("Youtube", false);
        cbWP = sp.getBoolean("Whatsapp", false);
        int width = 80;
        int heigt = 80;

        if (cbFB == true) {
            imgFB = (ImageView) rootView.findViewById(R.id.img1);
            imgFB.setVisibility(View.VISIBLE);
            imgFB.setMinimumWidth(width);
            imgFB.setMaxWidth(width);
            imgFB.setMinimumHeight(heigt);
            imgFB.setMaxHeight(heigt);
            imgFB.setImageResource(R.mipmap.fbblanco);



        }

        if (cbIG == true) {
            imgIG = (ImageView) rootView.findViewById(R.id.img2);
            imgIG.setVisibility(View.VISIBLE);
            imgIG.setMinimumWidth(width);
            imgIG.setMaxWidth(width);
            imgIG.setMinimumHeight(heigt);
            imgIG.setMaxHeight(heigt);
            imgIG.setImageResource(R.mipmap.insta);
        }

        if (cbSC == true) {
            imgSC = (ImageView) rootView.findViewById(R.id.img3);
            imgSC.setVisibility(View.VISIBLE);
            imgSC.setMinimumWidth(width);
            imgSC.setMaxWidth(width);
            imgSC.setMinimumHeight(heigt);
            imgSC.setMaxHeight(heigt);
            imgSC.setImageResource(R.mipmap.sc);
        }

        if (cbSK == true) {
            imgSK = (ImageView) rootView.findViewById(R.id.img4);
            imgSK.setVisibility(View.VISIBLE);
            imgSK.setMinimumWidth(width);
            imgSK.setMaxWidth(width);
            imgSK.setMinimumHeight(heigt);
            imgSK.setMaxHeight(heigt);
            imgSK.setImageResource(R.mipmap.skype);
        }

        if (cbTW == true) {
            imgTW = (ImageView) rootView.findViewById(R.id.img5);
            imgTW.setVisibility(View.VISIBLE);
            imgTW.setMinimumWidth(width);
            imgTW.setMaxWidth(width);
            imgTW.setMinimumHeight(heigt);
            imgTW.setMaxHeight(heigt);
            imgTW.setImageResource(R.mipmap.twblanco);
        }

        if (cbYB == true) {
            imgYB = (ImageView) rootView.findViewById(R.id.img6);
            imgYB.setVisibility(View.VISIBLE);
            imgYB.setMinimumWidth(width);
            imgYB.setMaxWidth(width);
            imgYB.setMinimumHeight(heigt);
            imgYB.setMaxHeight(heigt);
            imgYB.setImageResource(R.mipmap.yb);
        }

        if (cbWP == true) {
            imgWP = (ImageView) rootView.findViewById(R.id.img7);
            imgWP.setVisibility(View.VISIBLE);
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

        edi.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (i) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:

                        case KeyEvent.KEYCODE_ENTER:
                            stop1.setEnabled(true);
                            ard = Integer.parseInt(edi.getText().toString());
                            shower1.setText(Integer.toString(ard));
                            edi.setEnabled(false);
                            stop1.setBackgroundColor(Color.parseColor("#FF4081"));
                            min = ard * 60000;
                            fbintent.putExtra("min", min);
                            getActivity().startService(fbintent);


                            return true;
                        default:
                            break;
                    }


                }
                return false;
            }
        });

        stop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fbintent.putExtra("stop", true);
                getActivity().startService(fbintent);
            }
        });

        return rootView;
    }


}
