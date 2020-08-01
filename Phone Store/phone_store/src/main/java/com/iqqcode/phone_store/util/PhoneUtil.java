package com.iqqcode.phone_store.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-01 18:15
 * @Description:对tag内容以'&'分割截取
 */
public class PhoneUtil {
    public static List<Map<String, String>> createTag(String tag) {
        String[] tags = tag.split("&");
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        for (String s : tags) {
            map = new HashMap<>();
            map.put("name", s);
            list.add(map);
        }
        return list;
    }
}
