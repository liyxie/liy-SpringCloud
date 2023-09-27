package com.liy.gateway.filter;

import com.liy.auth.api.TokenFeignClient;
import com.liy.common.core.constant.TokenConstants;
import com.liy.common.core.enums.ResultCode;
import com.liy.common.core.util.StringUtils;
import com.liy.common.core.util.WebUtil;
import com.liy.common.security.AuthUserContext;
import com.liy.model.user.auth.AuthAccountInfoPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author LiY
 * Token 过滤器
 */

@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {

    @Autowired
    private TokenFeignClient tokenFeignClient;

    ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();

        String url = request.getURI().getPath();

        if(url.equals("/auth/login")){
            return chain.filter(exchange);
        }

        String token = getToken(request);
        if (StringUtils.isEmpty(token))
        {
//            throw new  RuntimeException("令牌不能为空:"+exchange);
            return unauthorizedResponse(exchange, "令牌不能为空:");
        }

        Future<AuthAccountInfoPo> future = executorService.submit( () -> tokenFeignClient.checkToken(token));
        AuthAccountInfoPo authAccountInfoPo = null;

        try {
            authAccountInfoPo = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        if (authAccountInfoPo == null)
        {
//            throw new RuntimeException(exchange+":令牌已过期或验证不正确！");
            return unauthorizedResponse(exchange, ":令牌已过期或验证不正确！");
        }

        AuthUserContext.set(authAccountInfoPo);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -200;
    }

    private String getToken(ServerHttpRequest request)
    {
        String token = request.getHeaders().getFirst(TokenConstants.AUTHENTICATION);
        // 如果前端设置了令牌前缀，则裁剪掉前缀
        if (StringUtils.isNotEmpty(token) && token.startsWith(TokenConstants.PREFIX))
        {
            token = token.replaceFirst(TokenConstants.PREFIX, StringUtils.EMPTY);
        }
        return token;
    }

    /**
     * @description: 认证错误
     * @author: liy
     * @param:
     * @return:
     **/
    private Mono<Void> unauthorizedResponse(ServerWebExchange exchange, String msg)
    {
        log.error("[鉴权异常处理]请求路径:{}", exchange.getRequest().getPath());
        return WebUtil.renderString(exchange.getResponse(), msg, ResultCode.UNAUTHORIZED);
    }
}
