package com.iqqcode.phone_store.enums;

import lombok.Getter;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 21:46
 * @Description:结果集异常
 */
@Getter
public enum ResultEnum {
    //手机库存不足
    PHONE_STOCK_ERROR(0,"手机库存不足"),
    //订单不存在
    ORDER_NOT_EXIST(1,"订单不存在"),
    //规格不存在
    SPECS_NOT_EXIST(2,"规格不存在"),
    //手机不存在
    PHONE_NOT_EXIST(3,"手机不存在");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
