package com.liy.common.core.web.controller;

import com.liy.common.core.enums.ResultCode;
import com.liy.common.core.util.StringUtils;
import com.liy.common.core.web.domain.AjaxResult;
import com.liy.common.core.web.page.Page;

/**
 * @Author LiY
 * 基本接口类
 * 集成接口常用方法
 */

public class BaseController {

    /**
     * @description: 返回成功
     * @author: liy
     * @param:
     * @return:  ajaxResult
     **/
    public AjaxResult toSuccess(){
        return AjaxResult.success();
    }

    public AjaxResult toSuccess(String msg){
        System.out.println("msg:"+msg);
        return AjaxResult.success(msg);
    }

    public AjaxResult toSuccess(int code, String msg){
        return AjaxResult.success(code, msg);
    }

    public AjaxResult toSuccess(String dataName, Object data) {
        return toSuccess().put(dataName,data);
    }

    public AjaxResult toError(){
        return AjaxResult.error();
    }

    public AjaxResult toError(String msg){
        return AjaxResult.error(msg);
    }

    /**
     * @description: 自动判断影响行数返回结果
     * @author: liy
     * @param:  Integer
     * @return:  AjaxResult
     **/
    public AjaxResult toAjaxResult(Integer rows){
        return rows > 0 ? toSuccess() : toError();
    }

    /**
     * @description: 自动判断true/falser返回结果
     * @author: liy
     * @param:  boolean
     * @return:  AjaxResult
     **/
    public AjaxResult toAjaxResult(boolean result){
        return result ? toSuccess() : toError();
    }

    public AjaxResult toAjaxResult(String dataName, Object data){
        return StringUtils.isNotNull(data) ? toSuccess(dataName, data) : toSuccess(ResultCode.NO_CONTENT.getCode(),ResultCode.NO_CONTENT.getMessage());
    }


    public AjaxResult toAjaxResult(Page<?> page){
        return toAjaxResult("pageData", page.getRecords());
    }
}