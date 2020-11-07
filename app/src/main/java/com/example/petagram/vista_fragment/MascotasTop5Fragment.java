package com.example.petagram.vista_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagram.R;
import com.example.petagram.adapter.MascotaAdaptador;
import com.example.petagram.pojo.Mascota;
import com.example.petagram.presentador.MascotasTop5Presenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MascotasTop5Fragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class MascotasTop5Fragment extends Fragment implements IMascotasTop5FragmentView {

    private RecyclerView listaMascotasTop5;
    private ArrayList<Mascota> mascotas;
    private MascotasTop5Presenter mascotasTop5Presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascotas_top5, container, false);
        listaMascotasTop5 = (RecyclerView)v.findViewById(R.id.rvMascotasTop5);
        mascotasTop5Presenter = new MascotasTop5Presenter(this,getContext());
        return v;

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasTop5.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearMascotaTop5Adaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas,getActivity());
        return mascotaAdaptador;
    }

    @Override
    public void incializarMascotaTop5AdaptadorRV(MascotaAdaptador mascotaAdaptador) {
        listaMascotasTop5.setAdapter(mascotaAdaptador);
    }
}