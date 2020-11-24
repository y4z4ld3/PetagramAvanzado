package com.example.petagram.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.pojo.Mascota;
import com.example.petagram.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PerfilMascotaAdaptador extends RecyclerView.Adapter<PerfilMascotaAdaptador.PerfilViewHolder>{

    ArrayList<Mascota> mascotas_coleccion;
    //ArrayList<MascotaPerfil> mascotas_coleccion;
    Activity activity;

    /**/
    public PerfilMascotaAdaptador(ArrayList<Mascota> lista_coleccion, Activity activity){
        this.mascotas_coleccion = lista_coleccion;
        this.activity = activity;
    }


    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota,parent,false);
        return new PerfilMascotaAdaptador.PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder perfilViewHolder, int position) {
        final Mascota mascota_hold = mascotas_coleccion.get(position);
        //perfilViewHolder.imgFotoColeccionMascota.setImageResource(mascota_hold.getFoto());
        String UrlFoto = mascota_hold.getUrl_foto_media();
        if (UrlFoto == null){
            Log.i("Picasso: ", "Foto Vacia o Nula " + mascota_hold.toString());
        }
        else{
            Log.i("PicassoURL: ", UrlFoto);
        }

        Picasso.with(activity)
                .load(mascota_hold.getUrl_foto_media())
                .placeholder(R.drawable.dogface_100527)
                .into(perfilViewHolder.imgFotoColeccionMascota);
        perfilViewHolder.tvVotosColeccion.setText(String.valueOf(mascota_hold.getVotos()));
        perfilViewHolder.imgHuesoAmarilloColeccion.setImageResource(R.drawable.hueso_amarillo);
        //Log.i("UserName: ", mascota_hold.getNombre_usuario());

        //perfilViewHolder.tvNombrePerfilMascota.setText(mascota_hold.getNombre_usuario());
    }

    @Override
    public int getItemCount() {
        return mascotas_coleccion.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageView imgFotoColeccionMascota;
        private AppCompatTextView tvVotosColeccion;
        private AppCompatImageView imgHuesoAmarilloColeccion;

        private TextView tvNombrePerfilMascota;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoColeccionMascota      = (AppCompatImageView)itemView.findViewById(R.id.imgFotoColeccionMascota);
            tvVotosColeccion             = (AppCompatTextView)itemView.findViewById(R.id.tvVotosColeccion);
            imgHuesoAmarilloColeccion    = (AppCompatImageView)itemView.findViewById(R.id.imgHuesoAmarilloColeccion);
            tvNombrePerfilMascota        = (TextView)itemView.findViewById(R.id.tvNombrePerfilMascota);

        }
    }
}
