package com.example.petagram.restApi.deserializador;

import android.util.Log;

import com.example.petagram.pojo.Mascota;
import com.example.petagram.restApi.ConstantesRestApi;
import com.example.petagram.restApi.JsonKeys;
import com.example.petagram.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Call;

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {


    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse= gson.fromJson(json,MascotaResponse.class);
        JsonObject mascotaResponseMedia = json.getAsJsonObject().getAsJsonObject(JsonKeys.MEDIA_RESPONSE);
        //JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        JsonArray mascotaResponseData = mascotaResponseMedia.getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        String user_name = json.getAsJsonObject().getAsJsonPrimitive(JsonKeys.USER_NAME).getAsString();
        //String user_name = "MascotaDeserializador";
        //Log.i("MascotaDeseria", user_name);
        mascotaResponse.setMascotaPerfil(deserializarMascotadeJson(mascotaResponseData, user_name));
        return mascotaResponse;
    }

    private ArrayList<Mascota> deserializarMascotadeJson(JsonArray mascotaResponseData, String user_name){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i=0; i < mascotaResponseData.size(); i++ ){
            JsonObject mascotaesponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
            String id_media_data  = mascotaesponseDataObject.get(JsonKeys.MEDIA_RESFONSE_ID).getAsString();
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId_apiRest(id_media_data);
            mascotaActual.setNombre_usuario(user_name);
            mascotas.add(mascotaActual);
        }
        return mascotas;
    }
}
