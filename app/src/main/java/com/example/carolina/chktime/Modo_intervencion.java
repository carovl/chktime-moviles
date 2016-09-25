package com.example.carolina.chktime;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Modo_intervencion extends Fragment {
    Button btn_back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_modo_intervencion, container, false);

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
        /*String outputText = "";
        for (Aplicacion aplicacion : aplicaciones) {
            outputText = outputText + String.format("Aplicacion: %s", aplicacion.getNombre());
        }
        App_1.setText(outputText);
*/

        return rootView;
    }

}
