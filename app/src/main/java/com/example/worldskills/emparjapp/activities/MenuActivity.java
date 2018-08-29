package com.example.worldskills.emparjapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.worldskills.emparjapp.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void siguienteActivity(View view) {
        switch (view.getId()){
            case R.id.btn_jugar:
                startActivity(new Intent(this,NivelesActivity.class));
                break;
            case R.id.btn_puntajes:
                startActivity(new Intent(this,PuntajesActivity.class));
                break;
            case R.id.btn_configuracion:
                startActivity(new Intent(this,ConfiguracionActivity.class));
                break;
        }
    }
}
