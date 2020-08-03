package com.iqqcode.store.service.impl;

import com.iqqcode.store.dto.OrderDTO;
import com.iqqcode.store.service.OrderService;
import com.iqqcode.store.vo.OrderDetailVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 16:58
 * @Description:
 */
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderService order;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("13678789632");
        orderDTO.setBuyerAddress("陕西省西安市长安区123号");
        orderDTO.setSpecsId(1);
        orderDTO.setPhoneQuantity(1);

        OrderDTO result = order.create(orderDTO);
        System.out.println(result);
    }

    @Test
    public void findDetail() {
        OrderDetailVO orderDetailVO = order.findOrderDetailByOrderId("1586242977480760998");
        //debug
        int i = 0;
    }
    @Test
    public void pay() {
        System.out.println(order.pay("1586242977480760998"));
    }
}