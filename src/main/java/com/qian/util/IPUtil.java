package com.qian.util;


import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;

public class IPUtil {
    /*
    *
    *  ip查询api
    *  http://opendata.baidu.com/api.php?query=120.236.177.123&co=&resource_id=6006&t=1328693286691&ie=utf8&oe=gbk&cb=bd__cbs__hlujgn&format=json&tn=baidu
    *
    */

    public static String getIPAddress(HttpServletRequest request) throws IOException {
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        IPUtil.getIPLocation(ipAddress);
        return ipAddress+IPUtil.getIPLocation(ipAddress);
    }

    public static String getIPLocation(String ipAddress) throws IOException {
        String s = HttpUtil.get("http://opendata.baidu.com/api.php?query=" + ipAddress + "&co=&resource_id=6006&oe=utf8");
        JSONObject jsonObject = JSONUtil.parseObj(s);
        String data = jsonObject.getStr("data");
        String substring = data.substring(1,data.length()-1);
        Map map = JSONUtil.toBean(substring, Map.class);
        return (String) map.get("location");




    }



}
