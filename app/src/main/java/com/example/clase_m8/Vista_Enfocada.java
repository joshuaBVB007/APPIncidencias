package com.example.clase_m8;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Vista_Enfocada extends Fragment {

    String titulo,prioridad,descripcion,fecha,estado;

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V=inflater.inflate(R.layout.fragment_vista__enfocada, container, false);

        titulo=getArguments().getString("ITEM_TITLE");
        prioridad=getArguments().getString("ITEM_PRIO");
        descripcion=getArguments().getString("ITEM_DESC");
        fecha=getArguments().getString("ITEM_DATE");
        estado=getArguments().getString("ITEM_STATE");

        TextView titulo_1=V.findViewById(R.id.tx_titulo);
        TextView prioridad_1=V.findViewById(R.id.tx_prioridad);
        TextView descripcion_1=V.findViewById(R.id.tx_descripcion);
        TextView fecha_1=V.findViewById(R.id.tx_fecha);
        final Button estado_1=V.findViewById(R.id.im_estado);

        titulo_1.setText(titulo);
        prioridad_1.setText(prioridad);
        descripcion_1.setText(descripcion);
        fecha_1.setText(fecha);
        estado_1.setText("Pendiente");

            estado_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // estado="1";
                    String cambio=validarEstado(estado);
                    if(cambio.equals("1")){
                        estado_1.setText("Asignada");
                        estado_1.setBackgroundColor(Color.GREEN);
                        estado="1";
                    }else if(cambio.equals("2")){
                        estado_1.setText("Realizada");
                        estado_1.setBackgroundColor(Color.RED);
                        estado="2";
                    }else if(cambio.equals("3")){
                        estado_1.setText("Pendiente");
                        estado_1.setBackgroundColor(Color.CYAN);
                        estado="0";
                    }
                }
            });


        return V;
    }

    public String validarEstado(String estado){
        int numero_estado=Integer.parseInt(estado);
        String cambio;
        if(numero_estado==0){
            numero_estado++;
            cambio=String.valueOf(numero_estado);
            return cambio;
        }else if(numero_estado==1){
            numero_estado++;
            cambio=String.valueOf(numero_estado);
            return cambio;
        }else{
            numero_estado++;
            cambio=String.valueOf(numero_estado);
            return cambio;
        }
    }

}