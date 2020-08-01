package com.iqqcode.phone_store.repository;

import com.iqqcode.phone_store.entity.PhoneInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 13:23
 * @Description:
 */
@SpringBootTest
public class PhoneInfoRepositoryTest {

    @Autowired
    private PhoneInfoRepository repository;

    @Test
    public void findAll(){
        List<PhoneInfo> list = repository.findAll();
        for (PhoneInfo phoneInfo : list) {
            System.out.println(phoneInfo);
        }
    }

    @Test
    public void findAllByCategoryType() {
        List<PhoneInfo> list = repository.findAllByCategoryType(1);
        for (PhoneInfo phoneInfo : list) {
            System.out.println(phoneInfo);
        }
    }
}