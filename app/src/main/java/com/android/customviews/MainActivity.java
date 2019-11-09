package com.android.customviews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogoEntradaSalida.enviaDatos{


// Se crea el objeto contexto para poder darle datos a nuestra clase Dialogo
    Context contexto;
    TextView textoImportado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoImportado = (TextView)findViewById(R.id.textView);

// Se inicializa contexto una vez cargada la activity
// De esta manera podemos manejar datos a tiempo real y asi poder acceder a bases de datos(por ejemplo con un Servicio)
// sino puede pasar que esperemos datos que aun no hemos cargado en la activity.
        contexto = this;

        Button botonDialog = (Button)findViewById(R.id.botonMain);
        final Button botonShapes = (Button)findViewById(R.id.buttonShapes);

        botonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

// creamos instancia de nuestra clase especial de dialogos
                new DialogoEntradaSalida(contexto, MainActivity.this);
            }
        });



        botonShapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random =  1 + (int)(Math.random() * 3);
                Toast.makeText(contexto, ""+random, Toast.LENGTH_SHORT).show();
                switch (random){
                    case 1:
                        botonShapes.setBackground(getDrawable(R.drawable.custom_buttom_gradient));
                        break;
                    case 2:
                        botonShapes.setBackground(getDrawable(R.drawable.custom_buttom_shape));
                        break;
                    case 3:
                        botonShapes.setBackground(getDrawable(R.drawable.custom_button_circle));
                        break;
                }
            }
        });
    }


// Sobrecargamos nuestra interfaz para poder recoger los datillos
    @Override
    public void resultadoCuadro(String dato) {
        textoImportado.setText(dato);
    }


    // Ir a slider
    public void goSlider(View v){
        startActivity(new Intent(this, SliderBlur.class));
    }

    //Cambiar estilo de Theme
    public void cambiarEstilo(){
        this.setTheme(R.style.AppThemeDark);
    }
}
