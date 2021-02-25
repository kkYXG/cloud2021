package com.jxwy.springcloud.controller;

import com.jxwy.springcloud.service.IMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {

    @Resource
    private IMessageService iMessageService;

    @GetMapping(value = "/send")
    public String send(){
       return iMessageService.send();
    }
}
