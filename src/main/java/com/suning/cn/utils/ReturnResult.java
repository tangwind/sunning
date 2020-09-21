package com.suning.cn.utils;

import lombok.Data;

@Data
public class ReturnResult<T> {
    private String msg;
    private int code;
    private T data;
}
