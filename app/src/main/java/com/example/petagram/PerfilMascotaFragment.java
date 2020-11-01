package com.example.petagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilMascotaFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilMascotaFragment extends Fragment {

    private RecyclerView rvColeccionPerfilMascota;
    ArrayList<Mascota> coleccion;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        // Inflate the layout for this fragment
        rvColeccionPerfilMascota = (RecyclerView) v.findViewById(R.id.rvMascotasColeccion);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        rvColeccionPerfilMascota.setLayoutManager(glm);
        inicializarColeccionPerfil();
        incializarAdaptador();
        // Inflate the layout for this fragment
        return v;

    }

    public void incializarAdaptador(){
        PerfilMascotaAdaptador adaptador = new PerfilMascotaAdaptador(coleccion,getActivity());
        rvColeccionPerfilMascota.setAdapter(adaptador);
    }

    public void inicializarColeccionPerfil(){
        coleccion = new ArrayList<>();

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

    }
}