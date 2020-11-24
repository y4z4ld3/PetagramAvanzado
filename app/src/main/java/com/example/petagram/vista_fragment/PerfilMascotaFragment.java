package com.example.petagram.vista_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.petagram.pojo.Mascota;
import com.example.petagram.R;
import com.example.petagram.adapter.PerfilMascotaAdaptador;
import com.example.petagram.presentador.PerfilMascotaFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilMascotaFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilMascotaFragment extends Fragment implements IPerfilMascotaFragmentView {

    private RecyclerView rvColeccionPerfilMascota;
    private ArrayList<Mascota> coleccion;
    private PerfilMascotaFragmentPresenter perfilMascotaFragmentPresenter;
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v  = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);
        // Inflate the layout for this fragment
        rvColeccionPerfilMascota = (RecyclerView) v.findViewById(R.id.rvMascotasColeccion);
        perfilMascotaFragmentPresenter = new  PerfilMascotaFragmentPresenter(this,getContext());
        return v;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        rvColeccionPerfilMascota.setLayoutManager(glm);
    }

    @Override
    public PerfilMascotaAdaptador crearPerfilMascotaAdaptador(ArrayList<Mascota> coleccion) {
        PerfilMascotaAdaptador perfilMascotaAdaptador = new PerfilMascotaAdaptador(coleccion,getActivity());
        TextView tvNombrePerfilMascota = (TextView) v.findViewById(R.id.tvNombrePerfilMascota);
        if (coleccion != null){
            tvNombrePerfilMascota.setText(coleccion.get(0).getNombre_usuario());
        }
        else {
            Log.i("PerfilMascotaFragment", "Array coleccion esta NULO");
        }
        return perfilMascotaAdaptador;
    }

    @Override
    public void inicializarPerfilMascotaAdaptadorRV(PerfilMascotaAdaptador perfilMascotaAdaptador) {
        rvColeccionPerfilMascota.setAdapter(perfilMascotaAdaptador);
    }
}