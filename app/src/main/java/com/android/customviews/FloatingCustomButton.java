package com.android.customviews;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class FloatingCustomButton extends AppCompatActivity{

        private FloatingActionButton fab_main, fab1_mail, fab2_share, fab_example;
        private Animation fab_open, fab_close, fab_clock, fab_anticlock;
        TextView textview_mail, textview_share, text_example;

        Boolean isOpen = false;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.custom_floating_content);

            fab_main = findViewById(R.id.fab);
            fab1_mail = findViewById(R.id.fab1);
            fab2_share = findViewById(R.id.fab2);
            fab_example = findViewById(R.id.fab3);

            fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
            fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
            fab_clock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_clock);
            fab_anticlock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_anticlock);

            textview_mail = (TextView) findViewById(R.id.textview_mail);
            textview_share = (TextView) findViewById(R.id.textview_share);
            text_example = (TextView) findViewById(R.id.textview_example);

            fab_main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (isOpen) {

                        textview_mail.setVisibility(View.INVISIBLE);
                        textview_share.setVisibility(View.INVISIBLE);
                        text_example.setVisibility(View.INVISIBLE);

                        fab2_share.startAnimation(fab_close);
                        fab1_mail.startAnimation(fab_close);
                        fab_example.startAnimation(fab_close);

                        fab_main.startAnimation(fab_anticlock);

                        fab2_share.setClickable(false);
                        fab_example.setClickable(false);
                        fab1_mail.setClickable(false);

                        isOpen = false;
                    } else {
                        textview_mail.setVisibility(View.VISIBLE);
                        textview_share.setVisibility(View.VISIBLE);
                        text_example.setVisibility(View.VISIBLE);

                        fab2_share.startAnimation(fab_open);
                        fab1_mail.startAnimation(fab_open);
                        fab_example.startAnimation(fab_open);

                        fab_main.startAnimation(fab_clock);

                        fab2_share.setClickable(true);
                        fab1_mail.setClickable(true);
                        fab1_mail.setClickable(true);

                        isOpen = true;
                    }

                }
            });


            fab2_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();

                }
            });

            fab1_mail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Email", Toast.LENGTH_SHORT).show();

                }
            });

            fab_example.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Example", Toast.LENGTH_SHORT).show();

                }
            });


        }
}