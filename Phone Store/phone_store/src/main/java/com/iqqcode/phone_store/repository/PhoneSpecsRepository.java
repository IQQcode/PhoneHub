package com.iqqcode.phone_store.repository;

import com.iqqcode.phone_store.entity.PhoneSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 14:40
 * @Description:
 */
public interface PhoneSpecsRepository extends JpaRepository<PhoneSpecs,Integer> {
    List<PhoneSpecs> findAllByPhoneId(Integer phoneId);
}
