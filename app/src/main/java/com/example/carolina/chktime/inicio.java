package com.example.carolina.chktime;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class inicio extends Fragment  {

    Button btn_Inst;

    @Override
    public void onCreate(Bundle savedInstanceState) { //simplemente creo el fragmento inicio
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_inicio, container, false);
        // FIXME Se infla el fragmento en un objeto tipo view (rootView) luego saco las caracteristicas que necesito para finalmente retornarlo

        btn_Inst = (Button) rootView.findViewById(R.id.instrucciones_btn);

        btn_Inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Instrucciones()).commit();
                //llamo la actividad, el admin de soporte de frags,
            }
        });

        return rootView;
    }





}
