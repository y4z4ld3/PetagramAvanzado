package com.example.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.petagram.R;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class InteractorMascotas {

   private final Context context;
    public InteractorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /* ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Firulais", R.drawable.perro));
        mascotas.add(new Mascota("Kitty",R.drawable.gato));
        mascotas.add(new Mascota("Doroty",R.drawable.tortuga));
        mascotas.add(new Mascota("Lucas",R.drawable.loro));
        mascotas.add(new Mascota("Rogger",R.drawable.bunny));
        mascotas.add(new Mascota("Doroty",R.drawable.pez));
        mascotas.add(new Mascota("Linux",R.drawable.penguin));

        return mascotas;
         */
        BaseDatos db= new BaseDatos(context);
        if(db.validarTablaVacia(ConfigBaseDatos.TABLE_MASCOTA)){ //// VALIDO QUE LA TABLA ESTÉ VACIA
            insertarMascota(db);
        }

        return db.obtenerTodasLasMascotas();
    }

    public void insertarMascota(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_NOMBRE,"Firulais");
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.perro);
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_VOTOS,0);
        db.insertarMascota(contentValues);

        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_NOMBRE,"Kitty");
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.gato);
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_VOTOS,0);
        db.insertarMascota(contentValues);

        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_NOMBRE,"Felicidad");
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.tortuga);
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_VOTOS,0);
        db.insertarMascota(contentValues);

        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_NOMBRE,"Lucas");
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.loro);
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_VOTOS,0);
        db.insertarMascota(contentValues);

        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_NOMBRE,"Rogger");
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.bunny);
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_VOTOS,0);
        db.insertarMascota(contentValues);

        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_NOMBRE,"Doroty");
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.pez);
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_VOTOS,0);
        db.insertarMascota(contentValues);

        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_NOMBRE,"Linux");
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.penguin);
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_VOTOS,0);
        db.insertarMascota(contentValues);
    }

    public void votarMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        String condicionWhere;
        contentValues.put(ConfigBaseDatos.TABLE_MASCOTA_VOTOS,mascota.getVotos());
        condicionWhere = ConfigBaseDatos.TABLE_MASCOTA_ID + "=" +  mascota.getId_mascota();
        db.marcarVotoMascota(contentValues,condicionWhere);
    }

}
