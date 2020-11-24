package com.example.petagram.restApi;

import com.example.petagram.restApi.model.MascotaImgUrlResponse;
import com.example.petagram.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IEndpoinsApi {
    @GET(ConstantesRestApi.URL_GET_INFORMATION_USER)
    Call<MascotaResponse> getListaMedia(@Path(value = "user",encoded = true) String user,
                                        @Query(value = "access_token") String token,
                                        @Query(value = "fields") String fields);

    // @GET("{url_media}")
    @GET(ConstantesRestApi.URL_GET_INFORMATION_MEDIA_DATA)
    Call<MascotaImgUrlResponse>  getUrlMedia(@Path(value = "id_media",encoded = true) String id_media,
                                             @Query(value = "access_token") String token,
                                             @Query(value = "fields") String fields);
    // Call<MascotaResponse>  getUrlMedia(@Path(value = "url_media",encoded = false) String url_media);
    // Call<MascotaImgUrlResponse>  getUrlMedia(@Path(value = "id_media",encoded = true) String id_media);
}
