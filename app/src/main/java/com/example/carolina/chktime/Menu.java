package com.example.carolina.chktime;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.carolina.chktime.R;


public class Menu extends Fragment {

    Button btn_back, btn_ayuda, btn_diagnostico, btn_intervencion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        btn_back = (Button) rootView.findViewById(R.id.atras);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Inicio()).commit();

            }
        });

        btn_ayuda = (Button) rootView.findViewById(R.id.ayuda);
        btn_ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Ayuda()).commit();

            }
        });

        //******************************************************************************************
        //Modos

        btn_diagnostico = (Button) rootView.findViewById(R.id.modo_diagnostico);
        btn_diagnostico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Modo_diagnostico()).commit();

            }
        });

        btn_intervencion = (Button) rootView.findViewById(R.id.modo_intervencion);
        btn_intervencion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Modo_intervencion()).commit();

            }
        });


        return rootView;
    }

}
