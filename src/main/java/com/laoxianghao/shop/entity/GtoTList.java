package com.laoxianghao.shop.entity;

public class GtoTList {
    private Integer orderId;
    private Integer goodsId;
    private Integer gtotSaleNum;
    private Boolean gtotEvaluateState;

    public GtoTList(){
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Boolean getGtotEvaluateState() {
        return gtotEvaluateState;
    }

    public void setGtotEvaluateState(Boolean gtotEvaluateState) {
        this.gtotEvaluateState = gtotEvaluateState;
    }
}
