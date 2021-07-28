package com.laoxianghao.shop.mapper;


import com.laoxianghao.shop.entity.UserTransportDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserTransportDetailMapper {
    @Select("select * from v_transportdetail where transportId=#{id}")
    List<UserTransportDetail> selectUserTransportDetailById(@Param("id")Integer transportId);
}
