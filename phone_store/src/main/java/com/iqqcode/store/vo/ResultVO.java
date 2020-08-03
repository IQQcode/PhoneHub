package com.iqqcode.store.vo;

import lombok.Data;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 19:29
 * @Description:传递service层的数据到view
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    //类型不确定
    private T data;
}
