package com.laoxianghao.shop.util;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class JsonTools {
    public static final int SUCCESS = 0;
    public static final int DB_ERROR = 10;
    public static final int LOGIN_ERROR = 20;
    public static final int NO_LOGIN_ERROR = 21;

    public static String executeSuccess(){
        return querySuccess(null);
    }

    public static String querySuccess(String name,Object value){
        Map resultMap = new LinkedHashMap();
        resultMap.put(name, value);
        return querySuccess(resultMap);
    }
    public static String querySuccess(Map<String,Object> resultMap){
        Map map = new LinkedHashMap();
        map.put("code",0);
        map.put("result",resultMap);
        return new Gson().toJson(map);
    }

    public static  String error(int code){
        Map map = new LinkedHashMap();
        map.put("code",code);
        return new Gson().toJson(map);
    }
}
