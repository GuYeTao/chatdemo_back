package com.laoxianghao.shop.entity;

import java.util.Date;

public class Chat {
    private Integer chatId;
    private Integer userId;
    private Integer merchantId;
    private Date chatTime;
    private String chatMsg;
    private boolean chatWho;
    private Integer del;

    public boolean isChatWho() {
        return chatWho;
    }

    public void setChatWho(boolean chatWho) {
        this.chatWho = chatWho;
    }

    public Chat(){
        super();
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }

    public String getChatMsg() {
        return chatMsg;
    }

    public void setChatMsg(String chatMsg) {
        this.chatMsg = chatMsg;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}
