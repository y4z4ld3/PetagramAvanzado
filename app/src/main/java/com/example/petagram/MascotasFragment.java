package com.example.petagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MascotasFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class MascotasFragment extends Fragment {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_mascotas, container, false);
        // Inflate the layout for this fragment
        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        incializarAdaptador();
        return v;
    }

    public void incializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
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
}