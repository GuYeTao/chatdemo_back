package com.laoxianghao.shop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laoxianghao.shop.entity.UserOrder;
import com.laoxianghao.shop.entity.UserOrderCondition;
import com.laoxianghao.shop.mapper.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserOrderService {

    @Autowired
    private UserOrderMapper userOrderMapper;

    public PageInfo<UserOrder> getUserOrdersByCondition(Integer pn, Integer rn, UserOrderCondition userOrderCondition){
        if(pn==null){
            pn=1;
        }
        if(rn==null){
            rn=10;
        }
        PageHelper.startPage(pn,rn);
        List<UserOrder> list=userOrderMapper.selectUserOrderByCondition(userOrderCondition);
        return new PageInfo(list);
    }

    public void updateOrderList(Integer orderId, Integer orderState){
        this.userOrderMapper.updateOrderList(orderId, orderState);
    }

}
