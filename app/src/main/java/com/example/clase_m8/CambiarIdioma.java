package com.example.clase_m8;

import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Locale;

public class CambiarIdioma extends Fragment {
    Configuration configuracion;
    public CambiarIdioma() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View V=inflater.inflate(R.layout.fragment_cambiar_idioma, container, false);

        Button uno=V.findViewById(R.id.change);

        configuracion=new Configuration((getResources().getConfiguration()));

        uno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Switch to Spanish
                Locale locale = new Locale("es");
                Locale.setDefault( locale );
                Configuration config = new Configuration();
                config.locale = locale;

                Locale locale2 = new Locale("en");
                Locale.setDefault( locale2 );
                Configuration config2 = new Configuration();
                config.locale = locale2;
                getResources().updateConfiguration(configuracion, getResources().getDisplayMetrics());


                refresh();

            }
        });


        return V;
    }

    public void refresh(){
        Fragment frSettings = new CambiarIdioma();

        FragmentManager menuManager = getFragmentManager();
        FragmentTransaction menuTransaction = menuManager.beginTransaction();

        menuTransaction.replace(R.id.contenedor, frSettings);
        menuTransaction.commit();
    }

}