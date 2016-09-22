package com.example.carolina.chktime;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;



import android.widget.Toast;


public class Redes_Sociales extends Fragment {

    Button btn_back, btn_Fin;
    private CheckBox selec_FB;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_redes__sociales, container, false);

        //******************************************************************************************
        //Boton atras y adelante


        btn_back = (Button) rootView.findViewById(R.id.atras);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Menu()).commit();

            }
        });

        btn_Fin = (Button) rootView.findViewById(R.id.fin_seleccion);
        btn_Fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Modo_diagnostico()).commit();

            }
        });


        //******************************************************************************************

        selec_FB = (CheckBox) rootView.findViewById(R.id.checkBox_FB);
        selec_FB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();

                if (isChecked) {
                    selec_FB.setText("");
                }
                else {
                    selec_FB.setText("Has deseleccionado Facebook");
                }
            }
        });




        return rootView;
    }



}
