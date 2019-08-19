package com.cysion.img.other

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.Log

class MyHandlerThread(name: String?) : HandlerThread(name) {
    init {
        start()
    }

}
class MyHandler(looper: Looper?) : Handler(looper) {
    override fun handleMessage(msg: Message?) {
        super.handleMessage(msg)
        Log.i("--${Thread.currentThread().name}",msg?.what.toString())
    }
}