package com.iqqcode.phone_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 16:43
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneCategoryVO {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;
}
