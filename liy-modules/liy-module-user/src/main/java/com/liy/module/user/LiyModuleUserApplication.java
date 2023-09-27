package com.liy.module.user;

import com.liy.module.user.service.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author LiY
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.liy.**.api")
public class LiyModuleUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiyModuleUserApplication.class, args);

        System.out.println("\n--------------------------------用户模块启动--------------------------------\n");

//        new Test().test1();
    }
}
