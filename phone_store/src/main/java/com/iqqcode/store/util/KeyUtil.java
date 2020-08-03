package com.iqqcode.store.util;

import java.util.Random;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 16:47
 * @Description:生成唯一订单编号
 */
public class KeyUtil {
    public static synchronized String createUniqueKey() {
        Random random = new Random();
        Integer key = random.nextInt(900000)+100000;
        //添加时间戳，防止随机数重复
        return System.currentTimeMillis() + String.valueOf(key);
    }
}
