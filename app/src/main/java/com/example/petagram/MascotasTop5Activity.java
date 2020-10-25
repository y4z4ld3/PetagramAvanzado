package com.example.petagram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class MascotasTop5Activity extends AppCompatActivity {

    private RecyclerView listaMascotasTop5;
    ArrayList<Mascota> mascotas;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_top5);

        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pawprint);

        listaMascotasTop5 = (RecyclerView)findViewById(R.id.rvMascotasTop5);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasTop5.setLayoutManager(llm);
        inicializarListaMascotas();
        incializarAdaptador();

    }

    public void incializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotasTop5.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Linux",R.drawable.penguin));
        mascotas.add(new Mascota("Lucas",R.drawable.loro));
        mascotas.add(new Mascota("Kitty",R.drawable.gato));
        mascotas.add(new Mascota("Firulais",R.drawable.perro));
        mascotas.add(new Mascota("Doroty",R.drawable.tortuga));

    }
}