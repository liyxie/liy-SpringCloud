package com.liy.module.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liy.model.user.po.UserPo;
import com.liy.model.user.vo.UserInfoVo;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author liy
 * @since 2023-09-04
 */
public interface UserService extends IService<UserPo> {

    public UserInfoVo getByUserId(Long userId);

}
