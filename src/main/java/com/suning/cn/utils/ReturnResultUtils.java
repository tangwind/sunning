package com.suning.cn.utils;

/**
 * 200：success
 * 500: fail
 */
public class ReturnResultUtils {

    public static ReturnResult returnSuccess() {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(200);
        returnResult.setMsg("SUCCESS");
        return returnResult;
    }


    public static <T> ReturnResult returnSuccess(T data) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(200);
        returnResult.setMsg("SUCCESS");
        returnResult.setData(data);
        return returnResult;
    }

    public static ReturnResult returnFail() {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(500);
        returnResult.setMsg("FAIL");
        return returnResult;
    }

    public static ReturnResult returnFail(int code) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMsg("FAIL");
        return returnResult;
    }

    public static ReturnResult returnFail(int code, String msg) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMsg(msg);
        return returnResult;
    }


}
