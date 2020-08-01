package com.iqqcode.phone_store.vo;

import lombok.Data;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 19:13
 * @Description:
 */
@Data
public class SkuVO {
    private List<TreeVO> tree;
    private List<PhoneSpecsCasVO> list;
    private String price;
    private Integer stock_num;
    private Boolean none_sku = false;
    private Boolean hide_stock = false;
}