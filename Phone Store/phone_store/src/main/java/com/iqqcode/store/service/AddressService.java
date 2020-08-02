package com.iqqcode.store.service;

import com.iqqcode.store.form.AddressForm;
import com.iqqcode.store.vo.AddressVO;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 14:37
 * @Description:地址业务
 */
public interface AddressService {
    /**
     * 查询地址
     * @return
     */
    List<AddressVO> findAll();

    /**
     * 新增地址、修改地址
     * @param addressForm
     */
    void saveOrUpdate(AddressForm addressForm);
}
