package com.iqqcode.phone_store.repository;

import com.iqqcode.phone_store.entity.BuyerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 14:46
 * @Description:
 */
@SpringBootTest
public class BuyerAddressRepsitoryTest {

    @Autowired
    private BuyerAddressRepsitory repsitory;

    @Test
    public void findAll() {
        List<BuyerAddress> all = repsitory.findAll();
        for (BuyerAddress buyerAddress : all) {
            System.out.println(all);
        }
    }

    @Test
    public void addAddress() {
        BuyerAddress buyerAddress = new BuyerAddress();
        buyerAddress.setAreaCode("014100");
        buyerAddress.setBuyerAddress("内蒙古呼和浩特市赛罕塔拉区123号");
        buyerAddress.setBuyerName("Mr.Q");
        buyerAddress.setBuyerPhone("13678787878");
        repsitory.save(buyerAddress);
    }

    @Test
    void update(){
        BuyerAddress buyerAddress = repsitory.findById(36).get();
        buyerAddress.setBuyerName("小Q");
        repsitory.save(buyerAddress);
    }
}