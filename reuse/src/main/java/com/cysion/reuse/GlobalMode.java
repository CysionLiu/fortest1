package com.cysion.reuse;

import android.content.pm.ApplicationInfo;


/**
 * 全局调试模式配置接口
 */
class GlobalMode {

    //是否开启日志测试模式，开启，则会在app运行时保留日志
    private static final boolean isLogTest = true;
    //是否开启url访问测试模式，开启，则url的访问使用演示环境
    private static final boolean isUrlTest = false;
    //是否使用网页版登录，若否，则使用原生登录（暂时废弃）。目前应true
    private static final boolean isWebLogin = true;
    //是否强制认为这个版本是正式签名版本(保险起见，建议发版时设置成true)
    private static final boolean isForceRegardAsReleaseVersion = true;


    /*
    是否 是正式发布版本
    该属性优先由ApplicationInfo.FLAG_DEBUGGABLE来设定
    注意：若该版本是正式签名版本，则其它所有的测试模式，皆会是false
     */
    static boolean isReleaseMode() {
        /*
        如果不强制认为是正式签名版本，则由打包的版本决定是否是正式签名版本
        flag是否包含debuggable，不包含则为0，代表正式版
         */
        if (!isForceRegardAsReleaseVersion) {
            return Box.ctx().getApplicationInfo() != null &&
                    (Box.ctx().getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) == 0;
        } else {
            //如果强制，则就认为是正式发布版本
            return isForceRegardAsReleaseVersion;
        }
    }

    /*
    日志测试模式;正式发布版直接返回false
     */
    static boolean isLogTest() {
        return !isReleaseMode() && isLogTest;
    }

    /*
    url测试模式;正式发布版直接返回false
     */
    static boolean isUrlTest() {
        return !isReleaseMode() && isUrlTest;
    }

    /*
    登录模式
     */
    static boolean isWebLogin() {
        return isWebLogin;
    }
}
