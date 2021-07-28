package com.laoxianghao.shop.controller;


import com.laoxianghao.shop.service.AddressService;
import com.laoxianghao.shop.util.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService service;
    @RequestMapping("/find.action")
    public String findAll(Integer userId){
//        this.service.selectAddress(userId);
        Map map = new LinkedHashMap();
        map.put("address",this.service.selectAddress(userId));
        return JsonTools.querySuccess(map);
    }
}
