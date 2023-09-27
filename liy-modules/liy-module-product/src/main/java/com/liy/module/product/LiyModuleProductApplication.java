package com.liy.module.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LiY
 */

@SpringBootApplication
@EnableDiscoveryClient
public class LiyModuleProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiyModuleProductApplication.class, args);

        System.out.println("\n--------------------------------商品模块启动--------------------------------\n");

//        new Test().test1();
    }
}
