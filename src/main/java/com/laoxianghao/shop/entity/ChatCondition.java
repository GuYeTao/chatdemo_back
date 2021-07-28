package com.laoxianghao.shop.entity;

public class ChatCondition {
    private String chatMsg;//根据内容查找
    private Integer userId;//根据说话人查找


    public ChatCondition () {

    }

    public String getchatMsg() {
        return chatMsg;
    }

    public void setchatMsg(String chatMsg) {
        if(chatMsg!=null){
            if(chatMsg.equals("")){
                this.chatMsg = null;
            }else{
                this.chatMsg = "%"+chatMsg+"%";
            }
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
