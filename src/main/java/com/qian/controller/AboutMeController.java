package com.qian.controller;

import com.qian.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/about")
public class AboutMeController {
    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Map<String, Object> getInfo(){
        String aboutMe = (String) redisTemplate.opsForValue().get("about_me");
        String defaultAboutMe = "**\uD83C\uDF40个人简介**\n" +
                "\n" +
                "渴望进大厂的专科大三学生狗\n" +
                "\n" +
                "承蒙关注，感谢你们的支持...";
        if (aboutMe==null){
            redisTemplate.opsForValue().set("about_me",defaultAboutMe);
            return Result.returnResult(200,"获取信息成功",defaultAboutMe);
        };
        return Result.returnResult(200,"获取信息成功",aboutMe);
    }

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public Map<String, Object> setInfo(@RequestBody Map<String, Object> postData){
//        System.out.println(postData);
        String content = (String) postData.get("content");
        redisTemplate.opsForValue().set("about_me",content);
        return Result.returnResult(200,"设置信息成功","success");
    }




}
