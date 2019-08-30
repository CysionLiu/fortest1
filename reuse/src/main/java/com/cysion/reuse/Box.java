package com.cysion.reuse;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.DisplayMetrics;

/**
 * Created by cysion on 2017\12\22 0022.
 * 主要放置相关的配置信息，简短使用
 */

public class Box {

    private static Context ctx;
    private static int width;
    private static int height;
    private static Configuration cfg;
    private static Resources res;

    //Application创建时就需要立即调用此方法；最高优先级
    public static void init(Context aContext) {
        ctx = aContext.getApplicationContext();
        initSize();
        res = ctx.getResources();
        cfg = res.getConfiguration();
    }

    //登录调试（是否是web页面登录）
    public static boolean isLoginDebug() {
        return GlobalMode.isWebLogin();
    }

    //日志，吐司，统计是否是测试模式
    public static boolean isLogTest() {
        return GlobalMode.isLogTest();
    }

    //url是否是测试模式
    public static boolean isUrlTest() {
        return GlobalMode.isUrlTest();
    }

    //app是否是调试版本
    public static boolean isAppDebug() {
        return !GlobalMode.isReleaseMode();
    }

    private static void initSize() {
        DisplayMetrics dm = ctx.getResources().getDisplayMetrics();
        width = dm.widthPixels;
        height = dm.heightPixels;
    }

    //上下文
    public static Context ctx() {
        if (ctx == null) {
            throw new IllegalArgumentException("应在Application中首先调用Box.init()方法");
        }
        return ctx;
    }


    //屏幕宽
    public static int width() {
        return width;
    }

    //屏幕高
    public static int height() {
        return height;
    }

    //app配置
    public static Configuration cfg() {
        return cfg;
    }

    //resources
    public static Resources res() {
        return res;
    }

    //string
    public static String str(int sid) {
        return res.getString(sid);
    }

    //color
    public static int color(int sid) {
        return res.getColor(sid);
    }

    //drawable
    public static Drawable img(int sid) {
        return res.getDrawable(sid);
    }

    //drawable
    public static float density() {
        return res().getDisplayMetrics().density;
    }


    //version code
    public static int vcode() {
        if (ctx == null) {
            return 999999;
        }
        PackageManager packManager = ctx.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packManager.getPackageInfo(ctx.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 999999;
    }

    //wifi mac address
    public String mac() {
        // start get mac address
        WifiManager wifiMan = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);
        if (wifiMan != null) {
            WifiInfo wifiInf = wifiMan.getConnectionInfo();
            if (wifiInf != null && wifiInf.getMacAddress() != null) {
                // 48位，如FA:34:7C:6D:E4:D7
                return wifiInf.getMacAddress();
            }
        }
        return null;
    }

    //version name
    public static String vName() throws PackageManager.NameNotFoundException {
        if (ctx == null) {
            return "999999";
        }

        PackageManager packManager = ctx.getPackageManager();
        PackageInfo packageInfo = packManager.getPackageInfo(ctx.getPackageName(), 0);
        return packageInfo.versionName;
    }

}
