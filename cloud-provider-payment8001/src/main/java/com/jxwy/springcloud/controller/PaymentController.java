package com.jxwy.springcloud.controller;

import com.jxwy.springcloud.entities.CommenResult;
import com.jxwy.springcloud.entities.Payment;
import com.jxwy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/creat")
    public CommenResult creat(@RequestBody Payment payment){
        int result = paymentService.creat(payment);
        log.info("*****插入数据成功"+result);
        if(result>0){
            return new CommenResult(200,"插入数据成功",result);
        }else{
            return new CommenResult(444,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommenResult getPaymentById(@PathVariable("id") Long  id ){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询数据成功"+payment);
        if(payment != null){
            return new CommenResult(200,"查询数据成功"+"热部署serverPort"+serverPort,payment);
        }else{
            return new CommenResult(444,"没有对应纪录"+id+"热部署没有成功",null);
        }
    }

    @GetMapping(value = "/payment/discover")
    public Object discover(){
      List<String> discover=discoveryClient.getServices();
       for(String service: discover){
           log.info("service服务"+service);
       }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info("======"+instance.getHost()+"\t"+instance.getInstanceId()+"\t"+instance.getServiceId()+"\t"+instance.getUri() );
        }
        return this.discoveryClient ;
    }

}
