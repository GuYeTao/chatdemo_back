package com.laoxianghao.shop.controller;

import com.laoxianghao.shop.entity.Chat;
import com.laoxianghao.shop.entity.ChatCondition;
import com.laoxianghao.shop.service.ChatService;
import com.laoxianghao.shop.util.JsonTools;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chat")
public class ChatController {
    public void setService(ChatService service){
        System.out.println("ChatControler setservice");
        this.service = service;
    }
    public ChatService getService(){
        return service;
    }

    @Autowired
    private ChatService service;
    @RequestMapping("/find.action")
    public String findAll(Integer pn, Integer rn, ChatCondition condition){
        PageInfo<Chat> p = service.getEmps(pn, rn, condition);
        List<Chat> chats = p.getList();
        long total = p.getTotal();
        Map map = new LinkedHashMap();
        map.put("chats",chats);
        map.put("total", total);
        return JsonTools.querySuccess(map);
    }
    @RequestMapping("/add.action")
    public String add(Chat chat){
        this.service.addChat(chat);
        Map map = new LinkedHashMap();
        map.put("chatId",chat.getChatId());
//        System.out.println(new Gson().toJson(map));
        return JsonTools.querySuccess(map);
//        return JsonTools.executeSuccess();
    }
    @RequestMapping("/del.action")
    public String del(Integer id){
        this.service.delChat(id);
        return JsonTools.executeSuccess();
    }
    @RequestMapping("/update.action")
    public String update(Integer del, Integer id){
        System.out.println(del+";"+id);
        this.service.updateUserDel(del, id);
        Map map = new LinkedHashMap();
        map.put("cartId",id);
        return JsonTools.querySuccess(map);
    }
}
