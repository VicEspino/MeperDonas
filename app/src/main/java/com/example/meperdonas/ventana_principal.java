package com.example.meperdonas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

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

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:

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
