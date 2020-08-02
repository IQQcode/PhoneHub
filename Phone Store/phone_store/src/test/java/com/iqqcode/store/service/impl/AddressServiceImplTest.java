package com.iqqcode.store.service.impl;

import com.iqqcode.store.form.AddressForm;
import com.iqqcode.store.service.AddressService;
import com.iqqcode.store.vo.AddressVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 15:27
 * @Description:
 */
@SpringBootTest
public class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void findAll() {
        List<AddressVO> list = addressService.findAll();
        //debug
        int i  = 0;
    }

    @Test
    public void save_update() {
        AddressForm addressForm = new AddressForm();
        addressForm.setId(37);
        addressForm.setName("Jack");
        addressForm.setTel("13678789632");
        addressForm.setAreaCode("456899");
        addressForm.setProvince("浙江省");
        addressForm.setCity("杭州市");
        addressForm.setCounty("西湖区");
        addressForm.setAddressDetail("123号路456单元");
        addressService.saveOrUpdate(addressForm);
    }
}