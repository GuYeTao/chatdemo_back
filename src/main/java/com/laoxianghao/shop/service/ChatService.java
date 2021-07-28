package com.laoxianghao.shop.service;

import com.laoxianghao.shop.entity.Chat;
import com.laoxianghao.shop.entity.ChatCondition;
import com.laoxianghao.shop.mapper.ChatMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    public void setMapper(ChatMapper mapper){
        this.mapper = mapper;
    }
    @Autowired
    private ChatMapper mapper;

    public PageInfo<Chat> getEmps(Integer pn, Integer rn, ChatCondition condition){
        if(pn == null)pn = 1;
        if(rn == null)rn = 10;
        PageHelper.startPage(pn,rn);
        List<Chat> list = mapper.selectChatByCondition(condition);
//        System.out.println(new Gson().toJson(list));
        PageInfo p = new PageInfo(list);
        return p;
    }

    public void addChat(Chat chat){
        this.mapper.insertChat(chat);
    }
    public void delChat(Integer chatId){
        this.mapper.deleteChatById(chatId);
    }
    public void updateUserDel(Integer del, Integer chantId){
        this.mapper.updateUserDel(del, chantId);
    }

}
