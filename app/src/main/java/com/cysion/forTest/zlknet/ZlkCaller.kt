package com.cysion.forTest.zlknet

import com.cysion.ktbox.net.ApiException
import com.cysion.ktbox.net.BaseCaller
import com.cysion.ktbox.net.ErrorHandler
import com.cysion.ktbox.net.ErrorStatus
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object ZlkCaller : BaseCaller<ZlkApi>("http://newslib.xinhua.io/kbapi/", ZlkApi::class.java)

fun <T> Call<ApiResult<T>>.call(callback: ZlkCallBack<T>): Call<ApiResult<T>> {
    enqueue(object : Callback<ApiResult<T>> {
        override fun onFailure(call: Call<ApiResult<T>>, t: Throwable) {
            callback.onError(call.request(), ErrorHandler.handle(t))
        }

        override fun onResponse(call: Call<ApiResult<T>>, response: retrofit2.Response<ApiResult<T>>) {
            val body = response.body()
            if (body == null || body.result == null) {
                callback.onError(call.request(), ApiException(ErrorStatus.SERVER_ERROR, "数据获取失败"))
                return
            }
            if (body.isGood) {
                callback.onSuccess(call.request(), body.data)
            } else {
                callback.onError(call.request(), ApiException(body.result.code, body.result.msg))
            }
        }

    })
    return this
}

fun <T> Call<ApiResult<T>>.call(foo: ZlkCallFunc<T>.() -> Unit): Call<ApiResult<T>> {
    val callback = ZlkCallFunc<T>()
    callback.foo()
    enqueue(callback)
    return this
}


/**
 * 接口：适用于经典接口式 回调结果
 */
interface ZlkCallBack<T> {
    fun onSuccess(request: Request, obj: T)

    fun onError(request: Request, error: ApiException)

}

/**
 * 子类：适用于kotlin函数式闭包回调结果
 */

typealias Success<T> = (request: Request, obj: T) -> Unit

typealias Fail<T> = (request: Request, error: ApiException) -> Unit

open class ZlkCallFunc<T> : Callback<ApiResult<T>> {

    private var _success: Success<T>? = null
    private var _fail: Fail<T>? = null

    fun onSuccess(success: Success<T>) {
        _success = success
    }

    fun onError(failure: Fail<T>) {
        _fail = failure
    }

    override fun onFailure(call: Call<ApiResult<T>>, t: Throwable) {
        _fail?.invoke(call.request(), ErrorHandler.handle(t))
    }

    override fun onResponse(call: Call<ApiResult<T>>, response: Response<ApiResult<T>>) {
        val body = response.body()
        if (body == null || body.result == null) {
            _fail?.invoke(call.request(), ApiException(ErrorStatus.SERVER_ERROR, "数据获取失败"))
            return
        }
        if (body.isGood) {
            _success?.invoke(call.request(), body.data)
        } else {
            _fail?.invoke(call.request(), ApiException(body.result.code, body.result.msg))
        }
    }
}
