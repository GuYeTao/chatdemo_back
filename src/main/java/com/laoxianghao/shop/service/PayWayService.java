package com.laoxianghao.shop.service;


import com.laoxianghao.shop.entity.Address;
import com.laoxianghao.shop.entity.PayWay;
import com.laoxianghao.shop.mapper.AddressMapper;
import com.laoxianghao.shop.mapper.PayWayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayWayService {
    public void setMapper(PayWayMapper mapper){
        this.mapper = mapper;
    }
    @Autowired
    private PayWayMapper mapper;

    public List<PayWay> selectPayWay(){
        return mapper.selectPayWay();
    }
}
