package com.laoxianghao.shop.entity;

public class PayWay {
    private Integer payWayId;
    private String payWayType;

    public PayWay(){
        super();
    }

    public Integer getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(Integer payWayId) {
        this.payWayId = payWayId;
    }

    public String getPayWayType() {
        return payWayType;
    }

    public void setPayWayType(String payWayType) {
        this.payWayType = payWayType;
    }
}
