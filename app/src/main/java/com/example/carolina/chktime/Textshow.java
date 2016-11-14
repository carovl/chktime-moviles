package com.example.carolina.chktime;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Textshow extends Fragment {


    private SharedPreferences sp;
    private SharedPreferences.Editor editor;


    Button btn_back;
    int shower ;

    TextView titulo, descripcion;

    public Textshow(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_textshow, container, false);

        sp = getActivity().getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor=sp.edit();
        shower= sp.getInt("intVariableName",0);

        titulo = (TextView) rootView.findViewById(R.id.title);
        descripcion = (TextView) rootView.findViewById(R.id.descripcion);

        btn_back = (Button) rootView.findViewById(R.id.atras);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (shower == 3 ){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Menu()).commit();
                }else{
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Inicio()).commit();
                }

            }

        });

        switch(shower){
            case 1:
                titulo.setText("INSTRUCCIONES");
                descripcion.setText("Escoge un metodo, selecciona la red social, programa el tiempo, desconectate");

                break;
            case 2:
                titulo.setText("ACERCA DE");
                descripcion.setText("Es un proyecto universitario para programacion de dispositivos moviles, la materia");
                editor.putInt("intVariableName",0).commit();
                break;
            case 3:
                titulo.setText("AYUDA");
                descripcion.setText("Simplemente escoge tu red social y program el tiempo");
                editor.putInt("intVariableName",0).commit();
                break;
            default:
                break;
        }

        return rootView;
    }

}
