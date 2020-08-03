package com.iqqcode.store.repository;

import com.iqqcode.store.entity.PhoneCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 13:04
 * @Description:商品分类测试
 */
@SpringBootTest
public class PhoneCategoryRepositoryTest {
    @Autowired
    private PhoneCategoryRepository repository;

    @Test
    public void findAll() {
        List<PhoneCategory> list = repository.findAll();
        for (PhoneCategory category : list) {
            System.out.println(category);
        }
    }

    @Test
    public void findByCategoryType() {
        PhoneCategory byCategoryType = repository.findByCategoryType(1);
        System.out.println(byCategoryType);
    }
}