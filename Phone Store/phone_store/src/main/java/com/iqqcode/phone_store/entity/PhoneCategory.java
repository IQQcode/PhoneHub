package com.iqqcode.phone_store.entity;

import lombok.Data;
import java.util.Date;
import javax.persistence.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 12:42
 * @Description:商品分类
 */
@Data
@Entity
public class PhoneCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}
