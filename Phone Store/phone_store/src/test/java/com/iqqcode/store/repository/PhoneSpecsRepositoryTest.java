package com.iqqcode.store.repository;

import com.iqqcode.store.entity.PhoneSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 14:41
 * @Description:
 */
@SpringBootTest
class PhoneSpecsRepositoryTest {

    @Autowired
    private PhoneSpecsRepository repository;

    @Test
    void findAll(){
        List<PhoneSpecs> list = repository.findAll();
        for (PhoneSpecs phoneSpecs : list) {
            System.out.println(phoneSpecs);
        }
    }

    @Test
    void findAllByPhoneId(){
        List<PhoneSpecs> list = repository.findAllByPhoneId(1);
        for (PhoneSpecs phoneSpecs : list) {
            System.out.println(phoneSpecs);
        }
    }
}