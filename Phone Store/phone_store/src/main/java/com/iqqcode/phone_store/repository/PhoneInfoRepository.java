package com.iqqcode.phone_store.repository;

import com.iqqcode.phone_store.entity.PhoneInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 13:22
 * @Description:
 */
public interface PhoneInfoRepository extends JpaRepository<PhoneInfo,Integer> {
    List<PhoneInfo> findAllByCategoryType(Integer categoryType);
}
