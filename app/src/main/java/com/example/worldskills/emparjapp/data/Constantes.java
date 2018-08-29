package com.example.worldskills.emparjapp.data;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.BaseColumns;
import android.support.v7.app.AlertDialog;

public class Constantes implements BaseColumns {

    public static String TBL_PUNTAJES="tbl_puntajes";
    public static String CAMPO_NOMBRE="nombre";
    public static String CAMPO_PUNTOS="puntos";
    public static String CAMPO_NIVEL="nivel";
    public static String CAMPO_TIEMPO="tiempo";

    public static String SQL_QUERY="CREATE TABLE "+Constantes.TBL_PUNTAJES + "("+
            Constantes._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            Constantes.CAMPO_NOMBRE + " TEXT,"+
            Constantes.CAMPO_PUNTOS + " INTEGER,"+
            Constantes.CAMPO_NIVEL + " TEXT,"+
            Constantes.CAMPO_TIEMPO + " TEXT)";

    public static void dialogResultados(final Activity activity, final String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle("Resultados")
                .setMessage(message)
                .setPositiveButton("Facebook", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT,message);
                        intent.setType("text/plain");
                        intent.setPackage("com.facebook.katana");
                        activity.startActivity(intent);


                    }
                })
                .setNegativeButton("twitter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT,message);
                        intent.setType("text/plain");
                        intent.setPackage("com.twitter.android");
                        activity.startActivity(intent);
                        activity.finish();


                    }
                })
                .setNeutralButton("Terminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        activity.finish();

                    }
                })
                .setCancelable(false);
        AlertDialog dialog=builder.create();
        dialog.show();
    }

}
