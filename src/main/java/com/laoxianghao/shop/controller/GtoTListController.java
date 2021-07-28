package com.laoxianghao.shop.controller;


import com.google.gson.Gson;
import com.laoxianghao.shop.entity.GtoTList;
import com.laoxianghao.shop.service.GtoTListService;
import com.laoxianghao.shop.util.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/gtotlist")
public class GtoTListController {
    public void setService(GtoTListService service){
        System.out.println("GtoTListController setservice");
        this.service = service;
    }
    public GtoTListService getService(){
        return service;
    }

    @Autowired
    private GtoTListService service;
    //    生成关系
    @RequestMapping("/add.action")
    public String add(GtoTList gtoTList){
        this.service.addgtotList(gtoTList);
        System.out.println(new Gson().toJson(gtoTList));
        Map map = new LinkedHashMap();
        map.put("orderId",gtoTList.getOrderId());
//        System.out.println(new Gson().toJson(map));
        return JsonTools.querySuccess(map);
//        return JsonTools.executeSuccess();
    }
}
