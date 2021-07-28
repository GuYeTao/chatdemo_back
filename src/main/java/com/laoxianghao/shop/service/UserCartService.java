package com.laoxianghao.shop.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laoxianghao.shop.entity.UserCart;
import com.laoxianghao.shop.entity.UserOrder;
import com.laoxianghao.shop.mapper.UserCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCartService {
    public void setMapper(UserCartMapper mapper){
        this.mapper = mapper;
    }
    @Autowired
    private UserCartMapper mapper;

    public PageInfo<UserCart> getUserCarts(Integer pn, Integer rn, Integer userId){
        if(pn == null)pn = 1;
        if(rn == null)rn = 10;
        PageHelper.startPage(pn,rn);
        List<UserCart> list = mapper.selectUserCartById(userId);
//        System.out.println(new Gson().toJson(list));
        PageInfo p = new PageInfo(list);
        return p;
    }

    public void addUserCart(UserCart userCart){
        this.mapper.insertUserCart(userCart);
    }
    public void updateUserCart(Integer cartId, Integer cartNum){
        this.mapper.updateUserCart(cartId, cartNum);
    }
    public void delUserCart(Integer cartId){
        this.mapper.deleteUserCartById(cartId);
    }

    public void addUserOrderList(UserOrder userOrder){
        this.mapper.insertOrderList(userOrder);
    }
}
