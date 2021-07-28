package com.laoxianghao.shop.entity;

import java.util.Date;

public class UserGoods {
    private Integer goodsId;
    private Integer typeId;
    private String goodsName;
    private String goodsPicture;
    private String goodsDetail;
    private Integer goodsStorage;
    private Integer goodsSale;
    private Double goodsPrice;
    private Double goodsGrade;
    private Integer goodsGradeNumber;
    private Date goodsCreateTime;
    private boolean goodsState;
    private Integer goodsCollectNumber;

    public UserGoods(){
        super();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public Integer getGoodsStorage() {
        return goodsStorage;
    }

    public void setGoodsStorage(Integer goodsStorage) {
        this.goodsStorage = goodsStorage;
    }

    public Integer getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(Integer goodsSale) {
        this.goodsSale = goodsSale;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Double getGoodsGrade() {
        return goodsGrade;
    }

    public void setGoodsGrade(Double goodsGrade) {
        this.goodsGrade = goodsGrade;
    }

    public Integer getGoodsGradeNumber() {
        return goodsGradeNumber;
    }

    public void setGoodsGradeNumber(Integer goodsGradeNumber) {
        this.goodsGradeNumber = goodsGradeNumber;
    }

    public Date getGoodsCreateTime() {
        return goodsCreateTime;
    }

    public void setGoodsCreateTime(Date goodsCreateTime) {
        this.goodsCreateTime = goodsCreateTime;
    }

    public boolean isGoodsState() {
        return goodsState;
    }

    public void setGoodsState(boolean goodsState) {
        this.goodsState = goodsState;
    }

    public Integer getGoodsCollectNumber() {
        return goodsCollectNumber;
    }

    public void setGoodsCollectNumber(Integer goodsCollectNumber) {
        this.goodsCollectNumber = goodsCollectNumber;
    }
}
