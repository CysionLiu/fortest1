package com.cysion.forTest.ui

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.CookieManager
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cysion.forTest.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    val ctx: Context by lazy {
        this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_web)
        vWeb.settings.javaScriptEnabled = true
        vWeb.webViewClient=(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url)
                return true
            }
        })
        CookieManager.getInstance().setAcceptCookie(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(vWeb,true)
        }
        vWeb.addJavascriptInterface(JSInter(), "AndroidObj")
        runOnUiThread {
//            vWeb.loadUrl("file:///android_asset/t.html")
            vWeb.loadUrl("https://hotspot.xinhua-news.cn/dist/h5/")

        }
    }


    inner class JSInter {
        @JavascriptInterface
        fun create(msg: String) {
            Log.i("--$ ", "$msg")
            Toast.makeText(ctx, msg, Toast.LENGTH_SHORT)
                .show()
        }
    }
}
