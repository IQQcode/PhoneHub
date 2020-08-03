package com.iqqcode.store.service.impl;

import com.iqqcode.store.dto.OrderDTO;
import com.iqqcode.store.entity.OrderMaster;
import com.iqqcode.store.entity.PhoneInfo;
import com.iqqcode.store.entity.PhoneSpecs;
import com.iqqcode.store.enums.PayStatusEnum;
import com.iqqcode.store.enums.ResultEnum;
import com.iqqcode.store.exception.PhoneException;
import com.iqqcode.store.repository.OrderMasterRepository;
import com.iqqcode.store.repository.PhoneInfoRepository;
import com.iqqcode.store.repository.PhoneSpecsRepository;
import com.iqqcode.store.service.OrderService;
import com.iqqcode.store.service.PhoneService;
import com.iqqcode.store.util.KeyUtil;
import com.iqqcode.store.vo.OrderDetailVO;
import org.springframework.beans.BeanUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 16:32
 * @Description:订单业务类
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private PhoneService phoneService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);

        PhoneSpecs phoneSpecs = phoneSpecsRepository.findById(orderDTO.getSpecsId()).get();
        if(phoneSpecs == null){
            log.error("【创建订单】规格不存在,phoneSpecs={}",phoneSpecs);
            throw new PhoneException(ResultEnum.SPECS_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneSpecs,orderMaster);

        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        if(phoneInfo == null){
            log.error("【创建订单】手机不存在,phoneInfo={}",phoneInfo);
            throw new PhoneException(ResultEnum.PHONE_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneInfo,orderMaster);

        //计算总价
        //specsId --> PhoneSpecs --> PhoneInfo --> phonePrice
        // 拿到手机型号，通过型号找到手机规格，再到手机信息的价格
        // total = phonePrice * quantity
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = phoneSpecs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getPhoneQuantity()))
                .add(orderAmount)
                .add(new BigDecimal(10));
        orderMaster.setOrderAmount(orderAmount);

        //订单id--orderId
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());

        //支付状态payStatus
        orderMaster.setPayStatus(PayStatusEnum.UNPIAD.getCode());
        orderMasterRepository.save(orderMaster);
        phoneService.subStock(orderDTO.getSpecsId(), orderDTO.getPhoneQuantity());
        return orderDTO;
    }

    @Override
    public OrderDetailVO findOrderDetailByOrderId(String orderId) {
        OrderDetailVO orderDetailVO = new OrderDetailVO();

        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        if(orderMaster == null){
            log.error("【查询订单】订单不存在,orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }
        BeanUtils.copyProperties(orderMaster,orderDetailVO);

        //SpecsPrice: 将BigDecimal转为Integer
        orderDetailVO.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100))+".00");
        return orderDetailVO;
    }

    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        if(orderMaster == null) {
            log.error("【支付订单】订单不存在,orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }

        if(orderMaster.getPayStatus().equals(PayStatusEnum.UNPIAD.getCode())) {
            orderMaster.setPayStatus(PayStatusEnum.PAID.getCode());
            orderMasterRepository.save(orderMaster);
        } else {
            log.error("【支付订单】订单已支付,orderMaster={}",orderMaster);
            throw new PhoneException(PayStatusEnum.PAID.getMsg());
        }
        return orderId;
    }
}
