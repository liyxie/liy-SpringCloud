package com.liy.auth.feign;

import com.liy.auth.api.TokenFeignClient;
import com.liy.auth.service.TokenService;
import com.liy.model.user.auth.AuthAccountInfoPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LiY
 */

@RestController
public class TokenFeignController  implements TokenFeignClient{

    @Autowired
    private TokenService tokenService;

    @Override
    public AuthAccountInfoPo checkToken(String accessToken) {

        return tokenService.checkToken(accessToken);
    }

    @Override
    public String test() {
        return "1";
    }
}
