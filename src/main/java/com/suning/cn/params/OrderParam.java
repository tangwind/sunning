package com.suning.cn.params;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderParam implements Serializable {

    private String orderId;
    private int realPay;
    private List<String> goodsId;
}
