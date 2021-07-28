package com.laoxianghao.shop.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laoxianghao.shop.entity.UserOrder;
import com.laoxianghao.shop.entity.UserOrderCondition;
import com.laoxianghao.shop.entity.UserOrderDetail;
import com.laoxianghao.shop.mapper.UserOrderDetailMapper;
import com.laoxianghao.shop.mapper.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderDetailService {


    @Autowired
    private UserOrderDetailMapper userOrderDetailMapper;

    public PageInfo<UserOrderDetail> getUserOrderDetailsById(Integer pn, Integer rn, Integer orderId){
        if(pn==null){
            pn=1;
        }
        if(rn==null){
            rn=10;
        }
        PageHelper.startPage(pn,rn);
        List<UserOrderDetail> list=userOrderDetailMapper.selectUserOrderDetailById(orderId);
        return new PageInfo(list);
    }
}
