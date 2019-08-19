package com.cysion.forTest.testnet;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/*
本例子的demo全部都是伪请求，即url是错的，但是抓包可以看到具体的http请求
baseurl="www.123.com/app/
 */
public interface TestApi {

    @GET("test_get_path/{path}")
    Call<String> test_get_path(@Path("path") String path);

    @GET("test_get_query")
    Call<String> test_get_query(@Query("key1") String value1, @Query("key2") String value2);

    @GET("test_get_query_map")
    Call<TestEntity> test_get_query_map(@QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST("test_post_form")
    Call<TestEntity> test_post_form(@Field("key1") String key1, @Field("key2") String key2);

    @FormUrlEncoded
    @POST("test_post_form_map")
    Call<TestEntity> test_post_form_map(@FieldMap Map<String, String> map);

    @POST("test_post_json")
    Call<String> test_post_json(@Body Map<String, Object> map);

    @GET("test_fixed_header")
    @Headers({"header1:value-header1", "header2:value-header2"})
    Call<String> test_fixed_header();

    @POST("test_header_dynamic")
    Call<String> test_header_dynamic(@Header("header3") String header3);

    @POST("test_post_json_body")
    Call<String> test_post_json_body(@Body AskEntity askEntity);


}
