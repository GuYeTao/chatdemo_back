package com.laoxianghao.shop.mapper;


import com.laoxianghao.shop.entity.Chat;
import com.laoxianghao.shop.entity.ChatCondition;
import com.laoxianghao.shop.entity.UserOrder;
import com.laoxianghao.shop.entity.UserOrderCondition;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserOrderMapper {
    @Select("select * from v_order")
    List<UserOrder> selectUserOrder();

    //    按情况查找订单
    @Select("select * from v_order where userId=#{c.userId} and " +
            "(#{c.orderId} is null or orderId = #{c.orderId}) and " +
            "(#{c.orderState} is null or orderState = #{c.orderState}) and " +
            "((#{c.startTime} is null) or orderCreateTime >= #{c.startTime}) and " +
            "((#{c.endTime} is null) or orderCreateTime <= #{c.endTime}) and " +
            "((#{c.startTime} is null and #{c.endTime} is null) or (orderCreateTime >= #{c.startTime} and orderCreateTime <= #{c.endTime}))")
    List<UserOrder> selectUserOrderByCondition(@Param("c") UserOrderCondition userOrderCondition);

    //    支付完成后修改订单状态
    @Update("update t_orderlist set orderState=#{orderState} where orderId=#{orderId}")
    int updateOrderList(@Param("orderId") Integer orderId,@Param("orderState")Integer orderState);

}
