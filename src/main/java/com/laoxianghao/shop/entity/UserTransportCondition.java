package com.laoxianghao.shop.entity;


public class UserTransportCondition {

    private Integer transportId;
    private Integer userId;
    private Integer orderId;
    private Integer transportState;

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTransportState() {
        return transportState;
    }

    public void setTransportState(Integer transportState) {
        this.transportState = transportState;
    }
}
