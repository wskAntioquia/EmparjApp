package com.example.worldskills.emparjapp.activities;

import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.emparjapp.R;
import com.example.worldskills.emparjapp.data.Constantes;
import com.example.worldskills.emparjapp.data.Datos;
import com.example.worldskills.emparjapp.models.Puntaje;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class JuegoDificilActivity extends AppCompatActivity {
    private TextView nombreJ1,nombreJ2,puntosJugador_1,puntosJugador_2;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16;
    private Integer cartasArray[]={11,12,13,14,15,16,17,18,21,22,23,24,25,26,27,28};
    private int im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12,im13,im14,im15,im16;
    private Random random=new Random();
    private MediaPlayer player;
    private int primeraSeleccion,segundaSeleccion,primeraCarta,segundaCarta,numeroCarta=1,puntosJ1=0,puntosJ2=0,turno;
    private String nivel="dificil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_dificil);
        inicializarElementosUI();
        barajarCartas();
        asignarEtiquetas();
        cargarParejas();
        int turnoAzar=random.nextInt(2);
        if (turnoAzar==1){
            turno=1;
            nombreJ1.setTextColor(Color.BLACK);
            puntosJugador_1.setTextColor(Color.BLACK);
            nombreJ2.setTextColor(Color.GRAY);
            puntosJugador_2.setTextColor(Color.GRAY);
        }else {
            turno=2;
            nombreJ1.setTextColor(Color.GRAY);
            puntosJugador_1.setTextColor(Color.GRAY);
            nombreJ2.setTextColor(Color.BLACK);
            puntosJugador_2.setTextColor(Color.BLACK);
        }
    }

    private void cargarParejas() {
        im1=R.drawable.s_1;
        im2=R.drawable.s_2;
        im3=R.drawable.s_3;
        im4=R.drawable.s_4;
        im5=R.drawable.s_5;
        im6=R.drawable.s_6;
        im7=R.drawable.s_7;
        im8 =R.drawable.s_8;
        im9=R.drawable.s_10;
        im10=R.drawable.s_20;
        im11=R.drawable.s_30;
        im12=R.drawable.s_40;
        im13=R.drawable.s_50;
        im14=R.drawable.s_60;
        im15=R.drawable.s_70;
        im16=R.drawable.s_80;

    }

    private void asignarEtiquetas() {
        img1.setTag("0");
        img2.setTag("1");
        img3.setTag("2");
        img4.setTag("3");
        img5.setTag("4");
        img6.setTag("5");
        img7.setTag("6");
        img8.setTag("7");
        img9.setTag("8");
        img10.setTag("9");
        img11.setTag("10");
        img12.setTag("11");
        img13.setTag("12");
        img14.setTag("13");
        img15.setTag("14");
        img16.setTag("15");
    }
    //baraja todas las cartas del juego para que siempre queden de forma aleatorea
    private void barajarCartas() {
        Collections.shuffle(Arrays.asList(cartasArray));
    }
    //inicializa todos los elementos de la interfaz frafica
    private void inicializarElementosUI() {
         nombreJ1=findViewById(R.id.nombreJ1);
         nombreJ2=findViewById(R.id.nombreJ2);
         nombreJ1.setText(Puntaje.nomJ1);
         nombreJ2.setText(Puntaje.nomJ2);
         puntosJugador_1=findViewById(R.id.puntosJ1);
         puntosJugador_2=findViewById(R.id.puntosJ2);

         img1=findViewById(R.id.img_dificil_1);
         img2=findViewById(R.id.img_dificil_2);
         img3=findViewById(R.id.img_dificil_3);
         img4=findViewById(R.id.img_dificil_4);
         img5=findViewById(R.id.img_dificil_5);
         img6=findViewById(R.id.img_dificil_6);
         img7=findViewById(R.id.img_dificil_7);
         img8=findViewById(R.id.img_dificil_8);
         img9=findViewById(R.id.img_dificil_9);
         img10=findViewById(R.id.img_dificil_10);
         img11=findViewById(R.id.img_dificil_11);
         img12=findViewById(R.id.img_dificil_12);
         img13=findViewById(R.id.img_dificil_13);
         img14=findViewById(R.id.img_dificil_14);
         img15=findViewById(R.id.img_dificil_15);
         img16=findViewById(R.id.img_dificil_16);
    }



    private void habilitarCartas(){
        img1.setEnabled(true);
        img2.setEnabled(true);
        img3.setEnabled(true);
        img4.setEnabled(true);
        img5.setEnabled(true);
        img6.setEnabled(true);
        img7.setEnabled(true);
        img8.setEnabled(true);
        img9.setEnabled(true);
        img10.setEnabled(true);
        img11.setEnabled(true);
        img12.setEnabled(true);
        img13.setEnabled(true);
        img14.setEnabled(true);
        img15.setEnabled(true);
        img16.setEnabled(true);
    }

    private void desabilitarCartas(){
        img1.setEnabled(false);
        img2.setEnabled(false);
        img3.setEnabled(false);
        img4.setEnabled(false);
        img5.setEnabled(false);
        img6.setEnabled(false);
        img7.setEnabled(false);
        img8.setEnabled(false);
        img9.setEnabled(false);
        img10.setEnabled(false);
        img11.setEnabled(false);
        img12.setEnabled(false);
        img13.setEnabled(false);
        img14.setEnabled(false);
        img15.setEnabled(false);
        img16.setEnabled(false);
    }
    //envia la imagen "no.png" a todos los imageview de la interfaz grafica
    private void voltearCartas(){
        img1.setImageResource(R.drawable.no);
        img2.setImageResource(R.drawable.no);
        img3.setImageResource(R.drawable.no);
        img4.setImageResource(R.drawable.no);
        img5.setImageResource(R.drawable.no);
        img6.setImageResource(R.drawable.no);
        img7.setImageResource(R.drawable.no);
        img8.setImageResource(R.drawable.no);
        img9.setImageResource(R.drawable.no);
        img10.setImageResource(R.drawable.no);
        img11.setImageResource(R.drawable.no);
        img12.setImageResource(R.drawable.no);
        img13.setImageResource(R.drawable.no);
        img14.setImageResource(R.drawable.no);
        img15.setImageResource(R.drawable.no);
        img16.setImageResource(R.drawable.no);
    }

    //captura el onClick de todas las imagens de la interfaz grafica
    public void imagenSeleccionada(View view) {
        int tag=Integer.parseInt((String) view.getTag());
        if (view.getId()==img1.getId()){
            asignarParejas(img1,tag);
        }
        if (view.getId()==img2.getId()){
            asignarParejas(img2,tag);
        }
        if (view.getId()==img3.getId()){
            asignarParejas(img3,tag);
        }
        if (view.getId()==img4.getId()){
            asignarParejas(img4,tag);
        }
        if (view.getId()==img5.getId()){
            asignarParejas(img5,tag);
        }
        if (view.getId()==img6.getId()){
            asignarParejas(img6,tag);
        }
        if (view.getId()==img7.getId()){
            asignarParejas(img7,tag);
        }
        if (view.getId()==img8.getId()){
            asignarParejas(img8,tag);
        }
        if (view.getId()==img9.getId()){
            asignarParejas(img9,tag);
        }
        if (view.getId()==img10.getId()){
            asignarParejas(img10,tag);
        }
        if (view.getId()==img11.getId()){
            asignarParejas(img11,tag);
        }
        if (view.getId()==img12.getId()){
            asignarParejas(img12,tag);
        }
        if (view.getId()==img13.getId()){
            asignarParejas(img13,tag);
        }
        if (view.getId()==img14.getId()){
            asignarParejas(img14,tag);
        }
        if (view.getId()==img15.getId()){
            asignarParejas(img15,tag);
        }
        if (view.getId()==img16.getId()){
            asignarParejas(img16,tag);
        }

    }

    private void asignarParejas(ImageView img, int tag) {
        switch (cartasArray[tag]){
            case 11:img.setImageResource(R.drawable.s_1);
                break;
            case 12:img.setImageResource(R.drawable.s_2);
                break;
            case 13:img.setImageResource(R.drawable.s_3);
                break;
            case 14:img.setImageResource(R.drawable.s_4);
                break;
            case 15:img.setImageResource(R.drawable.s_5);
                break;
            case 16:img.setImageResource(R.drawable.s_6);
                break;
            case 17:img.setImageResource(R.drawable.s_7);
                break;
            case 18:img.setImageResource(R.drawable.s_8);
                break;
            case 21:img.setImageResource(R.drawable.s_10);
                break;
            case 22:img.setImageResource(R.drawable.s_20);
                break;
            case 23:img.setImageResource(R.drawable.s_30);
                break;
            case 24:img.setImageResource(R.drawable.s_40);
                break;
            case 25:img.setImageResource(R.drawable.s_50);
                break;
            case 26:img.setImageResource(R.drawable.s_60);
                break;
            case 27:img.setImageResource(R.drawable.s_70);
                break;
            case 28:img.setImageResource(R.drawable.s_80);
                break;
        }
        if (numeroCarta==1){
            primeraCarta=cartasArray[tag];
            if (primeraCarta>20){
                primeraCarta=primeraCarta-10;
            }
            numeroCarta=2;
            img.setEnabled(false);
            primeraSeleccion=tag;
        }else if (numeroCarta==2){
            segundaCarta=cartasArray[tag];
            if (segundaCarta>20){
                segundaCarta=segundaCarta-10;
            }
            numeroCarta=1;
            desabilitarCartas();
            segundaSeleccion=tag;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    verificarCartas();
                }
            },1000);
        }
    }

    private void verificarCartas() {
        if (primeraCarta==segundaCarta){
            player=MediaPlayer.create(this,R.raw.win1);
            player.start();
            switch (primeraSeleccion){
                case 0:img1.setVisibility(View.INVISIBLE);
                    break;
                case 1:img2.setVisibility(View.INVISIBLE);
                    break;
                case 2:img3.setVisibility(View.INVISIBLE);
                    break;
                case 3:img4.setVisibility(View.INVISIBLE);
                    break;
                case 4:img5.setVisibility(View.INVISIBLE);
                    break;
                case 5:img6.setVisibility(View.INVISIBLE);
                    break;
                case 6:img7.setVisibility(View.INVISIBLE);
                    break;
                case 7:img8.setVisibility(View.INVISIBLE);
                    break;
                case 8:img9.setVisibility(View.INVISIBLE);
                    break;
                case 9:img10.setVisibility(View.INVISIBLE);
                    break;
                case 10:img11.setVisibility(View.INVISIBLE);
                    break;
                case 11:img12.setVisibility(View.INVISIBLE);
                    break;
                case 12:img13.setVisibility(View.INVISIBLE);
                    break;
                case 13:img14.setVisibility(View.INVISIBLE);
                    break;
                case 14:img15.setVisibility(View.INVISIBLE);
                    break;
                case 15:img16.setVisibility(View.INVISIBLE);
                    break;
            }
            switch (segundaSeleccion){
                case 0:img1.setVisibility(View.INVISIBLE);
                    break;
                case 1:img2.setVisibility(View.INVISIBLE);
                    break;
                case 2:img3.setVisibility(View.INVISIBLE);
                    break;
                case 3:img4.setVisibility(View.INVISIBLE);
                    break;
                case 4:img5.setVisibility(View.INVISIBLE);
                    break;
                case 5:img6.setVisibility(View.INVISIBLE);
                    break;
                case 6:img7.setVisibility(View.INVISIBLE);
                    break;
                case 7:img8.setVisibility(View.INVISIBLE);
                    break;
                case 8:img9.setVisibility(View.INVISIBLE);
                    break;
                case 9:img10.setVisibility(View.INVISIBLE);
                    break;
                case 10:img11.setVisibility(View.INVISIBLE);
                    break;
                case 11:img12.setVisibility(View.INVISIBLE);
                    break;
                case 12:img13.setVisibility(View.INVISIBLE);
                    break;
                case 13:img14.setVisibility(View.INVISIBLE);
                    break;
                case 14:img15.setVisibility(View.INVISIBLE);
                    break;
                case 15:img16.setVisibility(View.INVISIBLE);
                    break;
            }
            if (turno==1){
                puntosJ1=puntosJ1+100;
                puntosJugador_1.setText(puntosJ1+"");
            }else if (turno==2){
                puntosJ2=puntosJ2+100;
                puntosJugador_2.setText(puntosJ2+"");
            }
        }else {
            player=MediaPlayer.create(this,R.raw.lose1);
            player.start();
            voltearCartas();
            if (turno==1){
                puntosJ1=puntosJ1-2;
                if (puntosJ1<=0){
                    puntosJ1=0;
                    puntosJugador_1.setText("0");
                }
                puntosJugador_1.setText(puntosJ1+"");
                turno=2;
                nombreJ1.setTextColor(Color.GRAY);
                puntosJugador_1.setTextColor(Color.GRAY);
                nombreJ2.setTextColor(Color.BLACK);
                puntosJugador_2.setTextColor(Color.BLACK);
            }else if (turno==2){
                puntosJ2=puntosJ2-2;
                if (puntosJ2<=0){
                    puntosJ2=0;
                    puntosJugador_2.setText("0");
                }
                puntosJugador_2.setText(puntosJ2+"");
                turno=1;
                nombreJ1.setTextColor(Color.BLACK);
                puntosJugador_1.setTextColor(Color.BLACK);
                nombreJ2.setTextColor(Color.GRAY);
                puntosJugador_2.setTextColor(Color.GRAY);
            }
        }
       verificarUltimaCarta();
        habilitarCartas();
    }
    /*valida la  visivilidad de todas las imagenes del juego,
     muestra los resultados del juego y gurada la informacion en la base de datos SQLite*/
    private void verificarUltimaCarta() {
        if (img1.getVisibility()==View.INVISIBLE &&
            img2.getVisibility()==View.INVISIBLE &&
            img3.getVisibility()==View.INVISIBLE &&
            img4.getVisibility()==View.INVISIBLE &&
            img5.getVisibility()==View.INVISIBLE &&
            img6.getVisibility()==View.INVISIBLE &&
            img7.getVisibility()==View.INVISIBLE &&
            img8.getVisibility()==View.INVISIBLE &&
            img9.getVisibility()==View.INVISIBLE &&
            img10.getVisibility()==View.INVISIBLE &&
            img11.getVisibility()==View.INVISIBLE &&
            img12.getVisibility()==View.INVISIBLE &&
            img13.getVisibility()==View.INVISIBLE &&
            img14.getVisibility()==View.INVISIBLE &&
            img15.getVisibility()==View.INVISIBLE &&
            img16.getVisibility()==View.INVISIBLE ){

            Datos datos=new Datos(this);
            Puntaje puntaje =new Puntaje();
            if (puntosJ1>puntosJ2){
                puntaje.setNombre(nombreJ1.getText().toString());
                puntaje.setPuntos(puntosJ1);
                puntaje.setNivel(nivel);
            }else {
                puntaje.setNombre(nombreJ2.getText().toString());
                puntaje.setPuntos(puntosJ2);
                puntaje.setNivel(nivel);
            }
            if (datos.guardarDatosJuego(puntaje)){
                Toast.makeText(this, "Guardo", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "No Guardo", Toast.LENGTH_SHORT).show();
            }

            String message=nombreJ1.getText().toString() + ":" +puntosJ1+ "\n"+
                            nombreJ2.getText().toString() + ":"+puntosJ2 ;

            Constantes.dialogResultados(JuegoDificilActivity.this,message);



        }
    }
}
