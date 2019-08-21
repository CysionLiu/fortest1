package com.cysion.forTest.zlknet;

import android.text.TextUtils;

/**
 * 资料库的数据json包装类，凡是符合下面的格式的json数据：
 * {
 * "result": {
 * "code": "0002",
 * "msg": "material not exist"
 * },
 * "data":
 * }
 * 都可以采用这种格式来声明解析对象。
 * <p>
 * 比如声明一个类
 * class A{
 * private String name;
 * }
 * 若对应的json为
 * * {
 * *     "result": {
 * *         "code": "0002",
 * *         "msg": "material not exist"
 * *     },
 * *     "data":{
 * "name":"hello"
 * }
 * * }
 * 其可以解析为ApiResult<A>对象
 * <p>
 * 若是列表，json为
 * *  * {
 * *     "result": {
 * *         "code": "0002",
 * *         "msg": "material not exist"
 * *     },
 * *     "data":[
 * {
 * "name":"hello"
 * },
 * {
 * "name":"world"
 * }
 * ]
 * *  * }
 * 其可以解析为ApiResult<List<A>>对象
 *
 * @param <T>
 */
public class ApiResult<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /*
    该数据是否得到了目标数据
     */
    public boolean isGood() {
        if (result != null && TextUtils.equals("0000", result.code)) {
            return true;
        }
        return false;
    }

    /**
     * result : {"code":"0000","msg":"success"}
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }


    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * code : 0000
         * msg : success
         */

        private String code;
        private String msg;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
