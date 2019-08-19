package com.cysion.img.other

import android.os.Handler
import android.util.Log


fun f(h:Handler) {
    val handler = MyHandler(MyHandlerThread("my").looper)

    for (i in 1..30) {
        Thread {
            Thread.sleep(10)
            Log.d("--${Thread.currentThread().name}", i.toString())
            handler.sendMessage(handler.obtainMessage(i))
            h.sendMessage(h.obtainMessage(i))
        }.start()
    }
}