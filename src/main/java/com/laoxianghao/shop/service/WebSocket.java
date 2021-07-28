package com.laoxianghao.shop.service;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.laoxianghao.shop.entity.Chat;
import com.google.gson.JsonParseException;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket/{authorization}/{id}")
public class WebSocket {
    private Session session;
    private Integer userId;
    private Integer merchantId;

//    存放用户对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();
//    存放商家websocket对象
    private static CopyOnWriteArraySet<WebSocket> mwebSocketSet = new CopyOnWriteArraySet<WebSocket>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    //用来记录sessionId和该session进行绑定
//    用户
    private static Map<String, Session> map = new HashMap<String, Session>();
//    商家
    private static Map<String, Session> mmap = new HashMap<String, Session>();
//    用于对应用户id和sessionid
//    用户
    private static Map<Integer,String> idMap = new HashMap<Integer, String>();
//    商家
    private static Map<Integer,String> midMap = new HashMap<Integer, String>();
//    聊天对<用户,商家>
    private static Map<Integer,Integer>pair = new HashMap<Integer, Integer>();
//        聊天对<商家,用户>
    private static Map<Integer,Integer>mpair = new HashMap<Integer, Integer>();
//    用户等待队列
    private static Queue<Integer>userWait = new LinkedList<Integer>();
//    商家等待队列
    private static Queue<Integer>merchantWait = new LinkedList<Integer>();

    /**
     * 客户端与服务端连接成功
     */
    @OnOpen
    public void onOpen(Session session,@PathParam("id") Integer id,@PathParam("authorization") Integer authorization){
        Map<String,Object> message=new HashMap<String, Object>();
        if(authorization==0){
//            商家
            this.session = session;
            this.merchantId = id;
            mmap.put(session.getId(),session);
            midMap.put(merchantId,session.getId());
//            商家先上线等候
            merchantWait.add(merchantId);
            mwebSocketSet.add(this);//加入set中
            if(webSocketSet.size()==0){
                message.put("message","还没有用户上线");
                message.put("chatWho",-1);
                this.session.getAsyncRemote().sendText(new Gson().toJson(message));
            }
            else{
//                得到等待的用户
                Integer tempuserId = userWait.poll();
                System.out.println(tempuserId);
//                建立商家-用户对
                mpair.put(merchantId,tempuserId);
                System.out.println("有新商家连接加入:" + merchantId + ",当前在线人数为" + webSocketSet.size() +";"+ mwebSocketSet.size());
//                返回前端,告诉商家是哪个用户
                message.put("message","有商家上线,当前人数:"+mwebSocketSet.size());
                message.put("chatWho",-1);
                message.put("userId",tempuserId);
                message.put("merchantId",merchantId);
                this.session.getAsyncRemote().sendText(new Gson().toJson(message));
//                通知用户商家上线
                broadcast(new Gson().toJson(message));
            }
        }
        else if(authorization==1){
//            用户
            this.session = session;
            this.userId = id;
            map.put(session.getId(),session);
            idMap.put(userId,session.getId());
//            用户上线先等待
            userWait.add(userId);
            webSocketSet.add(this);
            if(mwebSocketSet.size()==0){
                message.put("message","商家还没有上线");
                message.put("chatWho",-1);
                this.session.getAsyncRemote().sendText(new Gson().toJson(message));
            }
            else{
//                得到等待的商家
                Integer tempmerchantId = merchantWait.poll();
                System.out.println(tempmerchantId);
//                建立用户-商家对
                mpair.put(userId,tempmerchantId);
                System.out.println("有新用户连接加入:" + userId + ",当前在线人数为" + webSocketSet.size() +";"+ mwebSocketSet.size());
                message.put("message","有商家上线,当前人数:"+webSocketSet.size());
                message.put("chatWho",-1);
                message.put("merchantId",tempmerchantId);
                message.put("userId",userId);
                this.session.getAsyncRemote().sendText(new Gson().toJson(message));
//                用户上线向商家广播
                mbroadcast(new Gson().toJson(message));
            }
        }
//        this.session = session;
//        this.userId = userId;
//        map.put(session.getId(), session);
//        idMap.put(userId,session.getId());
////        System.out.println(map);
//        if(webSocketSet.size()>=2){
//            message.put("message","商家忙,请稍后");
//            message.put("chatWho",-1);
//            this.session.getAsyncRemote().sendText(new Gson().toJson(message));
//        }else{
//            webSocketSet.add(this);//加入set中
//            System.out.println("有新连接加入:" + userId + ",当前在线人数为" + webSocketSet.size());
////        this.session.getAsyncRemote().sendText("恭喜" + userId + "成功连接上WebSocket(其频道号：" + session.getId() + ")-->当前在线人数为：" + webSocketSet.size());
//            message.put("message","当前人数:"+webSocketSet.size());
//            message.put("chatWho",-1);
////        this.session.getAsyncRemote().sendText(new Gson().toJson(message));
//            broadcast(new Gson().toJson(message));
//        }
    }

