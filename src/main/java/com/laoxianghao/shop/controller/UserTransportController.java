package com.laoxianghao.shop.controller;


import com.github.pagehelper.PageInfo;
import com.laoxianghao.shop.entity.*;
import com.laoxianghao.shop.service.UserOrderDetailService;
import com.laoxianghao.shop.service.UserOrderService;
import com.laoxianghao.shop.service.UserTransportService;
import com.laoxianghao.shop.util.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usertransport")
public class UserTransportController {
    @Autowired
    private UserTransportService userTransportService;

    @RequestMapping("/find.action")
    public String findUserTransport(int pn, int rn, UserTransportCondition userTransportCondition){
        PageInfo<UserTransport> pageInfo=userTransportService.getUserTransportsByCondition(pn,rn,userTransportCondition);
        List<UserTransport> userTransports=pageInfo.getList();
        Long total=pageInfo.getTotal();
        Map map=new LinkedHashMap();
        map.put("userOrders",userTransports);
        map.put("total",total);
        return JsonTools.querySuccess(map);
    }
}
