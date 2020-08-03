package com.iqqcode.store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 16:43
 * @Description:
 */
@Data
@AllArgsConstructor
public class PhoneInfoVO {
    @JsonProperty("id")
    private Integer phoneId;

    @JsonProperty("title")
    private String phoneName;

    @JsonProperty("price")
    private String phonePrice;

    @JsonProperty("desc")
    private String phoneDescription;

    private List<Map<String,String>> tag;

    @JsonProperty("thumb")
    private String phoneIcon;
}
