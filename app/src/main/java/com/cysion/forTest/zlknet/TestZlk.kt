package com.cysion.forTest.zlknet

import android.util.Log
import com.cysion.ktbox.net.ApiException
import com.cysion.net.net.enqueue
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//普通retrofit回调
fun testZlk() {
    //kotlin函数式回调
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
        ) as Map<String, Any>?
    ).enqueue(object : Callback<String> {
        override fun onFailure(call: Call<String>, t: Throwable) {
            Log.i("--$ ", t.message)
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            Log.i("--$ ", response.body())
        }

    })
}

//需要统一结果处理的结果（json格式必须符合ApiResult结构）
fun testZlk2() {
    //经典回调使用；call的引用可以保存，以便后续取消
    val call = ZlkCaller.api.getMaterial("400012019081500000006")
        .call(object : ZlkCallBack<ZlkMaterial> {
            override fun onSuccess(request: Request, obj: ZlkMaterial) {
                Log.i("--$ test2-1-", obj.headLine + obj.docId)

            }

            override fun onError(request: Request, error: ApiException) {
                Log.i("--$ test2-1-", "${error.errorMsg}")
            }

        })
    //kotlin函数式调用
    val call2 = ZlkCaller.api.getMaterial("4000120190815000000061")
        .call {
            onError { request, t ->
                Log.i("--$ test2-2-", "${t.errorMsg}")
            }
            onSuccess { request, obj ->
                Log.i("--$ test2-2-", "${obj.headLine}-${obj.docId}")
            }
        }


}