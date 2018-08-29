package com.example.worldskills.emparjapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.emparjapp.models.Puntaje;

public class Datos extends SQLiteOpenHelper {
    SQLiteDatabase bd;
    public Datos(Context context) {
        super(context, "emparej", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.SQL_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TBL_PUNTAJES);
        onCreate(db);
    }

    public boolean guardarDatosJuego(Puntaje puntaje){
        bd=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constantes.CAMPO_NOMBRE,puntaje.getNombre());
        values.put(Constantes.CAMPO_PUNTOS,puntaje.getNombre());
        values.put(Constantes.CAMPO_NIVEL,puntaje.getNombre());
        values.put(Constantes.CAMPO_TIEMPO,puntaje.getNombre());
        return bd.insert(Constantes.TBL_PUNTAJES,null,values)>0;
    }
}
