package com.example.worldskills.emparjapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.worldskills.emparjapp.R;

public class NivelesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);
    }

    public void jugar(View view) {
        switch (view.getId()){
            case R.id.btn_juego_facil:
                startActivity(new Intent(this,JuegoFacilActivity.class));
                break;
            case R.id.btn_juego_medio:
                startActivity(new Intent(this,JuegoMedioActivity.class));
                break;
            case R.id.btn_juego_dificil:
                startActivity(new Intent(this,JuegoDificilActivity.class));
                break;
        }
    }
}
