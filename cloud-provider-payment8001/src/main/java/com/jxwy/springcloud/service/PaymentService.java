package com.jxwy.springcloud.service;

import com.jxwy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public int creat(Payment payment);

    public Payment getPaymentById(@Param("Id") Long id);
}
