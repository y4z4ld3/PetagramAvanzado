package com.example.petagram.vista_fragment;

import com.example.petagram.adapter.PerfilMascotaAdaptador;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IPerfilMascotaFragmentView {

    public void generarGridLayout();

    public PerfilMascotaAdaptador crearPerfilMascotaAdaptador(ArrayList<Mascota> coleccion);

    public void inicializarPerfilMascotaAdaptadorRV(PerfilMascotaAdaptador perfilMascotaAdaptador);
}
