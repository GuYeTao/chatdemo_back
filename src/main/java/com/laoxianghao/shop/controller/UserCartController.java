package com.laoxianghao.shop.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.laoxianghao.shop.entity.Chat;
import com.laoxianghao.shop.entity.ChatCondition;
import com.laoxianghao.shop.entity.UserCart;
import com.laoxianghao.shop.entity.UserOrder;
import com.laoxianghao.shop.service.ChatService;
import com.laoxianghao.shop.service.UserCartService;
import com.laoxianghao.shop.util.JsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/usercart")
public class UserCartController {
    public void setService(UserCartService service){
        System.out.println("UserCartController setservice");
        this.service = service;
    }
    public UserCartService getService(){
        return service;
    }

    @Autowired
    private UserCartService service;
    @RequestMapping("/find.action")
    public String findAll(Integer pn, Integer rn, Integer userId){
        PageInfo<UserCart> p = service.getUserCarts(pn, rn, userId);
        List<UserCart> userCarts = p.getList();
        long total = p.getTotal();
        Map map = new LinkedHashMap();
        map.put("userCarts",userCarts);
        map.put("total", total);
        return JsonTools.querySuccess(map);
    }


    @RequestMapping("/update.action")
    public String update(Integer cartId, Integer cartNum){
        this.service.updateUserCart(cartId, cartNum);
        Map map = new LinkedHashMap();
        map.put("cartId",cartId);
        return JsonTools.querySuccess(map);
    }

    @RequestMapping("/del.action")
    public String del(Integer id){
        System.out.println(id);
        this.service.delUserCart(id);
        return JsonTools.executeSuccess();
    }

//    生成订单
    @RequestMapping("/add.action")
    public String add(UserOrder userOrder){
        this.service.addUserOrderList(userOrder);
        System.out.println(new Gson().toJson(userOrder));
        Map map = new LinkedHashMap();
        map.put("orderId",userOrder.getOrderId());
//        System.out.println(new Gson().toJson(map));
        return JsonTools.querySuccess(map);
//        return JsonTools.executeSuccess();
    }
}
