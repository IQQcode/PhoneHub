package com.iqqcode.phone_store.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 16:37
 * @Description:
 */
@Data
public class DataVO {
    private List<PhoneCategoryVO> categories;
    private List<PhoneInfoVO> phones;
}
