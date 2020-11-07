package com.example.petagram.vista_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagram.pojo.Mascota;
import com.example.petagram.R;
import com.example.petagram.adapter.MascotaAdaptador;
import com.example.petagram.presentador.IMascotasFragmentPresenter;
import com.example.petagram.presentador.MascotasFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MascotasFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class MascotasFragment extends Fragment implements IMascotasFragmentView {

    private RecyclerView listaMascotas;
    private ArrayList<Mascota> mascotas;
    private MascotasFragmentPresenter mascotasFragmentPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_mascotas, container, false);
        // Inflate the layout for this fragment
        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        mascotasFragmentPresenter = new MascotasFragmentPresenter(this,getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearMascotaAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas,getActivity());
        return mascotaAdaptador;
    }

    @Override
    public void incializarMascotaAdaptadorRV(MascotaAdaptador mascotaAdaptador) {
        listaMascotas.setAdapter(mascotaAdaptador);
    }
}