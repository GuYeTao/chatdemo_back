package com.laoxianghao.shop.controller;

import com.github.pagehelper.PageInfo;
import com.laoxianghao.shop.entity.UserOrderDetail;
import com.laoxianghao.shop.entity.UserTransportDetail;
import com.laoxianghao.shop.service.UserOrderDetailService;
import com.laoxianghao.shop.service.UserTransportDetailService;
import com.laoxianghao.shop.util.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usertransportdetail")
public class UserTransportDetailController {
    @Autowired
    private UserTransportDetailService userTransportDetailService;

    @RequestMapping("/find.action")
    public String findUserTransportDetail(int pn, int rn, Integer transportId){
        PageInfo<UserTransportDetail> pageInfo=userTransportDetailService.getUserTransportDetailsById(pn,rn,transportId);
        List<UserTransportDetail> userTransportDetails=pageInfo.getList();
        Long total=pageInfo.getTotal();
        Map map=new LinkedHashMap();
        map.put("userTransportDetails",userTransportDetails);
        map.put("total",total);
        return JsonTools.querySuccess(map);
    }
}
