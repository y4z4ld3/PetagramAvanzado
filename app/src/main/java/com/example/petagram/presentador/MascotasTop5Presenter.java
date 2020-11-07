package com.example.petagram.presentador;

import android.content.Context;

import com.example.petagram.db.InteractorTop5Mascotas;
import com.example.petagram.pojo.Mascota;
import com.example.petagram.vista_fragment.IMascotasTop5FragmentView;

import java.util.ArrayList;

public class MascotasTop5Presenter implements IMascotasTop5Presenter{

    private IMascotasTop5FragmentView iMascotasTop5FragmentView;
    private Context context;
    private InteractorTop5Mascotas interactorTop5Mascotas;
    private ArrayList<Mascota> mascotasTop5;

    public MascotasTop5Presenter(IMascotasTop5FragmentView iMascotasTop5FragmentView, Context context) {
        this.iMascotasTop5FragmentView = iMascotasTop5FragmentView;
        this.context = context;
        obtenerTop5Mascotas();
    }

    @Override
    public void obtenerTop5Mascotas() {
        interactorTop5Mascotas = new InteractorTop5Mascotas(context);
        mascotasTop5 = interactorTop5Mascotas.obtenerDatos();
        mostrarTop5Mascotas();
    }

    @Override
    public void mostrarTop5Mascotas() {
        iMascotasTop5FragmentView.incializarMascotaTop5AdaptadorRV(iMascotasTop5FragmentView.crearMascotaTop5Adaptador(mascotasTop5));
        iMascotasTop5FragmentView.generarLinearLayoutVertical();
    }
}
