package com.laoxianghao.shop.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laoxianghao.shop.entity.UserOrder;
import com.laoxianghao.shop.entity.UserOrderCondition;
import com.laoxianghao.shop.entity.UserTransport;
import com.laoxianghao.shop.entity.UserTransportCondition;
import com.laoxianghao.shop.mapper.UserOrderMapper;
import com.laoxianghao.shop.mapper.UserTransportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTransportService {
    @Autowired
    private UserTransportMapper userTransportMapper;

    public PageInfo<UserTransport> getUserTransportsByCondition(Integer pn, Integer rn, UserTransportCondition userTransportCondition){
        if(pn==null){
            pn=1;
        }
        if(rn==null){
            rn=10;
        }
        PageHelper.startPage(pn,rn);
        List<UserTransport> list=userTransportMapper.selectUserTransportByCondition(userTransportCondition);
        return new PageInfo(list);
    }
}
