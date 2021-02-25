package com.jxwy.springcloud.service;


import com.jxwy.springcloud.entities.CommenResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderFeignService {


    @GetMapping(value = "/payment/get/{id}")
    public CommenResult getPaymentById(@PathVariable("id") Long  id );

}
