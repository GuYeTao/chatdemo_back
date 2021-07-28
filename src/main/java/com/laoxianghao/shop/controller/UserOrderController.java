package com.laoxianghao.shop.controller;


import com.github.pagehelper.PageInfo;
import com.laoxianghao.shop.entity.UserOrder;
import com.laoxianghao.shop.entity.UserOrderCondition;
import com.laoxianghao.shop.service.UserOrderService;
import com.laoxianghao.shop.util.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userorder")
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping("/find.action")
    public String findUserOrder(int pn, int rn, UserOrderCondition userOrderCondition){
        System.out.println(userOrderCondition.getStartTime());
        System.out.println(userOrderCondition.getEndTime());
        PageInfo<UserOrder> pageInfo=userOrderService.getUserOrdersByCondition(pn,rn,userOrderCondition);
        List<UserOrder> userOrders=pageInfo.getList();
        Long total=pageInfo.getTotal();
        Map map=new LinkedHashMap();
        map.put("userOrders",userOrders);
        map.put("total",total);
        return JsonTools.querySuccess(map);
    }

    @RequestMapping("/update.action")
    public String update(Integer orderId, Integer orderState){
        this.userOrderService.updateOrderList(orderId, orderState);
        Map map = new LinkedHashMap();
        map.put("orderId",orderId);
        return JsonTools.querySuccess(map);
    }
}
