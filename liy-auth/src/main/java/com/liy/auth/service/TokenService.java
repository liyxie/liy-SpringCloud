package com.liy.auth.service;

import com.liy.auth.api.TokenFeignClient;
import com.liy.common.cache.constant.CacheNames;
import com.liy.common.cache.service.RedisService;
import com.liy.common.core.util.StringUtils;
import com.liy.model.user.auth.AuthAccountInfoPo;
import com.liy.model.user.auth.token.TokenInfoPo;
import com.liy.model.user.auth.token.TokenInfoVo;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @Author LiY
 * token
 */

@Service
@Transactional
@RefreshScope
@Slf4j
public class TokenService {

    @Autowired
    private RedisService reidsService;

    private Long teme = 300000L;

    /**
     * @description: 根据 用户信息创建 返回前端的令牌
     * @author: liy
     * @param:
     * @return:
     **/
    public TokenInfoVo createTokenVoByUserInfo(AuthAccountInfoPo authAccountInfoPo) {
        TokenInfoPo tokenInfoPo = createTokenPoByUserInfo(authAccountInfoPo);

        return new TokenInfoVo(tokenInfoPo);
    }

    /**
     * @description: 根据 用户信息创建 完整令牌 并存入Redis
     * @author: liy
     * @param:
     * @return:
     **/
    private TokenInfoPo createTokenPoByUserInfo(AuthAccountInfoPo authAccountInfoPo) {
        TokenInfoPo tokenInfoPo = new TokenInfoPo();

        tokenInfoPo.setUserInfoInToken(authAccountInfoPo);
        String token = IdUtil.simpleUUID();

        tokenInfoPo.setAccessToken(token);
        // 有效时间
        tokenInfoPo.setExpiresIn(teme);

        refreshToken(tokenInfoPo);
        log.info(tokenInfoPo.toString());
        return tokenInfoPo;

    }

    /**
     * @description: 刷新Token
     * @author: liy
     * @param:
     * @return:
     **/
    private void refreshToken(TokenInfoPo tokenInfoPo) {
        String key = getTokenKey(tokenInfoPo);

        reidsService.setCacheObject(key, tokenInfoPo, tokenInfoPo.getExpiresIn(), TimeUnit.MINUTES);
    }

    private String getTokenKey(TokenInfoPo tokenInfoPo) {
        return CacheNames.USER_INFO + tokenInfoPo.getAccessToken();
    }

    private String getTokenKey(String token) {
        return CacheNames.USER_INFO + token;
    }

    /**
     * @description: 检验Token，返回Token用户
     * @author: liy
     * @param:
     * @return:
     **/
    public AuthAccountInfoPo checkToken(String accessToken) {
        AuthAccountInfoPo authAccountInfoPo = null;
        try {
            if (StringUtils.isNotEmpty(accessToken)){
                String key = getTokenKey(accessToken);
                log.info(key);
                if(reidsService.hasKey(key)){
                    TokenInfoPo tokenInfoPo = reidsService.getCacheObject(key);
                    refreshToken(tokenInfoPo);
                    return tokenInfoPo.getUserInfoInToken();
                }
                else {
                    throw new RuntimeException("令牌过期");
                }

            }
        }
        catch (Exception e){
            log.error("获取用户信息异常'{}'", e.getMessage());
        }
        return authAccountInfoPo;
    }

}
