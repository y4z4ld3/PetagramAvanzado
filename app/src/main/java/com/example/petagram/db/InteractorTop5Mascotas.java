package com.example.petagram.db;

import android.content.Context;

import com.example.petagram.R;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class InteractorTop5Mascotas {
    private Context context;
    public InteractorTop5Mascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
      /*  ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Linux",R.drawable.penguin));
        mascotas.add(new Mascota("Lucas",R.drawable.loro));
        mascotas.add(new Mascota("Kitty",R.drawable.gato));
        mascotas.add(new Mascota("Firulais",R.drawable.perro));
        mascotas.add(new Mascota("Doroty",R.drawable.tortuga));

       */
        BaseDatos db= new BaseDatos(context);
        return db.obtenerTop5Mascotas();
    }
}
