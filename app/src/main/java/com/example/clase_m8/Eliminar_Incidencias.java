package com.example.clase_m8;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.clase_m8.db.IncidenciaBDHelper;

public class Eliminar_Incidencias extends Fragment {
    Button borrar_todos_registros;
    IncidenciaBDHelper dbhelper;
    SQLiteDatabase db;
    public Eliminar_Incidencias() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V=inflater.inflate(R.layout.fragment_eliminar__incidencias, container, false);

        dbhelper=((Menu_principal)getActivity()).dbhelper;
        db=((Menu_principal)getActivity()).db;


        mostrardialogo();








        return V;
    }

    public void mostrardialogo(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle("Cuidado!");
        builder.setMessage("Quieres eliminar todas las incidencias?")
                .setPositiveButton("si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbhelper.eliminarIncidencias(db,dbhelper);
                        
                        Toast.makeText(getContext(),"Incidencias eliminadas",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),"Cancelado",Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }


}