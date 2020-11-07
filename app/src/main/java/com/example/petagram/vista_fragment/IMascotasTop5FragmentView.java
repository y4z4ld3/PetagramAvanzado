package com.example.petagram.vista_fragment;

import com.example.petagram.adapter.MascotaAdaptador;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IMascotasTop5FragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearMascotaTop5Adaptador(ArrayList<Mascota> mascotas);

    public void incializarMascotaTop5AdaptadorRV(MascotaAdaptador mascotaAdaptador);

}
