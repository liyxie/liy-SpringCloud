package com.liy.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Author LiY
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.liy.*")
public class LiyGatewayApplication {

    public static void main(String[] args) {

        SpringApplication.run(LiyGatewayApplication.class, args);



        System.out.println("\n-------------------------------网关模块启动--------------------------------\n");




    }
}
