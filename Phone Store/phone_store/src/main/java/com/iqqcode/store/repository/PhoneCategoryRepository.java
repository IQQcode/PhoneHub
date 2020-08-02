package com.iqqcode.store.repository;

import com.iqqcode.store.entity.PhoneCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 12:50
 * @Description:等同于dao层，自动解析SQL
 */
public interface PhoneCategoryRepository extends JpaRepository<PhoneCategory,Integer> {
    PhoneCategory findByCategoryType(Integer categoryType);
}
