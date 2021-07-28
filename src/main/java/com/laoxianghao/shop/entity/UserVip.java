package com.laoxianghao.shop.entity;

public class UserVip {
    private Integer vipId;
    private Integer userId;
    private Double vipremainder;

    public UserVip(){
        super();
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getVipremainder() {
        return vipremainder;
    }

    public void setVipremainder(Double vipremainder) {
        this.vipremainder = vipremainder;
    }
}
