package com.example.petagram.restApi.deserializador;

import com.example.petagram.restApi.JsonKeys;
import com.example.petagram.restApi.model.MascotaImgUrlResponse;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class MascotaImgDataDeserializador implements JsonDeserializer<MascotaImgUrlResponse> {
    @Override
    public MascotaImgUrlResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaImgUrlResponse mascotaImgUrlResponse = gson.fromJson(json,MascotaImgUrlResponse.class);
        String img_url = json.getAsJsonObject().getAsJsonPrimitive(JsonKeys.MEDIA_RESFONSE_URL).getAsString();
        //Log.i("MascotaDeseria", user_name);
        mascotaImgUrlResponse.setMedia_url(img_url);
        return mascotaImgUrlResponse;
    }
}
