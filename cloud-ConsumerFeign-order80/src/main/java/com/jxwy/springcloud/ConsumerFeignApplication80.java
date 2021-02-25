package com.jxwy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication80.class,args);
    }
}
