package com.laoxianghao.shop.controller;


import com.laoxianghao.shop.service.UserGoodsService;
import com.laoxianghao.shop.util.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/usergoods")
public class UserGoodsController {
    @Autowired
    private UserGoodsService service;
    @RequestMapping("/find.action")
    public String findAll(Integer goodsId){
        Map map = new LinkedHashMap();
        map.put("address",this.service.selectGoodsStorage(goodsId));
        return JsonTools.querySuccess(map);
    }

    @RequestMapping("/update.action")
    public String update(Integer goodsId, Integer goodsStorage, Integer goodsSale){
        System.out.println("goodsId:"+goodsId+"  goodsStorage:"+goodsStorage+"   goodsSale:"+goodsSale);
        this.service.updateUserGoods(goodsId, goodsStorage, goodsSale);
        Map map = new LinkedHashMap();
        map.put("goodsId",goodsId);
        return JsonTools.querySuccess(map);
    }
}
