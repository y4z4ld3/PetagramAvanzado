package com.example.petagram.restApi.model;

import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaResponse {
    ArrayList<Mascota> mascotaPerfil;

    public ArrayList<Mascota> getMascotaPerfil() {
        return mascotaPerfil;
    }

    public void setMascotaPerfil(ArrayList<Mascota> mascotaPerfil) {
        this.mascotaPerfil = mascotaPerfil;
    }

}
