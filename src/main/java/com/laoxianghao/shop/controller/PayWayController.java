package com.laoxianghao.shop.controller;


import com.laoxianghao.shop.service.AddressService;
import com.laoxianghao.shop.service.PayWayService;
import com.laoxianghao.shop.util.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/payway")
public class PayWayController {
    @Autowired
    private PayWayService service;
    @RequestMapping("/find.action")
    public String findAll(){
        Map map = new LinkedHashMap();
        map.put("payway",this.service.selectPayWay());
        return JsonTools.querySuccess(map);
    }
}
