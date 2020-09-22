package com.suning.cn.params;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderParam implements Serializable {
    private String goodsId;
    private int count;
    private String userId;
}
