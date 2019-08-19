package com.cysion.forTest.tools

import android.util.Log

fun <T> T.log(msg: String) {
    Log.i("---", msg)
}
typealias F1=(x:String)->Unit
fun f(i:Int,a:F1){
    a.invoke((i*9).toString()+"hello")
}