package com.cysion.forTest.testnet

import com.cysion.ktbox.net.BaseCaller
import okhttp3.Interceptor
import okhttp3.Response

object Caller : BaseCaller<TestApi>("http://www.123.com/app/", TestApi::class.java)

object Caller2 : BaseCaller<TestApi>("http://www.123456789.com/app/", TestApi::class.java) {
    override fun beforeInit() {
        addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val r = chain.request()
                val newReq = r.newBuilder().addHeader("common_header", "commonHeader").build()
                return chain.proceed(newReq)
            }
        })
    }
}

