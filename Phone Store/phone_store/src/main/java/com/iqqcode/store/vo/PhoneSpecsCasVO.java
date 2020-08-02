package com.iqqcode.store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 19:17
 * @Description:
 */
@Data
public class PhoneSpecsCasVO {
    @JsonProperty("s1")
    private Integer specsId;

    @JsonProperty("price")
    private BigDecimal specsPrice;

    @JsonProperty("stock_num")
    private Integer specsStock;
}
