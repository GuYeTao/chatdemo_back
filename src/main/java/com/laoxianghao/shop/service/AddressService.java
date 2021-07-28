package com.laoxianghao.shop.service;


import com.laoxianghao.shop.entity.Address;
import com.laoxianghao.shop.mapper.AddressMapper;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    public void setMapper(AddressMapper mapper){
        this.mapper = mapper;
    }
    @Autowired
    private AddressMapper mapper;

    public List<Address> selectAddress(Integer userId){
        return mapper.selectAddressById(userId);
    }
}
