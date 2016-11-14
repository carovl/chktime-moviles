package com.example.carolina.chktime;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Inicio extends Fragment {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    Button btn_Inst, btn_Menu, btn_Acerca;

    public Inicio(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) { //simplemente creo el fragmento Inicio
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inicio, container, false);

        sp = getActivity().getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor=sp.edit();


        btn_Menu = (Button) rootView.findViewById(R.id.comenzar_btn);
        btn_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Redes_Sociales()).commit();
            }
        });

        btn_Inst = (Button) rootView.findViewById(R.id.instrucciones_btn);
        btn_Inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putInt("intVariableName",1).commit(); //El valor 1 nos lleva a las instrucciones
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Textshow()).commit();
                //llamo la actividad, el admin de soporte de frags,
            }
        });

        btn_Acerca = (Button) rootView.findViewById(R.id.acercade_btn);
        btn_Acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putInt("intVariableName",2).commit();//El valor 2 nos lleva al acerca de
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Textshow()).commit();

            }
        });

        return rootView;
    }
}

