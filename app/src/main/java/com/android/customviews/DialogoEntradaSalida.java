package com.android.customviews;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DialogoEntradaSalida {


// Constructor de interfaces para enviarDatos
// Si implementas esta interfaz, recogera datos la activity donde sea implementada
    public interface enviaDatos{
        void resultadoCuadro(String dato);
    }

// Inicializa la interfaz creada
    private enviaDatos interfaz;



// Constructor de objetos dialogo con contexto (se le pasa el contexto de la activity que le llama) y oon nuestra interfaz enviaDatos()
    public DialogoEntradaSalida(Context context, enviaDatos activity){

        interfaz = activity;

        final Dialog dialog = new Dialog(context);



// No queremos titulo de dialogo
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

// Hacer el dialogo con fondo transparente
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

// Aplicar nuestro layout personalizado -
// podemos probar otras combinaciones de entradas y salidas de texto, colores
        dialog.setContentView(R.layout.dialogoentradasalida);

// Si es "true" cuando pulsemos fuera o hacia atras cerrara el dialogo
// Nos puede interesar para forzar al usuario a ingresar un dato importante o elegir
        dialog.setCancelable(true);


        final EditText texto = (EditText)dialog.findViewById(R.id.editText1);

        Button botonEnviar = (Button)dialog.findViewById(R.id.button);

        ImageView flecha = (ImageView) dialog.findViewById(R.id.imageView);
        //flecha.setBackgroundColor(context.getResources().getColor());
        flecha.setBackgroundColor(Color.WHITE);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.resultadoCuadro(texto.getText().toString());
                dialog.dismiss();

            }
        });


// Muestra el dialogo - Esta funcion nos puede servir si necesitamos esperar a una base de datos buscar/cargar informacion en internet.
// Podremos cargar el dialogo
        dialog.show();
    }
}
