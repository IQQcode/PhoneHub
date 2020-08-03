package com.iqqcode.store.service;

import com.iqqcode.store.dto.OrderDTO;
import com.iqqcode.store.vo.OrderDetailVO;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 16:00
 * @Description:订单业务
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 订单详情
     * @param orderId
     * @return
     */
    OrderDetailVO findOrderDetailByOrderId(String orderId);

    /**
     * 支付订单
     * @param orderId
     * @return
     */
    String pay(String orderId);
}
