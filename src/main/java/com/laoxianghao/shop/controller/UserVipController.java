package com.laoxianghao.shop.controller;

import com.google.gson.internal.$Gson$Preconditions;
import com.laoxianghao.shop.service.UserCartService;
import com.laoxianghao.shop.service.UserVipService;
import com.laoxianghao.shop.util.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@RequestMapping("/uservip")
public class UserVipController {
    public void setService(UserVipService service){
        System.out.println("UserVipController setservice");
        this.service = service;
    }
    public UserVipService getService(){
        return service;
    }

    @Autowired
    private UserVipService service;

    @RequestMapping("/find.action")
    public String findAll(Integer userId){
        Map map = new LinkedHashMap();
        System.out.println(this.service.selectvipremainder(userId));
        map.put("data",this.service.selectvipremainder(userId));
        return JsonTools.querySuccess(map);
    }

    @RequestMapping("/update.action")
    public String update(Double vipremainder, Integer userId){
        this.service.updateVip(vipremainder, userId);
        Map map = new LinkedHashMap();
        map.put("vipremainder",vipremainder);
        return JsonTools.querySuccess(map);
    }
}
