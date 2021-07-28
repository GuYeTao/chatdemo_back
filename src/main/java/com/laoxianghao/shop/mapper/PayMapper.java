package com.laoxianghao.shop.mapper;

import com.laoxianghao.shop.entity.Pay;
import com.laoxianghao.shop.entity.UserOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PayMapper {
    //    生成支付表
    @Insert("insert into t_pay values(null,#{c.userId},#{c.orderId},#{c.payWayId},#{c.payPrice},#{c.payTime})")
    void insertPay(@Param("c") Pay pay);
}
