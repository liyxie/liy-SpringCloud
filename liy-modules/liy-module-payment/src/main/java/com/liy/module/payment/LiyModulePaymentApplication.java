package com.liy.module.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LiY
 */

@SpringBootApplication
@EnableDiscoveryClient
public class LiyModulePaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiyModulePaymentApplication.class, args);

        System.out.println("\n--------------------------------支付模块启动--------------------------------\n");

//        new Test().test1();
    }
}
