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


public class Inicio extends Fragment  {

            Button inst;
            Button atras;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

           @Override
           public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                 // TODO Auto-generated method stub
                 View v = inflater.inflate(R.layout.fragment_inicio, container,false);
               inst =(Button) v.findViewById(R.id.instrucciones_btn);
               inst.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new Instrucciones()).commit();

                   }
               });


               return v;



           }

}
