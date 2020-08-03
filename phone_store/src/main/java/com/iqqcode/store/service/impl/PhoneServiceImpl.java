package com.iqqcode.store.service.impl;

import com.iqqcode.store.entity.PhoneCategory;
import com.iqqcode.store.entity.PhoneInfo;
import com.iqqcode.store.entity.PhoneSpecs;
import com.iqqcode.store.enums.ResultEnum;
import com.iqqcode.store.exception.PhoneException;
import com.iqqcode.store.repository.PhoneCategoryRepository;
import com.iqqcode.store.repository.PhoneInfoRepository;
import com.iqqcode.store.repository.PhoneSpecsRepository;
import com.iqqcode.store.service.PhoneService;
import com.iqqcode.store.util.PhoneUtil;
import com.iqqcode.store.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    /**
     * 通过手机编号查找手机规格
     * @param phoneId
     * @return Specs
     */
    @Override
    public SpecsPackageVO findSpecsByPhoneId(Integer phoneId) {
        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneId).get();
        List<PhoneSpecs> phoneSpecsList = phoneSpecsRepository.findAllByPhoneId(phoneId);
        SpecsPackageVO specsPackageVO = new SpecsPackageVO();
        //goods
        Map<String,String> goods = new HashMap<>();
        goods.put("picture",phoneInfo.getPhoneIcon());
        specsPackageVO.setGoods(goods);
        //sku
        SkuVO skuVO = new SkuVO();
        // // tree
        TreeVO treeVO = new TreeVO();
        List<PhoneSpecsVO> phoneSpecsVOList = new ArrayList<>();
        List<PhoneSpecsCasVO> phoneSpecsCasVOList = new ArrayList<> ();
        PhoneSpecsVO phoneSpecsVO;
        PhoneSpecsCasVO phoneSpecsCasVO;
        for (PhoneSpecs phoneSpecs : phoneSpecsList) {
            phoneSpecsVO = new PhoneSpecsVO();
            phoneSpecsCasVO = new PhoneSpecsCasVO();
            BeanUtils.copyProperties(phoneSpecs,phoneSpecsVO);
            BeanUtils.copyProperties(phoneSpecs,phoneSpecsCasVO);
            phoneSpecsVOList.add(phoneSpecsVO);
            phoneSpecsCasVOList.add(phoneSpecsCasVO);
        }
        treeVO.setV(phoneSpecsVOList);
        List<TreeVO> treeVOList = new ArrayList<>();
        treeVOList.add(treeVO);
        skuVO.setTree(treeVOList);

        // // list
        skuVO.setList(phoneSpecsCasVOList);
        // // price
        Integer price = phoneInfo.getPhonePrice().intValue();
        skuVO.setPrice(price + ".00");
        // // stock_num
        skuVO.setStock_num(phoneInfo.getPhoneStock());
        specsPackageVO.setSku(skuVO);
        return specsPackageVO;
    }

    /**
     * 库存变化
     * @param specsId
     * @param quantity
     */
    @Override
    public void subStock(Integer specsId, Integer quantity) {
        PhoneSpecs phoneSpecs = phoneSpecsRepository.findById(specsId).get();
        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        Integer result = phoneSpecs.getSpecsStock() - quantity;
        if(result < 0) {
            log.error("【扣库存】库存不足...");
            throw new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        }
        phoneSpecs.setSpecsStock(result);
        phoneSpecsRepository.save(phoneSpecs);

        result = phoneInfo.getPhoneStock() - quantity;
        if(result < 0) {
            log.error("【扣库存】库存不足...");
            throw new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        }
        phoneInfo.setPhoneStock(result);
        phoneInfoRepository.save(phoneInfo);
    }
}
