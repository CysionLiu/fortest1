package com.cysion.forTest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cysion.forTest.testnet.NetJava
import com.cysion.forTest.testnet.emitAllRequestByKotlin
import com.cysion.forTest.testnet.emitAllRequestByKotlin2
import com.cysion.forTest.zlknet.testZlk
import com.cysion.forTest.zlknet.testZlk2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vTv1.setOnClickListener {
            emitAllRequestByKotlin()
        }
        vTv2.setOnClickListener {
            emitAllRequestByKotlin2()
        }
        vTv3.setOnClickListener {
            NetJava().emitAllByJava()
        }
        vTv4.setOnClickListener {
            testZlk()
            testZlk2()
        }
    }
}
