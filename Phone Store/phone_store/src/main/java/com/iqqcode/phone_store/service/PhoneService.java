package com.iqqcode.phone_store.service;

import com.iqqcode.phone_store.vo.DataVO;
import com.iqqcode.phone_store.vo.PhoneInfoVO;
import com.iqqcode.phone_store.vo.SpecsPackageVO;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 16:34
 * @Description:初始化页面加载的内容
 */
public interface PhoneService {
    /**
     * 首页数据展示
     * @return dataVo
     */
    DataVO findDataVO();

    /**
     * 根据类型查询手机
     * @param categoryType
     * @return
     */
    List<PhoneInfoVO> findPhoneInfoVOByCategoryType(Integer categoryType);

    /**
     * 通过手机编号查找手机规格
     * @param phoneId
     * @return data
     */
    SpecsPackageVO findSpecsByPhoneId(Integer phoneId);

    /**
     * 库存变化
     * @param specsId
     * @param quantity
     */
    void subStock(Integer specsId,Integer quantity);
}
