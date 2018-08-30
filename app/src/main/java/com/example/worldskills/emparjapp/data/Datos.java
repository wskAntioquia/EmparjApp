package com.example.worldskills.emparjapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.emparjapp.models.Puntaje;

public class Datos extends SQLiteOpenHelper {
    private SQLiteDatabase bd;
    private Cursor cursor;
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

    public void guardarDatosJuego(Puntaje puntaje){
        bd=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constantes.CAMPO_NOMBRE,puntaje.getNombre());
        values.put(Constantes.CAMPO_PUNTOS,puntaje.getPuntos());
        values.put(Constantes.CAMPO_NIVEL,puntaje.getNivel());
        values.put(Constantes.CAMPO_TIEMPO,puntaje.getTiempo());
         bd.insert(Constantes.TBL_PUNTAJES,null,values);
    }

    public Cursor listarJuegoFacil(){
        bd=getReadableDatabase();
        cursor=bd.rawQuery("SELECT * FROM " + Constantes.TBL_PUNTAJES + " WHERE " +
                                Constantes.CAMPO_NIVEL + " = "+ "'facil'" + " ORDER BY "+
                                Constantes.CAMPO_PUNTOS + " DESC LIMIT 0,4",null);
        if (cursor.moveToFirst()){
            return cursor;
        }else {
            return null;
        }

    }

    public Cursor listarJuegoMedio(){
        bd=getReadableDatabase();
        cursor=bd.rawQuery("SELECT * FROM " + Constantes.TBL_PUNTAJES + " WHERE " +
                Constantes.CAMPO_NIVEL + " = "+ "'medio'" + " ORDER BY "+
                Constantes.CAMPO_PUNTOS + " DESC LIMIT 0,4",null);
        if (cursor.moveToFirst()){
            return cursor;
        }else {
            return null;
        }
    }

    public Cursor listarJuegoDificil(){
        bd=getReadableDatabase();
        cursor=bd.rawQuery("SELECT * FROM " + Constantes.TBL_PUNTAJES + " WHERE " +
                Constantes.CAMPO_NIVEL + " = "+ "'dificil'" + " ORDER BY "+
                Constantes.CAMPO_PUNTOS + " DESC LIMIT 0,4",null);
        if (cursor.moveToFirst()){
            return cursor;
        }else {
            return null;
        }
    }
}
