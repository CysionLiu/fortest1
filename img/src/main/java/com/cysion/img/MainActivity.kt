package com.cysion.img

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cysion.img.other.f

class MainActivity : AppCompatActivity() {

    val handler = object : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            Log.i("--${Thread.currentThread().name}",msg?.what.toString())
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        f(handler)
    }
}
