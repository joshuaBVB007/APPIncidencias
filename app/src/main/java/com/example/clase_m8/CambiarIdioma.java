package com.example.clase_m8;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Locale;

public class CambiarIdioma extends Fragment {
    public CambiarIdioma() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View V=inflater.inflate(R.layout.fragment_cambiar_idioma, container, false);

        Button uno=V.findViewById(R.id.btn_idioma_ingles);
        Button dos=V.findViewById(R.id.btn_idioma_catalan);



        uno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String languageToLoad  = "en"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getContext().getResources().updateConfiguration(config,
                        getContext().getResources().getDisplayMetrics());
                //System.exit(0);


            }
        });

        dos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //ESTO FUNCIONA PERO PROBAREMOS OTRAS COSAS
                String languageToLoad  = "ca"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getContext().getResources().updateConfiguration(config,
                        getContext().getResources().getDisplayMetrics());


            }
        });


        return V;
    }

}