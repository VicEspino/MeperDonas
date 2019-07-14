package com.example.meperdonas;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Objects;

public class ventana_principal extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener

{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_principal );

        mDrawerLayout = findViewById(R.id.activity_ventana_principal_id);

        mToogle = new ActionBarDrawerToggle(ventana_principal.this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


         inicializarBoton();
         ReproductorGato.m = MediaPlayer.create(this, R.raw.meperdonascorto);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void inicializarBoton() {

        ImageView boton = findViewById(R.id.ivBoton);


        boton.setOnTouchListener(new View.OnTouchListener() {



            @Override
            public boolean onTouch(View v, MotionEvent event) {


                ImageView botonInterno = (ImageView) v;
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                         ReproductorGato.m.start();
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



    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return mToogle.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.btn_ayuda){
            //activity ayuda
            Intent intent = new Intent(this,ayuda.class);

            startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.activity_ventana_principal_id);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
