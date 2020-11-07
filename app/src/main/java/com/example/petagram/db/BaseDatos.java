package com.example.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConfigBaseDatos.DATABASE_NAME, null, ConfigBaseDatos.DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTabla =    "CREATE TABLE " + ConfigBaseDatos.TABLE_MASCOTA + "(" +
                                    ConfigBaseDatos.TABLE_MASCOTA_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                    ConfigBaseDatos.TABLE_MASCOTA_NOMBRE    + " TEXT, "+
                                    ConfigBaseDatos.TABLE_MASCOTA_FOTO      + " INTEGER, "+
                                    ConfigBaseDatos.TABLE_MASCOTA_VOTOS     + " INTEGER"+
                                    ")";
        sqLiteDatabase.execSQL(queryCrearTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ ConfigBaseDatos.TABLE_MASCOTA);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM "+ConfigBaseDatos.TABLE_MASCOTA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros =  db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId_mascota(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setVotos(registros.getInt(3));
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConfigBaseDatos.TABLE_MASCOTA,null,contentValues);
        db.close();
    }

    public boolean validarTablaVacia(String tabla){
        SQLiteDatabase db = this.getWritableDatabase();
        return DatabaseUtils.queryNumEntries(db, tabla) == 0;
    }

    public void marcarVotoMascota(ContentValues contentValues,String condicionWhere){
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConfigBaseDatos.TABLE_MASCOTA,contentValues,condicionWhere,null);
        db.close();
    }

    public ArrayList<Mascota> obtenerTop5Mascotas(){
        ArrayList<Mascota> mascotasTop5 = new ArrayList<>();

        String query = "SELECT  *  FROM " + ConfigBaseDatos.TABLE_MASCOTA +
                       " WHERE "          + ConfigBaseDatos.TABLE_MASCOTA_VOTOS +" > 0 " +
                       " ORDER BY "       + ConfigBaseDatos.TABLE_MASCOTA_VOTOS +" DESC" +
                       " LIMIT 5 ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros =  db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId_mascota(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setVotos(registros.getInt(3));
            mascotasTop5.add(mascotaActual);
        }
        db.close();
        return mascotasTop5;
    }
}
