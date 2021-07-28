package com.laoxianghao.shop.mapper;

import com.laoxianghao.shop.entity.UserCart;
import com.laoxianghao.shop.entity.UserGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserGoodsMapper {
    //    订单生成前查找商品总数,用于检查用户需求量是否超标
    @Select("select * from t_goods where goodsId=#{id}")
    List<UserGoods> selectGoodsStorageById(@Param("id") Integer goodsId);

    //    订单生成后更改商品数量
    @Update("update t_goods set goodsStorage=#{goodsStorage},goodsSale=#{goodsSale} where goodsId=#{goodsId}")
    int updateUserGoods(@Param("goodsId") Integer goodsId,@Param("goodsStorage")Integer goodsStorage,@Param("goodsSale")Integer goodsSale);
}
