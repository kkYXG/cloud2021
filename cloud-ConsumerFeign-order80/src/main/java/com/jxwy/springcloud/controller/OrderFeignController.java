package com.jxwy.springcloud.controller;

import com.jxwy.springcloud.entities.CommenResult;
import com.jxwy.springcloud.service.OrderFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private OrderFeignService orderFeignService;


    @GetMapping(value = "/consulmer/payment/get/{id}")
    public CommenResult getPaymentById(@PathVariable("id") Long  id ){
        return orderFeignService.getPaymentById(id);
    }
}
