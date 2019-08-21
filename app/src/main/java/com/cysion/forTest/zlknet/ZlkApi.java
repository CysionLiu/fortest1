package com.cysion.forTest.zlknet;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.Map;

public interface ZlkApi {

    @GET("kbaseservice/material/{mid}")
    Call<ApiResult<ZlkMaterial>> getMaterial(@Path("mid")String materialId);

    @POST("kbaseservice/material")
    Call<String> listMaterial(@Body Map<String,Object> jsonMap);
}
