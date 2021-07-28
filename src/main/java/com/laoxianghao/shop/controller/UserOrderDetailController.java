package com.laoxianghao.shop.controller;


import com.github.pagehelper.PageInfo;
import com.laoxianghao.shop.entity.UserOrder;
import com.laoxianghao.shop.entity.UserOrderCondition;
import com.laoxianghao.shop.entity.UserOrderDetail;
import com.laoxianghao.shop.service.UserOrderDetailService;
import com.laoxianghao.shop.service.UserOrderService;
import com.laoxianghao.shop.util.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userorderdetail")
public class UserOrderDetailController {
    @Autowired
    private UserOrderDetailService userOrderDetailService;

    @RequestMapping("/find.action")
    public String findUserOrderDetail(int pn, int rn, Integer orderId){
        PageInfo<UserOrderDetail> pageInfo=userOrderDetailService.getUserOrderDetailsById(pn,rn,orderId);
        List<UserOrderDetail> userOrderDetails=pageInfo.getList();
        Long total=pageInfo.getTotal();
        Map map=new LinkedHashMap();
        map.put("userOrderDetails",userOrderDetails);
        map.put("total",total);
        return JsonTools.querySuccess(map);
    }
}
