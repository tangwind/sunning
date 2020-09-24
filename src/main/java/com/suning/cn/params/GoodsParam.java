package com.suning.cn.params;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsParam implements Serializable {
    private String goodsId;
    private int count;
}
