package com.iqqcode.store.vo;

import lombok.Data;

import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 19:11
 * @Description:手机规格信息
 */
@Data
public class SpecsPackageVO {
    private Map<String,String> goods;
    private SkuVO sku;
}
