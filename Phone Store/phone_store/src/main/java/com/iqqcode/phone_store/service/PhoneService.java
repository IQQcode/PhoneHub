package com.iqqcode.phone_store.service;

import com.iqqcode.phone_store.vo.DataVO;
import com.iqqcode.phone_store.vo.PhoneInfoVO;

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
    //SpecsPackageVO findSpecsByPhoneId(Integer phoneId);
    void SubStock(Integer specsId,Integer quantity);
}
