package com.cysion.forTest.zlknet

import com.cysion.ktbox.net.ApiException
import com.cysion.ktbox.net.BaseCaller
import com.cysion.ktbox.net.ErrorHandler
import com.cysion.ktbox.net.ErrorStatus
import com.cysion.net.net.NetCallBack
import com.cysion.net.net.onFailure
import com.cysion.net.net.onSuccess
import retrofit2.Call
import retrofit2.Callback


object ZlkCaller : BaseCaller<ZlkApi>("http://newslib.xinhua.io/kbapi/", ZlkApi::class.java)

fun <T : ApiResult<T>> Call<T>.enqueue(callback: NetCallBack<T>) {
    enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            callback.onError(call, ErrorHandler.handle(t))
        }

        override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) {
            val body = response.body()
            if (body == null || body.result == null) {
                callback.onError(call, ApiException(ErrorStatus.SERVER_ERROR, "数据获取失败"))
                return
            }
            if (body.isGood) {
                callback.onSuccess(call, body.data)
            } else {
                callback.onError(call, ApiException(body.result.code, body.result.msg))
            }
        }

    })
}


fun <T : ApiResult<T>> Call<T>.enqueue(foo: ZlkCallBack<T>.() -> Unit) {
    val callback = ZlkCallBack<T>()
    callback.foo()
    enqueue(callback)
}


open class ZlkCallBack<T : ApiResult<T>> : Callback<T> {

    private var _success: onSuccess<T>? = null
    private var _fail: onFailure<T>? = null

    fun onSuccess(success: onSuccess<T>) {
        _success = success
    }

    fun onError(failure: onFailure<T>) {
        _fail = failure
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        _fail?.invoke(call, t)
    }

    override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) {
        val body = response.body()
        if (body == null || body.result == null) {
            _fail?.invoke(call, ApiException(ErrorStatus.SERVER_ERROR, "数据获取失败"))
            return
        }
        if (body.isGood) {
            _success?.invoke(call, body.data)
        } else {
            _fail?.invoke(call, ApiException(body.result.code, body.result.msg))
        }
    }
}
