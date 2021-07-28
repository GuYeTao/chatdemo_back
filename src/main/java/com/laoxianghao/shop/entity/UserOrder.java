package com.laoxianghao.shop.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserOrder {
    private Integer orderId;
    private Integer userId;
    private Integer addressId;
    private String userName;
    private String userTel;
    private String addressUser;
    private String addressSite;
    private String addressTel;
    private Integer orderState;
    private Date orderCreateTime;

    public UserOrder(){
        super();
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

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
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

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }
}
