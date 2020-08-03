package com.iqqcode.store.util;

import com.iqqcode.store.vo.ResultVO;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-02 19:34
 * @Description:service的数据封装 {code,msg,data}
 */
public class ResultVOUtil {
    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error(String error) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg(error);
        resultVO.setData(null);
        return resultVO;
    }
}
