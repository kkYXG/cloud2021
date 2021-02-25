package com.jxwy.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommenResult <T> {

    private Integer code;  // 200  404   500  返回成功失败编号；
    private String message;
    private    T    data;

    public  CommenResult(Integer code,String message){
            this(code,message,null);
    }
}
