package com.liy.module.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liy.model.user.UserMapMapper;
import com.liy.model.user.vo.UserInfoVo;
import com.liy.module.user.mapper.UserMapper;
import com.liy.module.user.service.UserService;
import com.liy.model.user.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author liy
 * @since 2023-09-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfoVo getByUserId(Long userId) {
        UserPo userPo = getById(userId);
        return UserMapMapper.INSTANCE.toUserInfoVo(userPo);
    }

}
