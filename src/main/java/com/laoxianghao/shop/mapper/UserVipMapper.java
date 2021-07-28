package com.laoxianghao.shop.mapper;

import com.laoxianghao.shop.entity.Address;
import com.laoxianghao.shop.entity.UserVip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserVipMapper {

    @Select("select * from t_vip where userId=#{id}")
    UserVip selectvipremainder(@Param("id") Integer userId);
    //    修改vip余额
    @Update("update t_vip set vipremainder=#{vipremainder} where userId=#{id}")
    int updateVip(@Param("vipremainder") Double vipremainder, @Param("id")Integer userId);
}
