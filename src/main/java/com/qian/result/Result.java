package com.qian.result;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Result {
//    private int code;
//    private String msg;
//    private Map<String,Object> data;

    public static Map<String,Object> returnResult(int code,String msg,Object object){
        ConcurrentHashMap<String, Object> result = new ConcurrentHashMap<>();
        result.put("code",code);
        result.put("msg",msg);
        result.put("data",object);
        return  result;
    }
}
