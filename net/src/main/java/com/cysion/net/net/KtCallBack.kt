package com.cysion.net.net

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

typealias onSuccess<T> = (call: Call<T>, body: T) -> Unit
typealias onFailure<T> = (call: Call<T>, t: Throwable) -> Unit

class KtCallBack<T> : Callback<T> {

    private var _success: onSuccess<T>? = null
    private var _fail: onFailure<T>? = null

    fun onSuccess(success: onSuccess<T>) {
        _success = success
    }

    fun onFail(failure: onFailure<T>) {
        _fail = failure
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        _fail?.invoke(call, t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.body()==null) {
            _fail?.invoke(call,IllegalArgumentException("body is null"))
            return
        }
        _success?.invoke(call, response.body()!!)
    }
}

fun <T> Call<T>.enqueue(f: KtCallBack<T>.() -> Unit) {
    val callback = KtCallBack<T>()
    callback.f()
    enqueue(callback)
}
