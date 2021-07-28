package com.laoxianghao.shop.mapper;


import com.laoxianghao.shop.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper {
    //    查找用户地址
    @Select("select * from t_address where userId=#{id}")
    List<Address> selectAddressById(@Param("id") Integer userId);
}
