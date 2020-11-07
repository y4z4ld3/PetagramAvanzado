package com.example.petagram.presentador;

import android.content.Context;

import com.example.petagram.db.InteractorMascotas;
import com.example.petagram.pojo.Mascota;
import com.example.petagram.vista_fragment.IMascotasFragmentView;

import java.util.ArrayList;

public class MascotasFragmentPresenter implements IMascotasFragmentPresenter {

    private IMascotasFragmentView iMascotasFragmentView;
    private Context context;
    private InteractorMascotas interactorMascotas;
    private ArrayList<Mascota> mascotas;

    public MascotasFragmentPresenter(IMascotasFragmentView iMascotasFragmentView, Context context) {
        this.iMascotasFragmentView = iMascotasFragmentView;
        this.context  = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        interactorMascotas = new InteractorMascotas(context);
        mascotas= interactorMascotas.obtenerDatos();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iMascotasFragmentView.incializarMascotaAdaptadorRV(iMascotasFragmentView.crearMascotaAdaptador(mascotas));
        iMascotasFragmentView.generarLinearLayoutVertical();
    }
}