    /**
     * 客户端与服务端连接关闭
     */
    @OnClose
    public void onClose(Session session,@PathParam("id") Integer id,@PathParam("authorization") Integer authorization){
        if(authorization==0){
            mwebSocketSet.remove(this);
            System.out.println("有一商家连接关闭！当前商家在线人数为" + mwebSocketSet.size());
            Map<String,Object> message=new HashMap<String, Object>();
            message.put("message",id+"商家离开,当前商家人数:"+mwebSocketSet.size());
            message.put("chatWho",-1);
            broadcast(new Gson().toJson(message));
        }
        else if(authorization==1){
            webSocketSet.remove(this);
            System.out.println("有一用户连接关闭！当前用户在线人数为" + webSocketSet.size());
            Map<String,Object> message=new HashMap<String, Object>();
            message.put("message",id+"用户离开,当前用户人数:"+webSocketSet.size());
            message.put("chatWho",-1);
            mbroadcast(new Gson().toJson(message));
        }
//        webSocketSet.remove(this); //从set中删除
//        System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
//        Map<String,Object> message=new HashMap<String, Object>();
//        message.put("message",userId+"离开,当前人数:"+webSocketSet.size());
//        message.put("chatWho",-1);
//        broadcast(new Gson().toJson(message));
    }

    /**
     * 客户端与服务端连接异常
     */
    @OnError
    public void onError(Throwable error,Session session,@PathParam("id") Integer id) {
        /*
            do something for onError
            与当前客户端连接异常时
         */
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 客户端向服务端发送消息
     */
    @OnMessage
    public void onMsg(Session session,String message,@PathParam("id") Integer id,@PathParam("authorization") Integer authorization){
        System.out.println("来自客户端的消息-->" + id + ": " + message);
        Chat chatMsg = JSON.parseObject(message, Chat.class);
//        System.out.println(chatMsg.getChatMsg());
        try{
            if(authorization==0){
//                商家向用户发送
                Session fromSession = mmap.get(midMap.get(chatMsg.getMerchantId()));
                Session toSession = map.get(idMap.get(chatMsg.getUserId()));

                //发送给接受者.
                if (toSession != null) {
                    System.out.println(message);
                    fromSession.getAsyncRemote().sendText(message);
                    toSession.getAsyncRemote().sendText(message);
                } else {
                    //发送给发送者.
                    fromSession.getAsyncRemote().sendText("用户不在线上");
                }
            }
            else if(authorization==1){
//                用户向商家发送
                Session fromSession = map.get(idMap.get(chatMsg.getUserId()));
                Session toSession = mmap.get(midMap.get(chatMsg.getMerchantId()));
                System.out.println(idMap.get(chatMsg.getUserId()));
                System.out.println(idMap.get(chatMsg.getMerchantId()));

                //发送给接受者.
                if (toSession != null) {
                    System.out.println(message);
                    fromSession.getAsyncRemote().sendText(message);
                    toSession.getAsyncRemote().sendText(message);
                } else {
                    //发送给发送者.
                    fromSession.getAsyncRemote().sendText("商家不在线上");
                }
            }
////            true则用户为发送者,商家为接收者
//            if(chatMsg.isChatWho()){
////                System.out.println(session.getId());
//                Session fromSession = map.get(idMap.get(chatMsg.getUserId()));
//                Session toSession = map.get(idMap.get(chatMsg.getMerchantId()));
//                System.out.println(idMap.get(chatMsg.getUserId()));
//                System.out.println(idMap.get(chatMsg.getMerchantId()));
//
//                //发送给接受者.
//                if (toSession != null) {
//                    System.out.println(message);
//                    fromSession.getAsyncRemote().sendText(message);
//                    toSession.getAsyncRemote().sendText(message);
//                } else {
//                    //发送给发送者.
//                    fromSession.getAsyncRemote().sendText("商家不在线上");
//                }
//            }
////            商家向用户发送
//            else{
//                Session fromSession = map.get(idMap.get(chatMsg.getMerchantId()));
//                Session toSession = map.get(idMap.get(chatMsg.getUserId()));
//
//                //发送给接受者.
//                if (toSession != null) {
//                    System.out.println(message);
//                    fromSession.getAsyncRemote().sendText(message);
//                    toSession.getAsyncRemote().sendText(message);
//                } else {
//                    //发送给发送者.
//                    fromSession.getAsyncRemote().sendText("用户不在线上");
//                }
//            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    //向所有客户端发送消息（广播）
//    向用户广播
    public void broadcast(String message) {
        for (WebSocket item : webSocketSet) {
            item.session.getAsyncRemote().sendText(message);//异步发送消息.
        }
    }
//    向商家广播
    public void mbroadcast(String message) {
        for (WebSocket item : mwebSocketSet) {
            item.session.getAsyncRemote().sendText(message);//异步发送消息.
        }
    }

}

