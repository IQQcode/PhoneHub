package com.iqqcode.phone_store.exception;

import com.iqqcode.phone_store.enums.ResultEnum;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 21:44
 * @Description:库存信息异常
 */
public class PhoneException extends RuntimeException {
    public PhoneException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }

    public PhoneException(String error) {
        super(error);
    }
}

