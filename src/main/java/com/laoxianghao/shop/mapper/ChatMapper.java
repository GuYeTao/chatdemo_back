package com.laoxianghao.shop.mapper;

import com.laoxianghao.shop.entity.Chat;
import com.laoxianghao.shop.entity.ChatCondition;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatMapper {
    @Select("select * from t_chat")
    List<Chat> selectChatList();

//    按用户id查找聊天记录,也可以加上关键字
    @Select("select * from t_chat where userId=#{c.userId} and (#{c.chatMsg} is null or chatMsg like #{c.chatMsg})")
    List<Chat> selectChatByCondition(@Param("c") ChatCondition condition);


//    根据用户id找聊天记录
    @Select("select * from t_chat where userId=#{id}")
    Chat selectChatByuserId(@Param("id")Integer userId);

//    每生成对话就插入数据库
//    @Insert("insert into t_chat values(null,#{c.userId},#{c.merchantId},#{c.chatTime},#{c.chatMsg},#{c.chatWho})")
    void insertChat(@Param("c")Chat chat);

//    撤回,删库
    @Delete("delete from t_chat where chatId=#{id}")
    void deleteChatById(@Param("id")Integer chatId);

//    删除，改Del
//    购物车中修改商品数
    @Update("update t_chat set del=#{del} where chatId=#{id}")
    int updateUserDel(@Param("del") Integer del,@Param("id")Integer chatId);
}
