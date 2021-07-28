package com.laoxianghao.shop.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laoxianghao.shop.entity.UserTransportDetail;
import com.laoxianghao.shop.mapper.UserTransportDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTransportDetailService {
    @Autowired
    private UserTransportDetailMapper userTransportDetailMapper;

    public PageInfo<UserTransportDetail> getUserTransportDetailsById(Integer pn, Integer rn, Integer transportId){
        if(pn==null){
            pn=1;
        }
        if(rn==null){
            rn=10;
        }
        PageHelper.startPage(pn,rn);
        List<UserTransportDetail> list=userTransportDetailMapper.selectUserTransportDetailById(transportId);
        return new PageInfo(list);
    }

}
