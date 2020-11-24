package com.example.petagram.db;

import android.content.Context;

import com.example.petagram.R;
import com.example.petagram.pojo.Mascota;


import java.util.ArrayList;

public class InteractorPerfilMascota {
    private Context context;

    public InteractorPerfilMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        ArrayList<Mascota> coleccion = new ArrayList<>();

        coleccion.add(new Mascota(R.drawable.perro_perfil,6));
        coleccion.add(new Mascota(R.drawable.perro_perfil,5));
        coleccion.add(new Mascota(R.drawable.perro_perfil,0));
        coleccion.add(new Mascota(R.drawable.perro_perfil,4));
        coleccion.add(new Mascota(R.drawable.perro_perfil,6));
        coleccion.add(new Mascota(R.drawable.perro_perfil,2));
        coleccion.add(new Mascota(R.drawable.perro_perfil,1));
        coleccion.add(new Mascota(R.drawable.perro_perfil,4));
        coleccion.add(new Mascota(R.drawable.perro_perfil,6));
        coleccion.add(new Mascota(R.drawable.perro_perfil,2));
        coleccion.add(new Mascota(R.drawable.perro_perfil,1));

        return coleccion;
    }
    /*
    public ArrayList<Mascota> obtenerDatosPerfil(){
        ArrayList<Mascota> coleccion = new ArrayList<>();
        return coleccion;
    }
*/

}
