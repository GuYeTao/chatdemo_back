package com.laoxianghao.shop.service;


import com.laoxianghao.shop.entity.UserGoods;
import com.laoxianghao.shop.mapper.UserGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGoodsService {
    public void setMapper(UserGoodsMapper mapper){
        this.mapper = mapper;
    }
    @Autowired
    private UserGoodsMapper mapper;

    public List<UserGoods> selectGoodsStorage(Integer goodsId){
        return mapper.selectGoodsStorageById(goodsId);
    }
    public void updateUserGoods(Integer goodsId, Integer goodsStorage, Integer goodsSale){
        this.mapper.updateUserGoods(goodsId, goodsStorage, goodsSale);
    }
}
