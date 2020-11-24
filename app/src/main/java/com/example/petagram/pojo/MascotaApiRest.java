package com.example.petagram.pojo;

public class MascotaApiRest {
    String id_apiRest;
    String url_foto_media;
    String nombre_usuario;

    public MascotaApiRest() {
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getId_apiRest() {
        return id_apiRest;
    }

    public void setId_apiRest(String id_apiRest) {
        this.id_apiRest = id_apiRest;
    }

    public String getUrl_foto_media() {
        return url_foto_media;
    }

    public void setUrl_foto_media(String url_foto_media) {
        this.url_foto_media = url_foto_media;
    }
}
