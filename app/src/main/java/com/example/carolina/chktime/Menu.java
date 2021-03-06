package com.example.carolina.chktime;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Menu extends Fragment {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    Button btn_back, btn_ayuda, btn_diagnostico, btn_intervencion, btn_choque;
    boolean diagnostico, intervencion;

    public Menu(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getActivity().getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor=sp.edit();
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
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Redes_Sociales()).commit();

            }
        });

        btn_ayuda = (Button) rootView.findViewById(R.id.ayuda);
        btn_ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putInt("intVariableName",3).commit();//El entero 3 nos lleva a las opciones de ayuda
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Textshow()).commit();

            }
        });

        //******************************************************************************************
        //Modos

        btn_diagnostico = (Button) rootView.findViewById(R.id.modo_diagnostico);
        btn_diagnostico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diagnostico=true;
                intervencion=false;
                editor.putBoolean("diagnostico",diagnostico).commit();
                editor.putBoolean("intervencion",intervencion).commit();
                Intent intent = new Intent(getActivity(), Diagnostico.class);
                startActivity(intent);
                getActivity().finish();

            }
        });

        btn_intervencion = (Button) rootView.findViewById(R.id.modo_intervencion);
        btn_intervencion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diagnostico=false;
                intervencion=true;
                editor.putBoolean("diagnostico",diagnostico).commit();
                editor.putBoolean("intervencion",intervencion).commit();

                Intent intent = new Intent(getActivity(), DESCONECTATE.class);
                startActivity(intent);
                getActivity().finish();

            }
        });
        btn_choque = (Button) rootView.findViewById(R.id.modo_choque);
        btn_choque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Espera este modo en la proxima version!! de chkTime ;)",Toast.LENGTH_SHORT).show();
            }
        });



        return rootView;
    }

}
