package com.example.petagram.presentador;

import android.content.Context;

import com.example.petagram.db.InteractorMascotas;
import com.example.petagram.db.InteractorPerfilMascota;
import com.example.petagram.pojo.Mascota;
import com.example.petagram.vista_fragment.IMascotasFragmentView;
import com.example.petagram.vista_fragment.IPerfilMascotaFragmentView;

import java.util.ArrayList;

public class PerfilMascotaFragmentPresenter implements IPerfilMascotaFragmentPresenter{

    private IPerfilMascotaFragmentView iPerfilMascotaFragmentView;
    private Context context;
    private InteractorPerfilMascota interactorPerfilMascota;
    private ArrayList<Mascota> coleccion;

    public PerfilMascotaFragmentPresenter(IPerfilMascotaFragmentView iPerfilMascotaFragmentView, Context context) {
        this.iPerfilMascotaFragmentView = iPerfilMascotaFragmentView;
        this.context = context;
        obtenerPerfilMascota();
    }

    @Override
    public void obtenerPerfilMascota() {
        interactorPerfilMascota = new InteractorPerfilMascota(context);
        coleccion = interactorPerfilMascota.obtenerDatos();
        mostrarPerfilMascota();
    }

    @Override
    public void mostrarPerfilMascota() {
        iPerfilMascotaFragmentView.inicializarPerfilMascotaAdaptadorRV(iPerfilMascotaFragmentView.crearPerfilMascotaAdaptador(coleccion));
        iPerfilMascotaFragmentView.generarGridLayout();
    }
}
