package com.example.clase_m8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clase_m8.db.IncidenciaBDHelper;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText user_name;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_name=findViewById(R.id.user_name);
        password=findViewById(R.id.password);

        SharedPreferences mispreferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
        user_name.setText(mispreferencias.getString("user","admin@"));
    }

    public void registrar(View v){
        SharedPreferences mis=getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=mis.edit();
        editor.putString("user",user_name.getText().toString());
        editor.commit();
        String nombre_usuario=user_name.getText().toString();
        String contrasenia=password.getText().toString();
        if(nombre_usuario.contains("@") && contrasenia.length()>=1 || contrasenia.length()<=5){
            Toast.makeText(this,"Ingresando",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,Menu_principal.class);
            startActivity(i);
        }else{
            Toast.makeText(this,"Usuario o contraseña invalido",Toast.LENGTH_SHORT).show();
        }
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.ingles){
            Toast.makeText(this,"Inglés has seleccionado",Toast.LENGTH_SHORT).show();
            String languageToLoad  = "en"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getResources().updateConfiguration(config,
                    getResources().getDisplayMetrics());
            recreate();
        }else if(id==R.id.espanol){
            Toast.makeText(this,"Español has seleccionado",Toast.LENGTH_SHORT).show();
            String languageToLoad  = "es"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getResources().updateConfiguration(config,
                    getResources().getDisplayMetrics());
            recreate();
        }
        return super.onOptionsItemSelected(item);
    }





}