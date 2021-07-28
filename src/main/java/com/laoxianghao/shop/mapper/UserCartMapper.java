package com.laoxianghao.shop.mapper;


import com.laoxianghao.shop.entity.Chat;
import com.laoxianghao.shop.entity.UserCart;
import com.laoxianghao.shop.entity.UserOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserCartMapper {

    @Select("select * from v_cart")
    List<UserCart> selectUserCart();

    //    查找用户购物车
    @Select("select * from v_cart where userId=#{id}")
    List<UserCart> selectUserCartById(@Param("id") Integer userId);

    //    购物车中添加商品
    @Insert("insert into t_cart values(null,#{c.userId},#{c.goodsId},#{c.cartNum})")
    void insertUserCart(@Param("c") UserCart userChat);

//    购物车中修改商品数
    @Update("update t_cart set cartNum=#{cartNum} where cartId=#{cartId}")
    int updateUserCart(@Param("cartId") Integer cartId,@Param("cartNum")Integer cartNum);

    //    购物车中删除商品
    @Delete("delete from t_cart where cartId=#{id}")
    void deleteUserCartById(@Param("id")Integer cartId);

    //    生成订单
//    @Insert("insert into t_orderlist values(null,#{c.userId},#{c.addressId},#{c.orderState},#{c.orderCreateTime})")
    void insertOrderList(@Param("c") UserOrder userOrder);

}
