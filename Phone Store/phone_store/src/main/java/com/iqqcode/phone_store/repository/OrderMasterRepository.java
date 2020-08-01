package com.iqqcode.phone_store.repository;

import com.iqqcode.phone_store.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 15:01
 * @Description:
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
