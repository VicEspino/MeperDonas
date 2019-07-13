package com.example.meperdonas;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class ventana_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_principal);


        inicializarBoton();

    }

    private void inicializarBoton() {

        ImageView boton = findViewById(R.id.ivBoton);


        boton.setOnTouchListener(new View.OnTouchListener() {



            @Override
            public boolean onTouch(View v, MotionEvent event) {


                ImageView botonInterno = (ImageView) v;
                Switch sw = findViewById(R.id.swMeper);
                MediaPlayer m;
                if(sw.isChecked()) {
                    m = MediaPlayer.create(ventana_principal.this, R.raw.meperdonas);

                }else{
                    m = MediaPlayer.create(ventana_principal.this, R.raw.meperdonascorto);
                }
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        m.start();
                         botonInterno.setImageResource(R.drawable.botonrojopeque);

                        return true;

                    case MotionEvent.ACTION_UP:
                        botonInterno.setImageResource(R.drawable.botonrojo);
                        botonInterno.performClick();
                        return true;
                }

                return false;
            }
        });

    }


}
