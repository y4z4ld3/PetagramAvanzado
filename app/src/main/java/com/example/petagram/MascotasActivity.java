package com.example.petagram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class MascotasActivity extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macotas);


        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        agregarFAB();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pawprint);
        //getSupportActionBar().setTitle(app_name);

        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        incializarAdaptador();

    }

    public void incializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Firulais",R.drawable.perro));
        mascotas.add(new Mascota("Kitty",R.drawable.gato));
        mascotas.add(new Mascota("Doroty",R.drawable.tortuga));
        mascotas.add(new Mascota("Lucas",R.drawable.loro));
        mascotas.add(new Mascota("Rogger",R.drawable.bunny));
        mascotas.add(new Mascota("Doroty",R.drawable.pez));
        mascotas.add(new Mascota("Linux",R.drawable.penguin));
    }

    public void agregarFAB() {
        FloatingActionButton miFAB = (FloatingActionButton)findViewById(R.id.fabMiFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(),getResources().getString(R.string.mensaje),Toast.LENGTH_SHORT).show();
                Snackbar.make(view,getResources().getString(R.string.texto_accion),Snackbar.LENGTH_SHORT)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SANAKBAR","Click en SnackBar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.imgEstrella:
                irAMascotaTop5();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void irAMascotaTop5(){
        Bundle extras = new Bundle();
        Intent intent = new Intent(this,MascotasTop5Activity.class);
        /*
        ArrayList<Mascota> mascotastop5 = new ArrayList<Mascota>();
        Collections.sort(mascotas);
        for (int i=0; i<4; i++){
            mascotastop5.add(new Mascota(mascotas.get(i).getNombre(),mascotas.get(i).getFoto()));
        }
        //extras.putSerializable("pListaMascotas",(Serializable)mascotastop5);
        // intent.putExtra("pParametros",extras);

         */
        startActivity(intent);
    }
}