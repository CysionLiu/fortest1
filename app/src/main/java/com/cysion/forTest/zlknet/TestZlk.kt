package com.cysion.forTest.zlknet

import android.util.Log
import com.cysion.net.net.enqueue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun testZlk() {
    ZlkCaller.api.getMaterial("4000120190815000000061")
        .enqueue {
            onSuccess { call, body ->
                Log.i("--$ ", body.toString())
            }
            onFail { call, t ->
                Log.i("--$ ", t.message)
            }
        }


    ZlkCaller.api.listMaterial(
        mutableMapOf(
            "kbnodeId" to 2675,
            "pageNo" to 111111,
            "pageTotal" to 20,
            "spaceType" to 1,
            "isIntranet" to 1,
            "userName" to "测试3"
        )
    ).enqueue(object : Callback<String> {
        override fun onFailure(call: Call<String>, t: Throwable) {
            Log.i("--$ ", t.message)
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            Log.i("--$ ", response.body())
        }

    })
}