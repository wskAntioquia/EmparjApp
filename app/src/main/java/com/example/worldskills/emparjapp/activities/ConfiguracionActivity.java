package com.example.worldskills.emparjapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.worldskills.emparjapp.R;

public class ConfiguracionActivity extends AppCompatActivity {

    private Button btn_jugar;
    private TextInputEditText tiempo;
    private TextInputLayout inputLayoutTiempo;
    private SharedPreferences preferences;
    private RadioButton radioConTiempo,radioSinTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        inicializarElementosUI();
        preferences=getSharedPreferences("tiempoJuego",MODE_PRIVATE);
        recuperarConfiguracion();
    }

    public boolean validarCampoTiempo(){
        if(tiempo.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Debe dar un tiempo al juego", Toast.LENGTH_LONG).show();
            return false;
        }
            return true;

    }


    public void irAJugar(View view) {
            btn_jugar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                if (radioConTiempo.isChecked()){
                    if(validarCampoTiempo()) {
                        guardarConfiguracion();
                        Intent intent = new Intent(getApplicationContext(), JuegoConfiguracionActivity.class);
                        intent.putExtra("tiempo", tiempo.getText().toString());
                        startActivity(intent);
                    }
                }else if (radioSinTiempo.isChecked()){

                        startActivity(new Intent(getApplicationContext(),JuegoConfiguracionActivity.class));

                }
                }
            });

    }
    //inicializamos los elementos de la interfaz grafica

    private void inicializarElementosUI() {
        inputLayoutTiempo=findViewById(R.id.inputTiempo);
        btn_jugar=findViewById(R.id.btn_jugar_configuracion);
        tiempo=findViewById(R.id.txt_tiempo);
        radioConTiempo=findViewById(R.id.radio_con_tiempo);
        radioSinTiempo=findViewById(R.id.radio_sin_tiempo);
    }
    //carga los datos guardados en los SharedPreferences
    private void recuperarConfiguracion() {
        String time =preferences.getString("tiempo",null);
        if (time!=null){
            tiempo.setText(time);
        }
    }
    //guarda los datos guardados en los SharedPreferences
    private void guardarConfiguracion() {
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("tiempo",tiempo.getText().toString());
        editor.apply();
    }
    //verifica que radioButton esta precionado para mostra o ocultar el campo de texto del tiempo
    public void onClickRadios(View view) {
        switch (view.getId()){
            case R.id.radio_con_tiempo:
                inputLayoutTiempo.setVisibility(View.VISIBLE);
                break;
            case R.id.radio_sin_tiempo:
                inputLayoutTiempo.setVisibility(View.INVISIBLE);
                break;
        }

    }
}
