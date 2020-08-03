package com.iqqcode.store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.math.BigDecimal;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 17:08
 * @Description:订单详情数据封装
 */
@Data
public class OrderDetailVO {
    private String orderId;

    private String buyerName;

    @JsonProperty("tel")
    private String buyerPhone;

    @JsonProperty("address")
    private String buyerAddress;

    @JsonProperty("num")
    private Integer phoneQuantity;

    private String phoneName;

    @JsonProperty("specs")
    private String specsName;

    @JsonProperty("price")
    private String specsPrice;

    @JsonProperty("icon")
    private String phoneIcon;

    @JsonProperty("amount")
    private BigDecimal orderAmount;

    private Integer payStatus;
    private Integer freight = 10;
}
