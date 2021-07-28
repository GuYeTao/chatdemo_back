package com.laoxianghao.shop.mapper;


import com.laoxianghao.shop.entity.Address;
import com.laoxianghao.shop.entity.PayWay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PayWayMapper {
    //    查找支付方式
    @Select("select * from t_payway")
    List<PayWay> selectPayWay();
}
