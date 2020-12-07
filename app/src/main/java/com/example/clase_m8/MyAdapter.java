package com.example.clase_m8;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase_m8.Recursos.Incidencia;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context c;
    ArrayList<Incidencia> lista;
    public MyAdapter(Context context, ArrayList<Incidencia> lista_Incidencias) {
        this.lista=lista_Incidencias;
        c=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(c);
        View V=inflater.inflate(R.layout.mi_fila,parent,false);
        return new MyViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if(lista!=null){
            String statusText = "";
            int color = 0;
            int textColor = 0;

            if(lista.get(position).getEstado().equals("0")){
                statusText="Pendiente";
                color = Color.CYAN;
                textColor = Color.WHITE;
            }else if(lista.get(position).getEstado().equals("1")){
                statusText="Asignada";
                color = Color.GREEN;
                textColor = Color.WHITE;
            }else if(lista.get(position).getEstado().equals("2")){
                statusText="Hecha";
                color = Color.RED;
                textColor = Color.WHITE;
            }
            holder.estado_Incidencia.setText(statusText);
            holder.estado_Incidencia.setBackgroundColor(color);
            holder.estado_Incidencia.setTextColor(textColor);

        }

        holder.titulo_Incidencia.setText(lista.get(position).getContenido());
        holder.contenido_Incidencia.setText(lista.get(position).getPrioridad());
        holder.fecha_Incidencia.setText(lista.get(position).dimeFecha());
        holder.descripcion_Incidencia.setText(lista.get(position).getDesc());
        
        final int id=position;
        holder.contenido_Incidencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                Vista_Enfocada muestra = new Vista_Enfocada();

                Bundle bundle = new Bundle();
                bundle.putInt("ITEM_ID",lista.get(id).id);
                bundle.putString("ITEM_TITLE", lista.get(id).getContenido());
                bundle.putString("ITEM_PRIO", lista.get(id).getPrioridad());
                bundle.putString("ITEM_DESC", lista.get(id).getDesc());
                bundle.putString("ITEM_DATE", lista.get(id).dimeFecha());
                bundle.putString("ITEM_STATE", lista.get(id).getEstado());

                muestra.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, muestra).addToBackStack(null).commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titulo_Incidencia;
        TextView contenido_Incidencia;
        TextView fecha_Incidencia;
        TextView descripcion_Incidencia;
        TextView estado_Incidencia;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           titulo_Incidencia =itemView.findViewById(R.id.titulo);
           contenido_Incidencia =itemView.findViewById(R.id.contenido);
           fecha_Incidencia =itemView.findViewById(R.id.fecha);
           descripcion_Incidencia =itemView.findViewById(R.id.descripcion);
           estado_Incidencia=itemView.findViewById(R.id.estado);

        }
    }

}
