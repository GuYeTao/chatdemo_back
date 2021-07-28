package com.laoxianghao.shop.mapper;


import com.laoxianghao.shop.entity.GtoTList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GtoTListMapper {

    //    构建关系
    @Insert("insert into t_gtotlist values(null,#{c.orderId},null,#{c.goodsId},#{c.gtotSaleNum},#{c.gtotEvaluateState})")
    void insertgtotList(@Param("c") GtoTList gtoTList);
}
