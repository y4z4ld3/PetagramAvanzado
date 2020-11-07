package com.example.petagram.pojo;

public class Mascota implements Comparable<Mascota> {
    private int id_mascota;
    private String nombre;
    private int foto;
    private int votos = 0;

    public Mascota() {
    }

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    public Mascota(int foto, int votos) {
        this.votos = votos;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    @Override
    public int compareTo(Mascota mascota) {
        if (votos < mascota.votos){
            return -1;
        }
        if (votos > mascota.votos){
            return 1;
        }
        return 0;
    }
}
