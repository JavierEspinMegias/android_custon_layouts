package com.android.customviews;

import android.graphics.LinearGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.sql.Time;

public class SliderBlur extends AppCompatActivity {

    public LinearLayout linearImagen;
    public int i = 0;
    final int[] imagenes = new int[]{R.drawable.photo1, R.drawable.photo2, R.drawable.photo3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_blur);

        linearImagen = (LinearLayout) findViewById(R.id.linearSlider);


        t.start();

    }


    Thread t = new Thread() {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            linearImagen.setBackgroundResource(imagenes[i]);
                            i++;
                            if(i >= imagenes.length){
                                i = 0;
                            }}});
                }}
            catch (InterruptedException e) {
            }}};
}
