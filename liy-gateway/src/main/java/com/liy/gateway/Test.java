package com.liy.gateway;

import com.liy.auth.api.TokenFeignClient;
import com.liy.model.user.auth.AuthAccountInfoPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author LiY
 */

//@Component
public class Test {

    @Autowired
    private TokenFeignClient tokenFeignClient;


    ExecutorService executorService = Executors.newFixedThreadPool(1);

    String token = "6b93d152421942e2abd10d079a65ac3a";

    Future<AuthAccountInfoPo> future = executorService.submit( () -> tokenFeignClient.checkToken(token));

    AuthAccountInfoPo authAccountInfoPo;

    {
        try {
            authAccountInfoPo = future.get();
            System.out.println(authAccountInfoPo.toString());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
