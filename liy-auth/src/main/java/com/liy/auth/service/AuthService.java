package com.liy.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liy.auth.mapper.AuthAccountMapper;
import com.liy.common.core.util.StringUtils;
import com.liy.model.user.auth.AuthAccountBo;
import com.liy.model.user.auth.AuthAccountInfoPo;
import com.liy.model.user.auth.AuthAccountMapMapper;
import com.liy.model.user.auth.constant.AuthAccountStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author LiY
 * 认证
 *
 */

@Service
@Transactional
@Slf4j
public class AuthService {

    @Autowired
    private AuthAccountMapper authAccountMapper;


    public AuthAccountInfoPo login(String userName, String password, Integer type) {

        if(StringUtils.isAnyBlank(userName, password)){
            throw new RuntimeException("用户名/密码为空");
        }

        // 查询用户信息
        LambdaQueryWrapper<AuthAccountBo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(AuthAccountBo::getUsername, userName)
                .eq(AuthAccountBo::getSysType, type);
        AuthAccountBo authAccountBo = authAccountMapper.selectOne(queryWrapper);

        if(StringUtils.isNull(authAccountBo)){
            throw new RuntimeException("不存在用户");

        }

        if(AuthAccountStatusEnum.DELETE.value().equals(authAccountBo.getStatus())){
            throw new RuntimeException("用户已禁用");
        }

        // 密码检验
        if(!authAccountBo.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        log.info(authAccountBo.toString());
        AuthAccountInfoPo authAccountInfoPo = AuthAccountMapMapper.INSTANCE.toInfoPo(authAccountBo);
        log.info(authAccountInfoPo.toString());
        authAccountInfoPo = new AuthAccountInfoPo(authAccountBo);
        log.info(authAccountInfoPo.toString());
        return authAccountInfoPo;
    }
}
