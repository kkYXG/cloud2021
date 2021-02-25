package com.jxwy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicaitionContextConfig {

    @Bean
    @LoadBalanced  //该注解赋予RestTemplate  负载均衡的能力
     public RestTemplate restTemplate(){
         return new RestTemplate();
     }
}
