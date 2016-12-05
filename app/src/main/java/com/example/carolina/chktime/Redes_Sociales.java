package com.example.carolina.chktime;


import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import static android.content.Context.ACTIVITY_SERVICE;


public class Redes_Sociales extends Fragment {

    Button btn_back, btn_Con;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private CheckBox cbFB, cbSK, cbYB, cbTW, cbSC, cbIG, cbWP;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_redes__sociales, container, false);

        sp = getActivity().getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor = sp.edit();


        //******************************************************************************************
        //Boton atras y continuar
        btn_back = (Button) rootView.findViewById(R.id.atras);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Inicio()).commit();
            }
        });

        btn_Con = (Button) rootView.findViewById(R.id.continuar);
        btn_Con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragmentos, new Menu()).commit();
            }
        });

        //******************************************************************************************
        //Verifico si las apps estan instaldas en el equipo


             boolean facebbokliteInstalled = this.appInstalled("com.facebook.lite");
        boolean facebbokInstalled = this.appInstalled("com.facebook.katana");
        boolean instagramInstalled = this.appInstalled("com.instagram.android");
        boolean snapchatInstalled = this.appInstalled("com.snapchat.android");
        boolean skypeInstalled = this.appInstalled("com.skype.raider");
        boolean twitterInstalled = this.appInstalled("com.twitter.android");
        boolean youtubeInstalled = this.appInstalled("com.google.android.youtube");
        boolean whatsappInstalled = this.appInstalled("com.whatsapp");


        //******************************************************************************************
        //Verifico si las apps estan instaldas en el equipo
        boolean facebookliteRunning;
        boolean facebbokRunning;
        boolean instagramRunning;
        boolean snapchatRunning;
        boolean skypeRunning;
        boolean twitterRunning;
        boolean youtubeRunning ;
        boolean whatsappRunning ;//= isNamedProcessRunning("com.whatsapp");
        //System.out.println("INST "+whatsappInstalled);
        //System.out.println("RUN "+whatsappRunning);


        //******************************************************************************************
        //Implementacion y guardado de estado de los CheckBoxes
        //Facebook
        cbFB = (CheckBox) rootView.findViewById(R.id.checkBox_FB);
        if (facebbokInstalled || facebbokliteInstalled) {
            facebookliteRunning = this.isNamedProcessRunning("com.facebook.lite");
            facebbokRunning = this.isNamedProcessRunning("com.facebook.katana");
            if(facebookliteRunning || facebbokRunning){
                editor.putBoolean("Facebook_RUN", true).commit(); //le asigno a la opcion facebook el estado de instalado

            }

            cbFB.setChecked(sp.getBoolean("Facebook", false)); //cargar aplicaciones
            cbFB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("Facebook", isChecked).commit(); //le asigno a la opcion facebook el estado de instalado

                }
            });
        } else {
            cbFB.setEnabled(false);
        }


        //Instagram
        cbIG = (CheckBox) rootView.findViewById(R.id.checkBox_IG);
        if (instagramInstalled) {
            instagramRunning = this.isNamedProcessRunning("com.instagram.android");
            if(instagramRunning){
                editor.putBoolean("Instagram_RUN", instagramRunning).commit();

            }
            cbIG.setChecked(sp.getBoolean("Instagram", false)); //cargar aplicaciones
            cbIG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("Instagram", isChecked).commit();
                }
            });
        } else {
            cbIG.setEnabled(false);
        }

        //Snapchat
        cbSC = (CheckBox) rootView.findViewById(R.id.checkBox_SC);
        if (snapchatInstalled) {
            snapchatRunning = this.isNamedProcessRunning("com.snapchat.android");
            if(snapchatRunning){
                editor.putBoolean("Snapchat_RUN", snapchatRunning).commit();

            }
            cbSC.setChecked(sp.getBoolean("Snapchat", false)); //cargar aplicaciones
            cbSC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("Snapchat", isChecked).commit();
                }
            });
        } else {
            cbSC.setEnabled(false);
        }

        //Skype
        cbSK = (CheckBox) rootView.findViewById(R.id.checkBox_SK);
        if (skypeInstalled) {
            skypeRunning = this.isNamedProcessRunning("com.skype.raider");
            if(skypeRunning){
                editor.putBoolean("Skype_RUN", skypeRunning).commit();

            }
            cbSK.setChecked(sp.getBoolean("Skype", false)); //cargar aplicaciones
            cbSK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("Skype", isChecked).commit();
                }
            });
        } else {
            cbSK.setEnabled(false);
        }

        //Twitter
        cbTW = (CheckBox) rootView.findViewById(R.id.checkBox_TW);
        if (twitterInstalled) {
            twitterRunning = this.isNamedProcessRunning("com.twitter.android");
            if(twitterRunning){
                editor.putBoolean("Twitter_RUN", twitterRunning).commit();
            }
            cbTW.setChecked(sp.getBoolean("Twitter", false)); //cargar aplicaciones
            cbTW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("Twitter", isChecked).commit();
                }
            });
        } else {
            cbTW.setEnabled(false);
        }

        //Youtube
        cbYB = (CheckBox) rootView.findViewById(R.id.checkBox_YB);
        if (youtubeInstalled) {
            youtubeRunning = this.isNamedProcessRunning("com.google.android.youtube");
            if(youtubeRunning){
                editor.putBoolean("Youtube_RUN", youtubeRunning).commit();

            }
            cbYB.setChecked(sp.getBoolean("Youtube", false)); //cargar aplicaciones
            cbYB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("Youtube", isChecked).commit();

                }
            });
        } else {
            cbYB.setEnabled(false);
        }

        //Whatsapp
        cbWP = (CheckBox) rootView.findViewById(R.id.checkBox_WP);
        if (whatsappInstalled) {
            whatsappRunning = this.isNamedProcessRunning("com.whatsapp");
            if(whatsappRunning){
                editor.putBoolean("Whatsapp_RUN", whatsappRunning).commit();
                System.out.println("WP= true");

            }
            cbWP.setChecked(sp.getBoolean("Whatsapp", false)); //cargar aplicaciones
            cbWP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("Whatsapp", isChecked).commit();
                }
            });
        } else {
            cbWP.setEnabled(false);
        }


        //******************************************************************************************


        return rootView;
    }

    //******************************************************************************************
    //http://stackoverflow.com/questions/11391451/list-out-installed-running-applications-in-android-programmatically/11391558
    private boolean appInstalled(String uri) {
        PackageManager pm = this.getActivity().getPackageManager();
        boolean app_installed = false;

        try {
            pm.getPackageInfo(uri, 0);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException var5) {
            app_installed = false;
        }

        return app_installed;
    }

    //******************************************************************************************
    // esto funcionó en android 4.4 API 19 en la 21 no funciona
    //http://stackoverflow.com/questions/29330794/how-to-check-whether-a-particular-app-is-running-or-not-in-android
    boolean isNamedProcessRunning(String processName){
        if (processName == null)
            return false;

        ActivityManager manager =
                (ActivityManager) getContext().getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processes = manager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo process : processes)
        {
            if (processName.equals(process.processName))
            {
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }


}









