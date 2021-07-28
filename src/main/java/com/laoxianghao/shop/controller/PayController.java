package com.laoxianghao.shop.controller;


import com.google.gson.Gson;
import com.laoxianghao.shop.entity.Pay;
import com.laoxianghao.shop.entity.UserOrder;
import com.laoxianghao.shop.service.PayService;
import com.laoxianghao.shop.service.UserCartService;
import com.laoxianghao.shop.util.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController {
    public void setService(PayService service){
        System.out.println("PayController setservice");
        this.service = service;
    }
    public PayService getService(){
        return service;
    }

    @Autowired
    private PayService service;
    //    生成支付表
    @RequestMapping("/add.action")
    public String add(Pay pay){
        this.service.addPay(pay);
        System.out.println(new Gson().toJson(pay));
        Map map = new LinkedHashMap();
        map.put("payTime",pay.getPayTime());
//        System.out.println(new Gson().toJson(map));
        return JsonTools.querySuccess(map);
//        return JsonTools.executeSuccess();
    }
}
