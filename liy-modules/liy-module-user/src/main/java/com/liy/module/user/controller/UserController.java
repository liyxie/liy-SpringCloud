package com.liy.module.user.controller;

import com.liy.common.security.AuthUserContext;
import com.liy.common.core.web.controller.BaseController;
import com.liy.common.core.web.domain.AjaxResult;
import com.liy.model.user.UserMapMapper;
import com.liy.model.user.dto.UserUpdateDto;
import com.liy.model.user.vo.UserInfoVo;
import com.liy.model.user.vo.UserSimpleInfoVO;
import com.liy.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author liy
 * @since 2023-09-04
 */

@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test1(){
        return "Ok";
    }

    /**
     * @description: 获得用户简单信息
     * @author: liy
     * @param:
     * @return:
     **/
    @GetMapping("/simple_info")
    public AjaxResult getSimpleUserInfo(){
        Long userId = AuthUserContext.get().getUserId();

        UserInfoVo userInfoVo = userService.getByUserId(userId);

        UserSimpleInfoVO userSimpleInfoVO = UserMapMapper.INSTANCE.toUserSimpleInfoVO(userInfoVo);

        return toAjaxResult("UserSimpleInfo", userSimpleInfoVO);
    }

    /**
     * @description: 用户信息
     * @author: liy
     * @param:
     * @return:
     **/
    @GetMapping("/user_info")
    public AjaxResult getUserInfo(){
        Long userId = AuthUserContext.get().getUserId();
        UserInfoVo userInfoVo = userService.getByUserId(userId);
        return toAjaxResult("UserInfo", userInfoVo);
    }

    /**
     * @description: 更新用户信息
     * @author: liy
     * @param:
     * @return:
     **/
    @PostMapping("/update_user")
    public AjaxResult update(@Validated @RequestBody UserUpdateDto userDto){
        userService.update(userDto);
    }





}
