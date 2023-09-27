package com.liy.module.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LiY
 */

@SpringBootApplication
@EnableDiscoveryClient
public class LiyModuleOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiyModuleOrderApplication.class, args);

        System.out.println("\n--------------------------------订单模块启动--------------------------------\n");

    }


}
