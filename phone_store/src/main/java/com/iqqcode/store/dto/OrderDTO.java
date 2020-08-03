package com.iqqcode.store.dto;

import lombok.Data;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 16:07
 * @Description:前端订单数据转为实体类
 */
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private Integer specsId;
    private Integer phoneQuantity;
}
