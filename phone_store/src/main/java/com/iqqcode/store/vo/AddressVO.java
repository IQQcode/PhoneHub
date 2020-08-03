package com.iqqcode.store.vo;

import lombok.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 15:14
 * @Description:
 */
@Data
@AllArgsConstructor
public class AddressVO {
    private Integer id;
    private String areaCode;
    private String name;
    private String tel;
    private String address;
}
