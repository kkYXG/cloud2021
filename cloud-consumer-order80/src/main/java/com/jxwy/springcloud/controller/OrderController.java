package com.jxwy.springcloud.controller;

import com.jxwy.springcloud.entities.CommenResult;
import com.jxwy.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommenResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/creat",payment,CommenResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommenResult<Payment> getPayment(@PathVariable("id") Long id){
        return   restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommenResult.class);
    }
}
