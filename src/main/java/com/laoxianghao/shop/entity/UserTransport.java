package com.laoxianghao.shop.entity;

import java.util.Date;

public class UserTransport {
    private Integer transportId;
    private Integer riderId;
    private Date transportDeliverTime;
    private Date transportArriveTime;
    private boolean transportState;
    private String riderName;
    private Integer addressId;
    private String addressUser;
    private String addressSite;
    private String addressTel;
    private Integer userId;
    private Integer orderId;


    public UserTransport(){
        super();
    }

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public Integer getRiderId() {
        return riderId;
    }

    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
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

    public boolean isTransportState() {
        return transportState;
    }

    public void setTransportState(boolean transportState) {
        this.transportState = transportState;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public String getAddressSite() {
        return addressSite;
    }

    public void setAddressSite(String addressSite) {
        this.addressSite = addressSite;
    }

    public String getAddressTel() {
        return addressTel;
    }

    public void setAddressTel(String addressTel) {
        this.addressTel = addressTel;
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
}
