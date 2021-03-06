package com.example.worldskills.emparjapp.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.worldskills.emparjapp.R;
import com.example.worldskills.emparjapp.models.Puntaje;

public class InicioActivity extends AppCompatActivity {

    private TextInputEditText nombreJ1,nombreJ2;
    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        inicializar();
    }

    //valida que los campos no esten vacios
    private boolean validarCampos(){
        if (nombreJ1.getText().toString().isEmpty()  || nombreJ2.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Debe llenar ambos campos", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    //que sucede si preciono el boton de seguir
    public void seguir(View view) {
        if (validarCampos()){

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //falta validar campos
                    Puntaje.nomJ1=nombreJ1.getText().toString();
                    Puntaje.nomJ2=nombreJ2.getText().toString();
                    startActivity(new Intent(getApplicationContext(),MenuActivity.class));
                }
            });
        }
    }


    //inicializamos los elementos de la interfaz grafica
    private void inicializar() {
        nombreJ1=findViewById(R.id.nomJ1);
        nombreJ2=findViewById(R.id.nomJ2);
        btnNext=findViewById(R.id.btn_next);
    }
}
