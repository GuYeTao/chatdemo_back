package com.laoxianghao.shop.service;


import com.laoxianghao.shop.entity.GtoTList;
import com.laoxianghao.shop.mapper.GtoTListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GtoTListService {
    public void setMapper(GtoTListMapper mapper){
        this.mapper = mapper;
    }
    @Autowired
    private GtoTListMapper mapper;

    public void addgtotList(GtoTList gtoTList){
        this.mapper.insertgtotList(gtoTList);
    }
}
