package com.laoxianghao.shop.entity;

import java.util.Date;

public class UserTransportDetail {
    private Integer transportId;
    private Integer orderId;
    private Integer userId;
    private Date transportDeliverTime;
    private Date transportArriveTime;
    private Integer riderId;
    private Integer goodsId;
    private Integer gtotSaleNum;
    private String goodsName;
    private String typeName;
    private String goodsPicture;
    private boolean transportState;

    public UserTransportDetail(){
        super();
    }

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTransportDeliverTime() {
        return transportDeliverTime;
    }

    public void setTransportDeliverTime(Date transportDeliverTime) {
        this.transportDeliverTime = transportDeliverTime;
    }

    public Date getTransportArriveTime() {
        return transportArriveTime;
    }

    public void setTransportArriveTime(Date transportArriveTime) {
        this.transportArriveTime = transportArriveTime;
    }

    public Integer getRiderId() {
        return riderId;
    }

    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGtotSaleNum() {
        return gtotSaleNum;
    }

    public void setGtotSaleNum(Integer gtotSaleNum) {
        this.gtotSaleNum = gtotSaleNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public boolean isTransportState() {
        return transportState;
    }

    public void setTransportState(boolean transportState) {
        this.transportState = transportState;
    }
}
