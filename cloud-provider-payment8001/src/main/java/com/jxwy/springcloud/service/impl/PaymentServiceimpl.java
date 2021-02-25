package com.jxwy.springcloud.service.impl;

import com.jxwy.springcloud.entities.Payment;
import com.jxwy.springcloud.dao.PaymentDao;
import com.jxwy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceimpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int creat(Payment payment){
      return   paymentDao.creat(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
