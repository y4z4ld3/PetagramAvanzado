package com.example.petagram.vista_fragment;

import com.example.petagram.adapter.MascotaAdaptador;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IMascotasFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearMascotaAdaptador(ArrayList<Mascota> mascotas);

    public void incializarMascotaAdaptadorRV(MascotaAdaptador mascotaAdaptador);

}
