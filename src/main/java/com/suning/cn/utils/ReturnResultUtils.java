package com.suning.cn.utils;

public class ReturnResultUtils {

    public static ReturnResult returnSuccess() {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(777);
        returnResult.setMsg("SUCCESS");
        return returnResult;
    }


    public static <T> ReturnResult returnSuccess(T data) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(777);
        returnResult.setMsg("SUCCESS");
        returnResult.setData(data);
        return returnResult;
    }

    public static ReturnResult returnFail(int code){
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMsg("FAIL");
        return returnResult;
    }

    public static ReturnResult returnFail(int code, String msg){
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMsg(msg);
        return returnResult;
    }





}
