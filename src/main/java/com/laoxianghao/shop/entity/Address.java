package com.laoxianghao.shop.entity;

public class Address {
    private Integer addressId;
    private Integer userId;
    private String addressUser;
    private String addressSite;
    private String addressTel;

    public Address(){
        super();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
