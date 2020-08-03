package com.iqqcode.store.form;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 15:33
 * @Description:创建地址、修改地址--对前端的数据封装校验
 */
@Data
public class AddressForm {
    private Integer id;

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "电话不能为空")
    private String tel;

    @NotEmpty(message = "省不能为空")
    private String province;

    @NotEmpty(message = "市不能为空")
    private String city;

    @NotEmpty(message = "区不能为空")
    private String county;

    @NotEmpty(message = "邮编不能为空")
    private String areaCode;

    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;
}
