package com.laoxianghao.shop.mapper;


import com.laoxianghao.shop.entity.UserOrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserOrderDetailMapper {
    @Select("select * from v_orderdetail where orderId=#{id}")
    List<UserOrderDetail> selectUserOrderDetailById(@Param("id")Integer orderId);
}
