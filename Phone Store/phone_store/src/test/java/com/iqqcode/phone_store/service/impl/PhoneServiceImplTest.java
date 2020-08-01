package com.iqqcode.phone_store.service.impl;

import com.iqqcode.phone_store.service.PhoneService;
import com.iqqcode.phone_store.vo.DataVO;
import com.iqqcode.phone_store.vo.PhoneInfoVO;
import com.iqqcode.phone_store.vo.SpecsPackageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 18:20
 * @Description:
 */
@SpringBootTest
public class PhoneServiceImplTest {
    @Autowired
    private PhoneService phoneService;

    @Test
    public void findDataVo() {
        DataVO dataVO = phoneService.findDataVO();
        int id = 0;
    }

    @Test
    public void findPhoneInfoVOByCategoryType() {
        List<PhoneInfoVO> list = phoneService.findPhoneInfoVOByCategoryType(2);
        int id = 0;
    }

    @Test
    public void findSku() {
        SpecsPackageVO specsPackageVO = phoneService.findSpecsByPhoneId(1);
        int id = 0;
    }
}