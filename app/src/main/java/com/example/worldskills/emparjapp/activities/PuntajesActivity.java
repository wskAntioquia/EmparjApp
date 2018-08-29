package com.example.worldskills.emparjapp.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.worldskills.emparjapp.R;
import com.example.worldskills.emparjapp.data.Constantes;
import com.example.worldskills.emparjapp.data.Datos;

import java.util.ArrayList;

public class PuntajesActivity extends AppCompatActivity {
    private ListView facil,medio,dificil;
    private Datos datos =new Datos(this);
    private Cursor cursor;
    private int camposUI[]={R.id.contentNombre,R.id.contentPuntos};
    private String camposBD[]={Constantes.CAMPO_NOMBRE,Constantes.CAMPO_PUNTOS};
    private SimpleCursorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);

        facil=findViewById(R.id.listaFacil);
        medio=findViewById(R.id.listaMedio);
        dificil=findViewById(R.id.listaDificil);
        cargarListaFacil(facil);
        cargarListaMedio(medio);
        cargarListaDificil(dificil);
    }
    //llena el listView de juego facil con la informacion obtenida de la base de datos
    private void cargarListaDificil(ListView lista) {
        cursor=datos.listarJuegoDificil();
        adapter=new SimpleCursorAdapter(this,R.layout.content_item_list,cursor,camposBD,camposUI);
        lista.setAdapter(adapter);
    }
    //llena el listView de juego medio con la informacion obtenida de la base de datos

    private void cargarListaMedio(ListView lista) {
        cursor=datos.listarJuegoMedio();
        adapter=new SimpleCursorAdapter(this,R.layout.content_item_list,cursor,camposBD,camposUI);
        lista.setAdapter(adapter);
    }
    //llena el listView de juego dificil con la informacion obtenida de la base de datos

    private void cargarListaFacil(ListView lista) {
        cursor=datos.listarJuegoFacil();
        adapter=new SimpleCursorAdapter(this,R.layout.content_item_list,cursor,camposBD,camposUI);
        lista.setAdapter(adapter);
    }


}
