package com.laoxianghao.shop.mapper;


import com.laoxianghao.shop.entity.UserOrder;
import com.laoxianghao.shop.entity.UserOrderCondition;
import com.laoxianghao.shop.entity.UserTransport;
import com.laoxianghao.shop.entity.UserTransportCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserTransportMapper {

    @Select("select * from v_transport")
    List<UserTransport> selectUserTransport();

    //    按情况查找运单
    @Select("select * from v_transport where userId=#{c.userId} and " +
            "(#{c.transportId} is null or transportId = #{c.transportId}) and " +
            "(#{c.orderId} is null or orderId = #{c.orderId}) and " +
            "(#{c.transportState} is null or transportState = #{c.transportState})")
            List<UserTransport> selectUserTransportByCondition(@Param("c") UserTransportCondition userTransportCondition);

}
