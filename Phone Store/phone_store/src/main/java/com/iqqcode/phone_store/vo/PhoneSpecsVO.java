package com.iqqcode.phone_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 19:15
 * @Description:
 */
@Data
public class PhoneSpecsVO {
    @JsonProperty("id")
    private Integer specsId;

    @JsonProperty("name")
    private String specsName;

    @JsonProperty("imgUrl")
    private String specsIcon;

    @JsonProperty("previewImgUrl")
    private String specsPreview;
}
