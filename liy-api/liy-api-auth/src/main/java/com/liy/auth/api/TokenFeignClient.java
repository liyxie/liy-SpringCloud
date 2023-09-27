package com.liy.auth.api;

import com.liy.auth.constant.Auth;
import com.liy.model.user.auth.AuthAccountInfoPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author LiY
 */

@Component
@FeignClient(value = "liy-auth", contextId = "token")
public interface TokenFeignClient {

    /**
     * @description: 检验token，返回用户信息
     * @author: liy
     * @param:
     * @return:
     **/
    @GetMapping(value = Auth.CHECK_TOKEN_URI)
    AuthAccountInfoPo checkToken(@RequestParam("accessToken") String accessToken);

    @GetMapping("/token")
    String test();
}
