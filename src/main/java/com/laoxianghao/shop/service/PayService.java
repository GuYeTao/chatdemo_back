package com.laoxianghao.shop.service;


import com.laoxianghao.shop.entity.Pay;
import com.laoxianghao.shop.entity.UserOrder;
import com.laoxianghao.shop.mapper.PayMapper;
import com.laoxianghao.shop.mapper.UserCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayService {
    public void setMapper(PayMapper mapper){
        this.mapper = mapper;
    }
    @Autowired
    private PayMapper mapper;
    public void addPay(Pay pay){
        this.mapper.insertPay(pay);
    }
}
