package com.laoxianghao.shop.service;


import com.laoxianghao.shop.entity.UserVip;
import com.laoxianghao.shop.mapper.UserVipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVipService {
    public void setMapper(UserVipMapper mapper){
        this.mapper = mapper;
    }
    @Autowired
    private UserVipMapper mapper;

    public UserVip selectvipremainder(Integer userId){
        return mapper.selectvipremainder(userId);
    }

    public void updateVip(Double vipremainder, Integer userId){
        this.mapper.updateVip(vipremainder, userId);
    }
}
