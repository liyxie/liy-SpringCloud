package com.liy.auth;

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
public class LiyAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiyAuthApplication.class, args);

        System.out.println("\n--------------------------------认证模块启动--------------------------------\n");

    }
}
