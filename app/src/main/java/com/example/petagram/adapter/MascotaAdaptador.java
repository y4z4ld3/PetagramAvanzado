package com.example.petagram.adapter;


import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.petagram.db.InteractorMascotas;
import com.example.petagram.pojo.Mascota;
import com.example.petagram.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    private static final int VOTO = 1;
    ArrayList<Mascota> mascotas_ad;
    Activity activity;


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas_ad = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota_hold = mascotas_ad.get(position);
        mascotaViewHolder.imgFotoMascota.setImageResource(mascota_hold.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota_hold.getNombre());
        mascotaViewHolder.tvVotos.setText(String.valueOf(mascota_hold.getVotos()));
        mascotaViewHolder.imgHuesoAmarillo.setImageResource(R.drawable.hueso_amarillo);
        mascotaViewHolder.imgHuesoBlanco.setImageResource(R.drawable.hueso);

        if (activity.getLocalClassName().equals("MascotasActivity")){
            mascotaViewHolder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mascota_hold.setVotos(mascota_hold.getVotos()+VOTO);
                    mascotaViewHolder.tvVotos.setText(String.valueOf(mascota_hold.getVotos()));
                    Toast toast;
                    String mensaje = activity.getResources().getString(R.string.mensaje)+ " " + mascota_hold.getNombre() ;
                    toast = Toast.makeText(activity, mensaje ,Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();

                    InteractorMascotas interactorMascotas = new InteractorMascotas(activity);
                    interactorMascotas.votarMascota(mascota_hold);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mascotas_ad.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageView imgFotoMascota;
        private AppCompatImageView imgHuesoBlanco;
        private AppCompatTextView tvNombre;
        private AppCompatTextView tvVotos;
        private AppCompatImageView imgHuesoAmarillo;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoMascota      = (AppCompatImageView)itemView.findViewById(R.id.imgFotoMascota);
            imgHuesoBlanco      = (AppCompatImageView)itemView.findViewById(R.id.imgHuesoBlanco);
            tvNombre            = (AppCompatTextView)itemView.findViewById(R.id.tvNombre);
            tvVotos             = (AppCompatTextView)itemView.findViewById(R.id.tvVotos);
            imgHuesoAmarillo    = (AppCompatImageView)itemView.findViewById(R.id.imgHuesoAmarillo);
        }

    }



}
