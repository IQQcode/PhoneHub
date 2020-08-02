package com.iqqcode.store.service.impl;

import com.iqqcode.store.entity.BuyerAddress;
import com.iqqcode.store.form.AddressForm;
import com.iqqcode.store.repository.BuyerAddressRepsitory;
import com.iqqcode.store.service.AddressService;
import com.iqqcode.store.vo.AddressVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 15:16
 * @Description:
 */
@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    private BuyerAddressRepsitory buyerAddressRepsitory;

    @Override
    public List<AddressVO> findAll() {
        List<AddressVO> list = buyerAddressRepsitory.findAll().stream()
                .map(e -> new AddressVO(
                    e.getAddressId(),
                    e.getAreaCode(),
                    e.getBuyerName(),
                    e.getBuyerPhone(),
                    e.getBuyerAddress()
                )).collect(Collectors.toList());
        return list;
    }

    @Override
    public void saveOrUpdate(AddressForm addressForm) {
        BuyerAddress buyerAddress;
        if(addressForm.getId() == null) {
            //新增地址
            buyerAddress = new BuyerAddress();
        } else {
            buyerAddress = buyerAddressRepsitory.findById(addressForm.getId()).get();
        }
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        StringBuilder sb = new StringBuilder();
        sb.append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());
        buyerAddress.setBuyerAddress(sb.toString());
        buyerAddress.setAreaCode(addressForm.getAreaCode());
        buyerAddressRepsitory.save(buyerAddress);
    }
}


