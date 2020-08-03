package com.iqqcode.store.service.impl;

import com.iqqcode.store.service.PhoneService;
import com.iqqcode.store.vo.DataVO;
import com.iqqcode.store.vo.PhoneInfoVO;
import com.iqqcode.store.vo.SpecsPackageVO;
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
        //debug
        int id = 0;
    }

    @Test
    public void findPhoneInfoVOByCategoryType() {
        List<PhoneInfoVO> list = phoneService.findPhoneInfoVOByCategoryType(2);
        //debug
        int id = 0;
    }

    @Test
    public void findSku() {
        SpecsPackageVO specsPackageVO = phoneService.findSpecsByPhoneId(1);
        //debug
        int id = 0;
    }

    @Test
    public void subStock() {
        phoneService.subStock(1, 2);
    }
}