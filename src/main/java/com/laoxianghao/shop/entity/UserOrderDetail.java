package com.laoxianghao.shop.entity;

import java.util.Date;

public class UserOrderDetail {
    private Integer userId;
    private Integer addressId;
    private Integer orderId;
    private Integer gtotSaleNum;
    private boolean gtotEvaluateState;
    private String goodsName;
    private String goodsPicture;
    private Double goodsPrice;
    private String typeName;
    private Integer goodsId;

    public UserOrderDetail(){
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGtotSaleNum() {
        return gtotSaleNum;
    }

    public void setGtotSaleNum(Integer gtotSaleNum) {
        this.gtotSaleNum = gtotSaleNum;
    }

    public boolean isGtotEvaluateState() {
        return gtotEvaluateState;
    }

    public void setGtotEvaluateState(boolean gtotEvaluateState) {
        this.gtotEvaluateState = gtotEvaluateState;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
