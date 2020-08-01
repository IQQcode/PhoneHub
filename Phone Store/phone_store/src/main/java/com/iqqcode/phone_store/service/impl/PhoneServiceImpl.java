package com.iqqcode.phone_store.service.impl;

import com.iqqcode.phone_store.entity.PhoneCategory;
import com.iqqcode.phone_store.entity.PhoneInfo;
import com.iqqcode.phone_store.repository.PhoneCategoryRepository;
import com.iqqcode.phone_store.repository.PhoneInfoRepository;
import com.iqqcode.phone_store.repository.PhoneSpecsRepository;
import com.iqqcode.phone_store.service.PhoneService;
import com.iqqcode.phone_store.util.PhoneUtil;
import com.iqqcode.phone_store.vo.DataVO;
import com.iqqcode.phone_store.vo.PhoneCategoryVO;
import com.iqqcode.phone_store.vo.PhoneInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 16:56
 * @Description:
 */
@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneCategoryRepository phoneCategoryRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;

    /**
     * 首页数据展示
     * @return DataVO
     */
    @Override
    public DataVO findDataVO() {
        DataVO dataVO = new DataVO();
        //类型,将查询出的PhoneCategory转为PhoneCategoryVO，为前端传数据
        List<PhoneCategory> phoneCategoryList = phoneCategoryRepository.findAll();

        //常规写法
        /*List<PhoneCategoryVO> phoneCategoryVOList = new ArrayList<>();
        for (PhoneCategory phoneCategory : phoneCategoryList) {
            PhoneCategoryVO phoneCategoryVO = new PhoneCategoryVO();
            phoneCategoryVO.setCategoryName(phoneCategory.getCategoryName());
            phoneCategoryVO.setCategoryType(phoneCategory.getCategoryType());
            phoneCategoryVOList.add(phoneCategoryVO);
        }*/

        //Stream流，直接将集合当做目标对象处理
        List<PhoneCategoryVO> phoneCategoryVOList = phoneCategoryList.stream().map(
                e -> new PhoneCategoryVO(
                        e.getCategoryName(),
                        e.getCategoryType()
                )).collect(Collectors.toList());
        dataVO.setCategories(phoneCategoryVOList);

        //手机
        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findAllByCategoryType(phoneCategoryList.get(0).getCategoryType());
        //常规写法
        /*List<PhoneInfoVO> phoneInfoVOList = new ArrayList<>();
        for (PhoneInfo phoneInfo : phoneInfoList) {
            PhoneInfoVO phoneInfoVO = new PhoneInfoVO();
            BeanUtils.copyProperties(phoneInfo,phoneInfoVO);
            phoneInfoVO.setTag(PhoneUtil.createTag(phoneInfo.getPhoneTag()));
            phoneInfoVOList.add(phoneInfoVO);
        }*/

        //stream
        List<PhoneInfoVO> phoneInfoVOList = phoneInfoList.stream()
                .map(e -> new PhoneInfoVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice()+".00",
                        e.getPhoneDescription(),
                        PhoneUtil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());
        dataVO.setPhones(phoneInfoVOList);
        return dataVO;
    }

    @Override
    public List<PhoneInfoVO> findPhoneInfoVOByCategoryType(Integer categoryType) {
        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findAllByCategoryType(categoryType);
        List<PhoneInfoVO> phoneInfos = phoneInfoList.stream().
                map(e -> new PhoneInfoVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice()+".00",
                        e.getPhoneDescription(),
                        PhoneUtil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());
        return phoneInfos;
    }

    @Override
    public void SubStock(Integer specsId, Integer quantity) {

    }
}
