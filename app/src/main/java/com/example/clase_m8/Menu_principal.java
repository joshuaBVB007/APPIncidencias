package com.example.clase_m8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.example.clase_m8.db.IncidenciaBDHelper;

public class Menu_principal extends AppCompatActivity {
    public IncidenciaBDHelper dbhelper;
    public SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        //Base de datos
        dbhelper=new IncidenciaBDHelper(getApplicationContext());
        db=dbhelper.getWritableDatabase();

    }
}