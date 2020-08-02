package com.iqqcode.store.enums;

import lombok.Getter;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 16:52
 * @Description:订单支付状态
 */
@Getter
public enum PayStatusEnum {
    //未支付
    UNPIAD(0,"未支付"),
    //已支付
    PAID(1,"已支付");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}