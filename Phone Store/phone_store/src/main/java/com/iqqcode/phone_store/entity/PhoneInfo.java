package com.iqqcode.phone_store.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 13:18
 * @Description:商品信息
 */
@Data
@Entity
public class PhoneInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer phoneId;
    private String phoneName;
    private BigDecimal phonePrice; //float
    private String phoneDescription;
    private Integer phoneStock;
    private String phoneIcon;
    private Integer categoryType;
    private String phoneTag;
    private Date createTime;
    private Date updateTime;
}
