package com.cysion.forTest.testnet;

import com.cysion.net.net.KtCallBack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;
import java.util.Map;

public class NetJava {

    public void emitAllByJava() {

        //----
        Caller.INSTANCE.getApi().test_get_path("javapath").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

        //----
        Caller.INSTANCE.getApi().test_get_query("VALUE1", "VALUE2").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "get");
        //----
        Caller.INSTANCE.getApi().test_get_query_map(map).enqueue(new KtCallBack<TestEntity>());

        //----
        Caller.INSTANCE.getApi().test_post_form("value1", "value2").enqueue(new Callback<TestEntity>() {
            @Override
            public void onResponse(Call<TestEntity> call, Response<TestEntity> response) {

            }

            @Override
            public void onFailure(Call<TestEntity> call, Throwable t) {

            }
        });
        map.put("key2", "post");
        //----
        Caller.INSTANCE.getApi().test_post_form_map(map).enqueue(new KtCallBack<TestEntity>());

        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", "123");
        map2.put("title", "the title");
        AskEntity entity = new AskEntity();
        entity.setCode(1000);
        entity.setQuery("my query");
        map2.put("ask", entity);
        //----
        Caller.INSTANCE.getApi().test_post_json(map2).enqueue(new KtCallBack<String>());
        //---
        Caller.INSTANCE.getApi().test_post_json_body(entity).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


    }
}
